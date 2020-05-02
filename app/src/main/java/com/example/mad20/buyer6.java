package com.example.mad20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class buyer6 extends AppCompatActivity {
        EditText editText5;
        TextView textView5,textView6;
        Button button7;
        String itemname, price,quantity;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer6);

        textView5= findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        editText5= findViewById(R.id.editText5);
        button7= findViewById(R.id.button7);

        Intent intent =getIntent();

        itemname=intent.getStringExtra("itemname");
         price= intent.getStringExtra("price");
        quantity = intent.getStringExtra("quantity");

        textView5.setText(itemname);
        textView6.setText(price);
        editText5.setText(quantity);

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("DataItems").child(valueOf(buyer4.text6));
                String uquantity;
                uquantity=editText5.getText().toString();
                buyer6 buyer6= new buyer6();
                databaseReference.setValue(buyer6);
                Toast.makeText(buyer6.this ,"Data Updated",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private String valueOf(long text6) {
        return String.valueOf((buyer4.text6));
    }

    public void openbuyer6(){
        Intent intent = new Intent(this, buyer6.class);
        startActivity(intent);
    }

}
