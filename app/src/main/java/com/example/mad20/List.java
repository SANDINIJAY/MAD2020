package com.example.mad20;

public class List {

    String listID;
    String item1;
    String item2;
    String item3;
    String item4;

    public List(){


    }
    public List(String listID,String item1,String item2,String item3,String item4){
        this.listID = listID;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
    }

    public String getListID() {
        return listID;
    }

    public String getItem1() {
        return item1;
    }

    public String getItem2() {
        return item2;
    }

    public String getItem3() {
        return item3;
    }

    public String getItem4() {
        return item4;
    }
}
