package my.ebizapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
@Entity
public class Cart {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(optional = false)
    private Product product;

    @ManyToOne(optional = false)
    private Customer customer;

    @Column(nullable = false)
    private float priceSnapshot;

    @Column(nullable = false)
    private long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time = new Date();

    public Cart(Product product, Customer customer, float priceSnapshot, long quantity) {
        this.product = product;
        this.customer = customer;
        this.priceSnapshot = priceSnapshot;
        this.quantity = quantity;
    }

    public Cart(CartBasic cartBasic) {
        this.product = cartBasic.getProduct();
        this.priceSnapshot = cartBasic.getPriceSnapshot();
        this.quantity = cartBasic.getQuantity();
        this.time = cartBasic.getTime();
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
}
