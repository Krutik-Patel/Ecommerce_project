package demo.IMT2021024;

import ecomm.Globals;
import ecomm.Product;
import ecomm.Globals.Category;

public abstract class ProductKrutik extends Product {

    public abstract Globals.Category getCategory();

    public abstract String getName();

    public abstract String getProductID();

    public abstract float getPrice();

    public abstract int getQuantity();

    protected abstract void setQuantity(int quantity);

    protected abstract void setPrice(float price);
}
