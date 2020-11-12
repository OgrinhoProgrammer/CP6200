package com.cp6200;

import java.util.Scanner;

public class ShoppingCartManager {
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter Customer's Name:");
        String usrName = scnr.nextLine();

        System.out.println("Enter Today's Date:");
        String usrDate = scnr.nextLine();
        System.out.println();

        ShoppingCart usrCart = new ShoppingCart(usrName, usrDate);

        System.out.println("Customer Name: " + usrCart.getCustomerName());
        System.out.println("Today's Date: " + usrCart.getDate());

        printMenu(usrCart);

    }

    public static void printMenu(ShoppingCart shoppingCart)
    {
        Scanner scnr = new Scanner(System.in);

        String menu = "\nMENU\n" +
                "a - Add item to cart\n" +
                "d - Remove item from cart\n" +
                "c - Change item quantity\n" +
                "i - Output items' descriptions\n" +
                "o - Output shopping cart\n" +
                "q - Quit";

        System.out.println(menu);

        while (true)
        {
            System.out.println("\nChoose an option:");

            char usrChoice = scnr.next().charAt(0);
            scnr.nextLine();

            if (usrChoice == 'q')
            {
                System.out.println();
                return;
            }

            if (usrChoice == 'o')
            {
                System.out.println("OUTPUT SHOPPING CART");
                shoppingCart.printTotal();
                System.out.print("\n" + menu);
            }

            if (usrChoice == 'i')
            {
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                shoppingCart.printDescription();
                System.out.print("\n" + menu);
            }

            if (usrChoice == 'c')
            {
                String change;

                ItemToPurchase changeItem = new ItemToPurchase();

                System.out.println("CHANGE ITEM QUANTITY");

                System.out.println("Enter the item name:");
                change = scnr.nextLine();
                changeItem.setName(change);
                System.out.println("Enter the new quantity:");
                changeItem.setQuantity(scnr.nextInt());

                shoppingCart.modifyItem(changeItem);
                System.out.print("\n" + menu);
            }

            if (usrChoice == 'd')
            {
                System.out.println("REMOVE ITEM FROM CART");

                System.out.println("Enter the name of item to remove:");
                shoppingCart.removeItem(scnr.nextLine());
            }

            if(usrChoice == 'a')
            {
                ItemToPurchase newItem = new ItemToPurchase();

                System.out.println("ADD ITEM TO CART");

                System.out.println("Enter the item name:");
                newItem.setName(scnr.nextLine());

                System.out.println("Enter the item description:");
                newItem.setItemDescription(scnr.nextLine());


                System.out.println("Enter the item price:");
                newItem.setPrice(scnr.nextInt());

                System.out.println("Enter the item quantity:");
                newItem.setQuantity(scnr.nextInt());

                shoppingCart.addItem(newItem);
                System.out.print("\n" + menu);
            }
        }
    }
}
