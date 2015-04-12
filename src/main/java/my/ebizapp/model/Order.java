package my.ebizapp.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vance on 4/12/2015.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Customer customer;


    private float priceSnapshot;

    private long quantity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date time = new Date();

    @Column(nullable = false)
    private boolean shipped = false;
}
