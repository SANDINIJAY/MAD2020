package com.example.liber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button buyer;
     Button seller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buyer = (Button) findViewById(R.id.buyer);
        buyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(MainActivity.this,select.class);
                startActivity(in);
            }
        });

        seller = (Button) findViewById(R.id.seller);
        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(MainActivity.this,select.class);
                startActivity(in);
            }
        });
    }
}
