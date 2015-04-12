package my.ebizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vance on 4/11/2015.
 */
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String message;

    @JsonIgnore
    @ManyToOne
    private Customer customer;

    @JsonIgnore
    @ManyToOne
    private Supplier supplier;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time = new Date();

    @Column(nullable = false)
    private boolean toCustomer;

    @Column(nullable = false)
    private boolean hasRead = false;

    Message() {
    }

    public Message(String message, Customer customer, Supplier supplier, boolean toCustomer) {
        this.message = message;
        this.customer = customer;
        this.supplier = supplier;
        this.toCustomer = toCustomer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isToCustomer() {
        return toCustomer;
    }

    public void setToCustomer(boolean toCustomer) {
        this.toCustomer = toCustomer;
    }

    public boolean isHasRead() {
        return hasRead;
    }

    public void setHasRead(boolean unread) {
        this.hasRead = unread;
    }
}
