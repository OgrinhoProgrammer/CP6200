package com.cp6200;

import java.util.ArrayList;

public class ShoppingCart {
    private String customerName;
    private String currentDate;
    ArrayList<ItemToPurchase> cartItems = new ArrayList<>();

    public ShoppingCart()
    {
        customerName = "none";
        currentDate = "January, 1 2016";
    }

    public ShoppingCart(String customerName, String currentDate)
    {
        this.customerName = customerName;
        this.currentDate = currentDate;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public String getDate()
    {
        return currentDate;
    }

    public void addItem(ItemToPurchase itemToPurchase)
    {
        cartItems.add(itemToPurchase);
    }

    public void removeItem(String itemName)
    {
        int itemCount = 0;

        for(int i = 0; i < cartItems.size(); i++)
        {
            if (cartItems.get(i).getName().equalsIgnoreCase(itemName))
            {
                cartItems.remove(i);
                itemCount++;
            }
        }

        if(itemCount == 0)
        {
            System.out.println("Item not found in cart. Nothing removed.");
        }
    }

    public void modifyItem(ItemToPurchase itemToPurchase)
    {
        int itemCount = 0;
        for (int i = 0; i < cartItems.size(); i++)
        {
            if (cartItems.get(i).getName().equals(itemToPurchase.getName()))
            {
                cartItems.get(i).setQuantity(itemToPurchase.getQuantity());
                itemCount++;
            }
        }

        if (itemCount == 0)
        {
            System.out.println("Item not found in cart. Nothing modified.");
        }
    }

    public int getNumItemsInCart()
    {
        int itemCount = 0;

        for (int i = 0; i < cartItems.size(); i++)
        {
            itemCount += cartItems.get(i).getQuantity();
        }

        return itemCount;
    }

    public double getCostOfCart()
    {
        double total = 0;

        for (int i = 0; i < cartItems.size(); i++)
        {
                total += (cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
        }

        return total;
    }

    public void printTotal()
    {
        System.out.println(customerName + " Shopping Cart - " + currentDate);
        System.out.println("Number of items: " + getNumItemsInCart());
        System.out.println();

        for (int i = 0; i < cartItems.size(); i++)
        {
            System.out.println(cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity() +
                    " @ " + cartItems.get(i).getPrice() + " = " + "$" + cartItems.get(i).getPrice() * cartItems.get(i).getQuantity());
        }

        if(getNumItemsInCart() > 0)
            System.out.println("Total: $" + getCostOfCart());
        else
            System.out.println("SHOPPING CART IS EMPTY\n");
    }

    public void printDescription()
    {
        System.out.println(customerName + " Shopping Cart - " + currentDate);

        for (int i = 0; i < cartItems.size(); i++)
        {
            System.out.println(cartItems.get(i).getName() + ": " + cartItems.get(i).getItemDescription());
        }
    }
}
