package com.example.mad20;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class buyer4 extends AppCompatActivity {
    TextView textView3,textView4;
    EditText editText2;
    Button button2, button3;
   DatabaseReference myref;
   DatabaseReference myref2;
   FirebaseDatabase database;
    DataItem dataitem;
    long maxid=0;


    public static   String text4 ;
    public static   String text5 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer4);

        button3 = (Button) findViewById(R.id.button3);

        textView3= (TextView) findViewById(R.id.textView3);
        textView4= (TextView) findViewById(R.id.textView4);
        editText2= (EditText) findViewById(R.id.editText2);
        button2= (Button) findViewById(R.id.button2);
        dataitem = new DataItem();
        
    myref2.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        if (dataSnapshot.exists()){
            maxid=(dataSnapshot.getChildrenCount());
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

        database = FirebaseDatabase.getInstance();
        myref = database.getReference("ShopItems");
        myref2 = FirebaseDatabase.getInstance().getReference().child("DataItem");
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                int Quantity=Integer.parseInt(editText2.getText().toString().trim());
                String Price = ((buyer4.text5));


                dataitem.setItemname(buyer4.text4);
                dataitem.setPrice(Price);
                dataitem.setQuantity(Quantity);

            myref2.child(String.valueOf(maxid+1)).setValue(dataitem);
                Toast.makeText(buyer4.this ,"Data Inserted",Toast.LENGTH_SHORT).show();

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuyer3();
            }

        });

        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String Iname = dataSnapshot.child("Itemname").getValue(String.class);
                String price = dataSnapshot.child("Price").getValue(String.class);
                if (Iname.equals(buyer3.text3))
                {
                    textView3.setText(Iname);
                    textView4.setText(price);

                    text4=Iname;
                    text5=price;

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
