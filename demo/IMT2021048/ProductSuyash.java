package demo.IMT2021048;

import ecomm.Product;
//import ecomm.Globals;

public abstract class ProductSuyash extends Product {
    //extra setters which are not there in Product class 
    public abstract void setName(String name);

    public abstract void setProductID(String productId);

    public abstract void setPrice(float price);

    public abstract void setQuantity(int quantity);
};
