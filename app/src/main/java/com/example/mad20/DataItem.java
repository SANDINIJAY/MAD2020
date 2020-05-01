package com.example.mad20;

public class DataItem {
   String Itemname ;
     String Price;
     Integer Quantity;



    public DataItem(String Itemname, String Price, Integer Quantity){
        this.Itemname= Itemname;
        this.Price=Price;
        this.Quantity=Quantity;
    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String itemname) {
        Itemname = itemname;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public DataItem() {
    }

}
