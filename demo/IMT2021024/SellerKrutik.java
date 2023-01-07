package demo.IMT2021024;

import ecomm.Seller;
import ecomm.Globals.Category;
import java.util.*;

import ecomm.Globals;
import ecomm.Platform;
import ecomm.Product;

public class SellerKrutik extends Seller {
    ArrayList<ProductKrutik> mobileList;
    ArrayList<ProductKrutik> bookList;

    public SellerKrutik(String id) {

        // assigns the unique id while initializing
        super(id);

        // initialize the lists
        mobileList = new ArrayList<>();
        bookList = new ArrayList<>();

        // create books - Products of SellerKrutik
        BookKrutik book1 = new BookKrutik("Angry_Birds", this.getID() + "-Angry_Birds", (float) 50.00, 5);
        BookKrutik book2 = new BookKrutik("Adams_apple", this.getID() + "-Adams_apple", (float) 20.00, 40);
        BookKrutik book3 = new BookKrutik("CLRS", this.getID() + "-CLRS", (float) 40.00, 3);
        BookKrutik book4 = new BookKrutik("JET_JET", this.getID() + "-JET_JET", (float) 10.00, 10);

        // add books to booklist
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        // create mobiles - Mobiles availavble with seller
        MobileKrutik mob1 = new MobileKrutik("Iphone_11", this.getID() + "-Iphone_11", (float) 10000.50, 15);
        MobileKrutik mob2 = new MobileKrutik("Iphone_12", this.getID() + "-Iphone_12", (float) 20000.50, 99);
        MobileKrutik mob3 = new MobileKrutik("Iphone_13++", this.getID() + "-Iphone_13++", (float) 50000.00, 50);
        MobileKrutik mob4 = new MobileKrutik("Iphone_14++", this.getID() + "-Iphone_14++", (float) 150000.50, 70);

        // add mobiles to mobileList
        mobileList.add(mob1);
        mobileList.add(mob2);
        mobileList.add(mob3);
        mobileList.add(mob4);
    }

    public void addPlatform(Platform thePlatform) {
        // adding the seller in the platform
        thePlatform.addSeller(this);

        // debug message
        System.out.println("Seller " + this.getID() + " added to platform");
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne) {

        // finds the category of the product and passes the copy of the arrayList
        // according to that
        if (whichOne == Category.Mobile) {
            ArrayList<Product> copyMobileList = new ArrayList<>(mobileList);
            return copyMobileList;
        } else {
            ArrayList<Product> copyBookList = new ArrayList<>(bookList);
            return copyBookList;
        }
    }

    public boolean buyProduct(String productID, int quantity) {
        // searches through the mobileList and the bookList to find the particular
        // product having the unique id
        for (ProductKrutik prod : mobileList) {

            if (prod.getProductID().equals(productID)) {

                // debug message
                System.out.println(prod.getProductID() + " " + (prod.getProductID().equals(productID)));

                // returns true only if the quantity is enough to be sold
                // if the quantity is not enough, debug message is printed on platform terminal
                // else if quantity is enough, reduced the quantity and changes the price
                if (prod.getQuantity() >= quantity) {

                    // changing the quantity
                    prod.setQuantity(prod.getQuantity() - quantity);

                    // debug message
                    System.out.println("# Left=" + prod.getQuantity() + " Asked=" + quantity + ": Purchase Successful");

                    // changing the price
                    prod.setPrice((float) (prod.getPrice() * (0.5 + (Math.random()))));

                    return true;
                } else {

                    // debug message
                    System.out.println("# Left=" + prod.getQuantity() + " Asked" + quantity + ": Purchase Failed");
                    return false;
                }
            }
        }

        // searches the bookList for the required book with the productID
        for (ProductKrutik prod : bookList) {

            if (prod.getProductID().equals(productID)) {

                // debug message
                System.out.println(prod.getProductID() + " " + (prod.getProductID().equals(productID)));

                // returns true only if the quantity is enough to be sold
                // if the quantity is not enough, debug message is printed on platform terminal
                // else if quantity is enough, reduced the quantity and changes the price
                if (prod.getQuantity() >= quantity) {

                    // changing the quantity
                    prod.setQuantity(prod.getQuantity() - quantity);

                    // debug message
                    System.out.println("# Left=" + prod.getQuantity() + " Asked=" + quantity + ": Purchase Successful");

                    // changing the price
                    prod.setPrice((float) (prod.getPrice() * (0.5 + (Math.random()))));

                    return true;
                } else {

                    // debug message
                    System.out.println("# Left=" + prod.getQuantity() + " Asked=" + quantity + ": Purchase Falied");
                    return false;
                }
            }
        }
        return false;
    }
}
