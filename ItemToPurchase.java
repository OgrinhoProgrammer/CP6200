package com.cp6200;

public class ItemToPurchase
{
    private String itemName;
    private int itemPrice;
    private int itemQuantity;
    private String itemDescription;


    public ItemToPurchase()
    {
        itemName = "none";
        itemPrice = 0;
        itemQuantity = 0;
        itemDescription = "none";
    }

    public void setName(String itemName)
    {
        this.itemName = itemName;
    }

    public void setPrice(int itemPrice)
    {
        this.itemPrice = itemPrice;
    }

    public void setQuantity(int itemQuantity)
    {
        this.itemQuantity = itemQuantity;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    public String getName()
    {
        return itemName;
    }

    public int getPrice()
    {
        return itemPrice;
    }

    public int getQuantity()
    {
        return itemQuantity;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }
}