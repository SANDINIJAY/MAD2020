package com.example.mad20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class buyer2 extends AppCompatActivity {



    private Button button8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer2);

        button8 = (Button) findViewById(R.id.button8);

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuyer3();
            }
        });
    }

            public void openbuyer3() {
                Intent intent = new Intent(this, buyer3.class);
                startActivity(intent);
            }


        }

