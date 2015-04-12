package my.ebizapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false)
    private Customer customer;

    private float priceSnapshot;

    private long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time = new Date();

    @Column(nullable = false)
    private boolean shipped = false;

    public Order(Product product, Customer customer, float priceSnapshot, long quantity) {
        this.product = product;
        this.customer = customer;
        //customized price and quantity handler
        this.priceSnapshot = product.getPrice();
        this.quantity = quantity;
        product.setStockQuantity(product.getStockQuantity() - this.quantity);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public boolean isShipped() {
        return shipped;
    }

    public void setShipped(boolean shipped) {
        this.shipped = shipped;
    }
}
