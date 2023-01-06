package demo.IMT2021024;

import ecomm.Globals;

public class BookKrutik extends ProductKrutik {
    private Globals.Category category;
    private String name;
    private String productID;
    private float price;
    private int quantity;

    BookKrutik(String name, String productID, float price, int quantity) {
        this.category = Globals.Category.Book;
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public Globals.Category getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public String getProductID() {
        return this.productID;
    }

    public float getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    protected void setPrice(float price) {
        this.price = price;
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
