package demo.IMT2021024;

import ecomm.Globals;
import ecomm.Product;

public abstract class ProductKrutik extends Product {

    // all five methods getCategory, getName, getProductID, getPrice, getQuantity
    // are methods inherited
    public abstract Globals.Category getCategory();

    public abstract String getName();

    public abstract String getProductID();

    public abstract float getPrice();

    public abstract int getQuantity();

    // new methods to let the seller change the quantity and price of a product
    protected abstract void setQuantity(int quantity);

    // new methods to let the seller change the quantity and price of a product
    protected abstract void setPrice(float price);
}
