package com.treydev.idk;

import java.util.ArrayList;

public class Items {
    public Items(String name, short quantity, String description)
    {
        this.name=name;
        this.quantity=quantity;
        this.description=description;
    }
    public String name;
    public short quantity;
    public String description;
    public static ArrayList<Items> inventory;
}
