package com.example.mad20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

public class Itemadapter extends RecyclerView.Adapter<Itemadapter.MyViewHolder> {

    private Context context;
    private ArrayList<DataItem> dataItems;

    public Itemadapter(Context c,ArrayList<DataItem> dataItems){
        this .context= c;
        this.dataItems=dataItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
         DataItem dataItems=this.dataItems.get(position);


        holder.Itemname.setText(String.valueOf(dataItems.getItemname()));
        holder.Price.setText(String.valueOf(dataItems.getPrice()));
        holder.Quantity.setText(String.valueOf(dataItems.getQuantity()));
        holder.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("DataItem").child(valueOf(buyer4.text6));
                databaseReference.removeValue();
                Toast.makeText(context,"Item Deleted",Toast.LENGTH_SHORT).show();
            }
        });
        /*
        holder.button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
          Intent i = new Intent (context, buyer6.class);
          i.putExtra("Quantity",dataItems.getQuantity());
          v.getContext().startActivity(i);

            }

        });
        */
    }

    private String valueOf(long text6) {
        return String.valueOf((buyer4.text6));
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Itemname,Price,Quantity;
        Button button5,button6;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Itemname=itemView.findViewById(R.id.Itemname);
            Price=itemView.findViewById(R.id.Price);
            Quantity=itemView.findViewById(R.id.Quantity);
            button5=itemView.findViewById(R.id.button5);
            button6= itemView.findViewById(R.id.button6);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
