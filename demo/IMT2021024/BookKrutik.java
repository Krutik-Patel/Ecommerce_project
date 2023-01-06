package demo.IMT2021024;

import ecomm.Globals;

public class BookKrutik extends ProductKrutik {

    // private data members
    private Globals.Category category; // Mobile or Book: Category, set to book when initalized
    private String name; // name of the book
    private String productID; // productID of the book
    private float price; // price of the book
    private int quantity; // quantity of the book available with the seller

    // constructor
    BookKrutik(String name, String productID, float price, int quantity) {
        this.category = Globals.Category.Book;
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    // getter and setter methods
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
