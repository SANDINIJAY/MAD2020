package com.example.mad20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class buyer2 extends AppCompatActivity {


    private  ListView listView1;

    public static   String text1 ;
    public static String text2;


    FirebaseDatabase database;
    DatabaseReference myRef;
    private ArrayList<String> Shopname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer2);



        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("CityShop");



        listView1= (ListView) findViewById(R.id.listView1);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Shopname);
       listView1.setAdapter(arrayAdapter);
       listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               text2 = parent.getItemAtPosition(position).toString();

               Intent myintent = new Intent (view.getContext(), buyer3.class);
               startActivityForResult(myintent,0);
           }
       });


        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded( DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.child("Shopname").getValue(String.class);
                String City = dataSnapshot.child("Cityname").getValue(String.class);

                if (City.equals(buyercity.text1)) {

                    Shopname.add(value);
                    arrayAdapter.notifyDataSetChanged();

                    text2 = value ;

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

