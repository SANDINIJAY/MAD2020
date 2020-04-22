package com.example.mad20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class seller2 extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> arrayList;
    private ArrayAdapter adapter2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller2);

        listview =  (ListView) findViewById(R.id.list_cust);


        arrayList = new ArrayList<String>();

        arrayList.add("Shop 1");
        arrayList.add("Shop 2");
        arrayList.add("Shop 3");
        arrayList.add("Shop 4");
        arrayList.add("Shop 5");
        arrayList.add("Shop 6");
        arrayList.add("Shop 7");
        arrayList.add("Shop 8");
        arrayList.add("Shop 9");
        arrayList.add("Shop 10");
        arrayList.add("Shop 11");
        arrayList.add("Shop 12");
        arrayList.add("Shop 13");

        adapter2 = new ArrayAdapter(seller2.this, android.R.layout.simple_list_item_1, arrayList);

        listview.setAdapter(adapter2);


    }
}