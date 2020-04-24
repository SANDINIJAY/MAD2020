package com.example.mad20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class buyercity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button;


    public static   String text1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyercity);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbuyer2();
            }

        });


        Spinner spinner = findViewById((R.id.spinner1));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Towns, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       text1 = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(),text1,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openbuyer2(){
        Intent intent = new Intent(this, buyer2.class);
        startActivity(intent);
    }
}