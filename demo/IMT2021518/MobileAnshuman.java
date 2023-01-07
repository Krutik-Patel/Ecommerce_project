package demo.IMT2021518;

import ecomm.Globals;

public class MobileAnshuman extends ProductAnshuman {
    private String name, prid; // name ,product id
    private int qty; // quantity
    private float price;

    public MobileAnshuman(String name, String prid, float price, int qty) {
        super();
        this.name = name;
        this.price = price;
        this.prid = prid;
        this.qty = qty;
    }

    // common queries to get category, unique name, price, and number available
    @Override
    public Globals.Category getCategory() {
        return Globals.Category.Mobile;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProductID() {
        return prid;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return qty;

    }

    @Override
    public void setpr(float x) // price setter
    {
        price = x;
    }

    @Override
    public void setqu(int x) // quantity setter
    {
        qty = x;
    }

    @Override
    public void setprID(String x) // product id setter
    {
        prid = x;
    }

    @Override
    public void setname(String x) // name setter
    {
        name = x;
    }

}
