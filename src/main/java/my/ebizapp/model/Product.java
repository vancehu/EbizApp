package my.ebizapp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vance on 4/11/2015.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Supplier supplier;

    private String name;

    private String description;

    private long stockQuantity;

    private float price;

    @ManyToMany(mappedBy = "products")
    private List<Category> categories;

    @OneToMany(mappedBy = "product")
    private List<Order> orders;
}
