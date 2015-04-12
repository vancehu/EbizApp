package my.ebizapp.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Vance on 4/12/2015.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long parentId;

    @Column(nullable = false)
    private long stock = 0;

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    private String imgLink;

    @ManyToMany
    private List<Product> products;

}

