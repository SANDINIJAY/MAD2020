package com.example.mad20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.Itemname.setText(dataItems.getItemname());
        holder.Price.setText(dataItems.getPrice());
        holder.Quantity.setText(dataItems.getQuantity());
    }

    @Override
    public int getItemCount() {
        return dataItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Itemname,Price,Quantity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Itemname=itemView.findViewById(R.id.Itemname);
            Price=itemView.findViewById(R.id.Price);
            Quantity=itemView.findViewById(R.id.Quantity);
        }
    }
}
