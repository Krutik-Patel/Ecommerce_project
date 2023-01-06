package demo.IMT2021518;

import java.util.*;

import ecomm.Platform;
import ecomm.Product;
import ecomm.Seller;
import ecomm.Globals;

public class SellerAnshuman extends Seller {
    private ArrayList<Platform> pform = new ArrayList<>(); // list of platforms the seller is connected to
    private ArrayList<ProductAnshuman> products = new ArrayList<>(); // list of products the seller has

    public SellerAnshuman(String id) {
        super(id);
        MobileAnshuman mob1 = new MobileAnshuman("Iphone13", this.getID() + "-Iphone13", 80000, 100);
        MobileAnshuman mob2 = new MobileAnshuman("GalaxyS31", this.getID() + "-GalaxyS31", 20000, 100);
        MobileAnshuman mob3 = new MobileAnshuman("Motorola", this.getID() + "-Motorola", 18000, 100);
        MobileAnshuman mob4 = new MobileAnshuman("GalaxyF23", this.getID() + "-GalaxyF23", 17000, 100);
        products.add(mob1);
        products.add(mob2);
        products.add(mob3);
        products.add(mob4);

        BookAnshuman bk1 = new BookAnshuman("ProgrammingJAVA", this.getID() + "-ProgrammingJAVA", 500, 100);
        BookAnshuman bk2 = new BookAnshuman("ProgrammingCPP", this.getID() + "-ProgrammingCPP", 500, 100);
        products.add(bk1);
        products.add(bk2);

    }

    public void addPlatform(Platform thePlatform) {
        pform.add(thePlatform); // platform added
        boolean result = thePlatform.addSeller(this); // seller added to platform
        if (result)
            System.out.println("Seller " + this.getID() + " added to platform");
        else
            System.out.println("Failed to add seller " + this.getID());
    }

    public ArrayList<Product> findProducts(Globals.Category whichOne) {
        ArrayList<Product> list = new ArrayList<>();
        //
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCategory().equals(whichOne)) // finding the given category products
                list.add(products.get(i));
        }
        return list;
    }

    public boolean buyProduct(String prid, int q) {
        boolean result = false; // if quantity available
        boolean found = false; // if product with id found
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductID().equals(prid)) {
                found = true; // product found
                int qaval = products.get(i).getQuantity();
                if (qaval >= q) {
                    result = true;
                    setquantity(products.get(i), products.get(i).getQuantity() - q); // remaining quantity of product
                                                                                     // with the seller
                    System.out.println(
                            "# Left=" + products.get(i).getQuantity() + " Asked=" + q + ": Purchase Successful");
                } else {
                    System.out.println("# Left=" + products.get(i).getQuantity() + " Asked=" + q + ": Purchase Failed");
                }

                products.get(i).setpr((float) (products.get(i).getPrice() * ((Math.random()))));
            }
        }
        return result && found;
    }

    // User wants to buy specified quantity of productID
    // Return true if transaction succeeds, false otherwise.
    // Transaction fails if incorrect productID or quantity exceeds available
    // inventory
    void setprice(ProductAnshuman p, int x) {
        p.setpr(x); // seller can set the price
    }

    void setquantity(ProductAnshuman p, int x) {
        p.setqu(x); // seller can set the quantity
    }

}
