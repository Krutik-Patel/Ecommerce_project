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
        super(id);
        mobileList = new ArrayList<>();
        bookList = new ArrayList<>();
        BookKrutik book1 = new BookKrutik("Angry_Birds", this.getID() + "-Angry_Birds", (float) 50.00, 5);
        BookKrutik book2 = new BookKrutik("Adams_apple", this.getID() + "-Adams_apple", (float) 20.00, 40);
        BookKrutik book3 = new BookKrutik("CLRS", this.getID() + "-CLRS", (float) 40.00, 3);
        BookKrutik book4 = new BookKrutik("JET_JET", this.getID() + "-JET_JET", (float) 10.00, 10);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        MobileKrutik mob1 = new MobileKrutik("Iphone_11", this.getID() + "-Iphone_11", 10000, 15);
        MobileKrutik mob2 = new MobileKrutik("Iphone_12", this.getID() + "-Iphone_12", 20000, 99);
        MobileKrutik mob3 = new MobileKrutik("Iphone_13++", this.getID() + "-Iphone_13++", 50000, 50);
        MobileKrutik mob4 = new MobileKrutik("Iphone_14++", this.getID() + "-Iphone_14++", 150000, 70);
        mobileList.add(mob1);
        mobileList.add(mob2);
        mobileList.add(mob3);
        mobileList.add(mob4);
    }

    public void addPlatform(Platform thePlatform) {
        thePlatform.addSeller(this);
        System.out.println("Seller " + this.getID() + " added to platform");
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne) {
        if (whichOne == Category.Mobile) {
            ArrayList<Product> copyMobileList = new ArrayList<>(mobileList);
            return copyMobileList;
        } else {
            ArrayList<Product> copyBookList = new ArrayList<>(bookList);
            return copyBookList;
        }
    }

    public boolean buyProduct(String productID, int quantity) {
        // System.out.println("###buyProduct__[SELLER METHOD]__");
        // System.out.println("\nCandidates: Mobile " + mobileList.size());
        for (ProductKrutik prod : mobileList) {
            if (prod.getProductID().equals(productID)) {
                System.out.println(prod.getProductID() + " " + (prod.getProductID().equals(productID)));
                if (prod.getQuantity() >= quantity) {
                    prod.setQuantity(prod.getQuantity() - quantity);
                    System.out.println("# Left=" + prod.getQuantity() + " Asked=" + quantity + ": Purchase Successful");
                    return true;
                } else {
                    System.out.println("# Left=" + prod.getQuantity() + " Asked" + quantity + ": Purchase Failed");
                    return false;
                }
            }
        }
        // System.out.println("Candidates: Book " + bookList.size());
        for (ProductKrutik prod : bookList) {
            if (prod.getProductID().equals(productID)) {
                System.out.println(prod.getProductID() + " " + (prod.getProductID().equals(productID)));
                if (prod.getQuantity() >= quantity) {
                    System.out.println("# Left=" + prod.getQuantity() + " Asked=" + quantity + ": Purchase Successful");
                    prod.setQuantity(prod.getQuantity() - quantity);
                    return true;
                } else {
                    System.out.println("# Left=" + prod.getQuantity() + " Asked=" + quantity + ": Purchase Falied");
                    return false;
                }
            }
        }
        // System.out.println("\n# no match for productID___ TO_FIND=\"" + productID +
        // "\" SELLER_ID=" + this.getID());
        return false;
    }
}
