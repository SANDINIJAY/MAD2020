package com.example.mad20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class buyer3 extends AppCompatActivity {

    public static String text2 ;

   private ListView listView2;

   FirebaseDatabase database;
    DatabaseReference myRef;

   private ArrayList<String> Itemname = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer3);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("ShopItems");



        listView2= (ListView) findViewById(R.id.listView2);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Itemname);
        listView2.setAdapter(arrayAdapter);

       listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent myintent2 = new Intent (view.getContext(), buyer4.class);
                startActivityForResult(myintent2,0);
            }
        });


       myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
              String value2 = dataSnapshot.child("Itemname").getValue(String.class);
              String Shop = dataSnapshot.child("Shopname").getValue(String.class);
               if (Shop.equals(buyer2.text2))
               {
                     Itemname.add(value2);
                  arrayAdapter.notifyDataSetChanged();


               }

          }

            @Override
            public void onChildChanged( DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

}

    }

