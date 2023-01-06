package demo.IMT2021048;

import java.util.*;
import ecomm.Seller;
import ecomm.Product;
import ecomm.Platform;
import ecomm.Globals;

public class SellerSuyash extends Seller {

    public SellerSuyash(String Id) {
        super(Id);
        // creating book objects for my seller i.e. SellerSuyash
        ProductSuyash book1 = new BookSuyash();
        book1.setName("Atomic_Habits");
        book1.setProductID(this.getID() + "-Atomic_Habits");
        book1.setPrice((float) 350.00);
        book1.setQuantity(13);
        bookList.add(book1);

        ProductSuyash book2 = new BookSuyash();
        book2.setName("Secret_Garden");
        book2.setProductID(this.getID() + "-Secret_Garden");
        book2.setPrice((float) 180.00);
        book2.setQuantity(35);
        bookList.add(book2);

        ProductSuyash book3 = new BookSuyash();
        book3.setName("Ikigai");
        book3.setProductID(this.getID() + "-Ikigai");
        book3.setPrice((float) 180.00);
        book3.setQuantity(9);
        bookList.add(book3);

        // creating mobile objects for my seller i.e. SellerSuyash
        ProductSuyash mobile1 = new MobileSuyash();
        mobile1.setName("Realme_Pro");
        mobile1.setProductID(this.getID() + "-Realme_Pro");
        mobile1.setPrice((float) 10999.00);
        mobile1.setQuantity(15);
        mobileList.add(mobile1);

        ProductSuyash mobile2 = new MobileSuyash();
        mobile2.setName("Galaxy_M4");
        mobile2.setProductID(this.getID() + "-Galaxy_M4");
        mobile2.setPrice((float) 9500.00);
        mobile2.setQuantity(5);
        mobileList.add(mobile2);

        ProductSuyash mobile3 = new MobileSuyash();
        mobile3.setName("Moto_G72");
        mobile3.setProductID(this.getID() + "-Moto_G72");
        mobile3.setPrice((float) 13999.00);
        mobile3.setQuantity(7);
        mobileList.add(mobile3);

    }

    // Platform it is being added to.
    // Should in turn add itself to the Platform (with addSeller)
    @Override
    public void addPlatform(Platform thePlatform) {
        thePlatform.addSeller(this);
        System.out.println("Seller " + this.getID() + " added to platform");
    }

    // Seller to return listing of mobileList of specified Category
    @Override
    public ArrayList<Product> findProducts(Globals.Category whichOne) {
        if (whichOne == Globals.Category.Mobile) {
            ArrayList<Product> copyMobileList = new ArrayList<>(mobileList);
            return copyMobileList;
        } else {
            ArrayList<Product> copyBookList = new ArrayList<>(bookList);
            return copyBookList;
        }
    }

    // User wants to buy specified quantity of productID
    // Return true if transaction succeeds, false otherwise.
    // Transaction fails if incorrect productID or quantity exceeds available
    // inventory
    @Override
    public boolean buyProduct(String productID, int quantity) {
        boolean buyable = false;
        boolean found = false;
        // checking that given portalID is of any mobile or not in mobileList
        for (int mobile = 0; mobile < mobileList.size(); mobile++) {
            if (mobileList.get(mobile).getProductID().equals(productID)) {
                found = true;
                int avalquan = mobileList.get(mobile).getQuantity();
                if (avalquan >= quantity) {
                    buyable = true;
                    mobileList.get(mobile).setQuantity(avalquan - quantity);
                    System.out.println("# Left=" + mobileList.get(mobile).getQuantity() + " Asked=" + quantity
                            + ": Purchase Successful");
                } else {
                    System.out.println("# Left=" + mobileList.get(mobile).getQuantity() + " Asked=" + quantity
                            + ": Purchase Failed");
                }
                mobileList.get(mobile).setPrice((float) (mobileList.get(mobile).getPrice() * (1 + (Math.random()))));
            }
        }

        // checking that given portalID is of any book or not in bookList
        for (int book = 0; book < bookList.size(); book++) {
            if (bookList.get(book).getProductID().equals(productID)) {
                found = true;
                int avalquan = bookList.get(book).getQuantity();
                if (avalquan >= quantity) {
                    buyable = true;
                    bookList.get(book).setQuantity(avalquan - quantity);
                    System.out.println("# Left=" + bookList.get(book).getQuantity() + " Asked=" + quantity
                            + ": Purchase Successful");
                } else {
                    System.out.println("# Left=" + bookList.get(book).getQuantity() + " Asked=" + quantity
                            + ": Purchase Failed");
                }
                bookList.get(book).setPrice((float) (bookList.get(book).getPrice() * (1 + (Math.random()))));

            }
        }

        return buyable && found;
    }

    private ArrayList<ProductSuyash> mobileList = new ArrayList<>(); // list of all mobile objects
    private ArrayList<ProductSuyash> bookList = new ArrayList<>(); // list of all book objects
    // private String myID;
}
