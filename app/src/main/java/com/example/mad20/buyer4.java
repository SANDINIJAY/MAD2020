package com.example.mad20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.mad20.buyer3.text3;

public class buyer4 extends AppCompatActivity {
    TextView textView3,textView4;
    Button button2, button3;
    DatabaseReference myref;
    FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer4);

        button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuyer3();
            }

        });

        textView3= (TextView) findViewById(R.id.textView3);
        textView4= (TextView) findViewById(R.id.textView4);

        database = FirebaseDatabase.getInstance();
        myref = database.getReference("ShopItems");

        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String Iname = dataSnapshot.child("Itemname").getValue(String.class);
                String price = dataSnapshot.child("Price").getValue(String.class);
                if (Iname.equals(buyer3.text3))
                {
                    textView3.setText(Iname);
                    textView4.setText(price);

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
    public void openbuyer3(){
        Intent intent = new Intent(this, buyer3.class);
        startActivity(intent);
    }
}
