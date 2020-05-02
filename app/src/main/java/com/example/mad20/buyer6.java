package com.example.mad20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class buyer6 extends AppCompatActivity {
        EditText editText5;
        TextView textView5,textView6;
        Button button6;
        String itemname, price,quantity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer6);

        textView5= findViewById(R.id.textView6);
        textView6=findViewById(R.id.textView6);
        editText5= findViewById(R.id.editText5);
        button6= findViewById(R.id.button6);

        Intent intent =getIntent();

        itemname=intent.getStringExtra("itemname");
        quantity = intent.getStringExtra("quantity");
        price = intent.getStringExtra("price");

        textView5.setText(itemname);
        textView6.setText(price);
        editText5.setText(quantity);

    button6.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("DataItem").child("Itemname");
            Integer uQuantity;

        }
    });

    }
}
