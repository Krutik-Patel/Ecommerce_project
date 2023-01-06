package demo.IMT2021048;

//import ecomm.Product;
import ecomm.Globals;

public class BookSuyash extends ProductSuyash {
    public BookSuyash() {
        super();
    }

    // getters
    @Override
    public Globals.Category getCategory() {
        return Globals.Category.Book;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getProductID() {
        return productId;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    // setters
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setProductID(String productId) {
        this.productId = productId;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private String name;
    private String productId;
    private float price;
    private int quantity;
}
