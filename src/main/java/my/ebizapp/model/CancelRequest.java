package my.ebizapp.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
@Entity
public class CancelRequest {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(optional = false)
    private Transact transact;

    @Column(nullable = false)
    private boolean customerApproved = false;

    @Column(nullable = false)
    private boolean supplierApproved = false;

    @Column(nullable = false, length = 255)
    private String reason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time = new Date();

    public CancelRequest(Transact transact, boolean customerApproved, boolean supplierApproved, String reason) {
        this.transact = transact;
        this.customerApproved = customerApproved;
        this.supplierApproved = supplierApproved;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Transact getTransact() {
        return transact;
    }

    public void setTransact(Transact transact) {
        this.transact = transact;
    }

    public boolean isCustomerApproved() {
        return customerApproved;
    }

    public void setCustomerApproved(boolean customerApproved) {
        this.customerApproved = customerApproved;
    }

    public boolean isSupplierApproved() {
        return supplierApproved;
    }

    public void setSupplierApproved(boolean supplierApproved) {
        this.supplierApproved = supplierApproved;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
