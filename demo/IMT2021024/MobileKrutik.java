package demo.IMT2021024;

import ecomm.Globals;

public class MobileKrutik extends ProductKrutik {

    // private data members
    private Globals.Category category; // Mobile or Book: Category - set to mobile when intialized
    private String name; // name of product
    private String productID; // productID of the product
    private float price; // price of the product
    private int quantity; // quantity available with the seller

    // constructor
    MobileKrutik(String name, String productID, float price, int quantity) {
        this.category = Globals.Category.Mobile;
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    // getters and setter methods

    @Override
    public Globals.Category getCategory() {
        return this.category;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getProductID() {
        return this.productID;
    }

    @Override
    public float getPrice() {
        return this.price;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    protected void setPrice(float price) {
        this.price = price;
    }

    @Override
    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
