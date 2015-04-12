package my.ebizapp.model;

import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
public class CartBasic {


    private Product product;

    private float priceSnapshot;

    private long quantity;

    private Date time = new Date();

    public CartBasic(Product product, float priceSnapshot, long quantity, Date time) {
        this.product = product;
        this.priceSnapshot = priceSnapshot;
        this.quantity = quantity;
        this.time = time;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getPriceSnapshot() {
        return priceSnapshot;
    }

    public void setPriceSnapshot(float priceSnapshot) {
        this.priceSnapshot = priceSnapshot;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
