package com.example.mad20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.service.autofill.UserData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class buyer5 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<DataItem> dataItems;
    private Itemadapter itemadapter;

    DatabaseReference myref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer5);

        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataItems=new ArrayList<DataItem>();

        myref2= FirebaseDatabase.getInstance().getReference().child("DataItem");
        myref2.addListenerForSingleValueEvent(valueEventListener);

    }
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
            DataItem idata = dataSnapshot1.getValue(DataItem.class);
            dataItems.add(idata);
        }
        itemadapter= new Itemadapter(buyer5.this,dataItems);
        recyclerView.setAdapter(itemadapter);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
};
}
