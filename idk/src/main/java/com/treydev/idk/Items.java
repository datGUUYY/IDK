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
    public static String consume(String name)
    {
       Items item = findByName(name);
       item.quantity--;
       if(item.quantity < 1) //0, or, somehow, negative
            inventory.remove(item);
        return "You consumed a " + name;
    }
    public static Items findByName(String name)
    {
        for(Items item : Items.inventory)
            if(item.name.equals(name))
                return item;
        return null; //TODO: be... worried about this I guess?
    }
    public static void InitializeStubbedInventory()
    {
        if(inventory == null)
        {
             inventory = new ArrayList<Items>();
             inventory.add(new Items("Red Potion", (short) 15, "Smells kinda fishy"));
             inventory.add(new Items("Pink Potion", (short) 11, "Smells kinda beefy"));
        }
    }
}
