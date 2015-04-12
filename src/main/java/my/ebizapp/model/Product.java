package my.ebizapp.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vance on 4/11/2015.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Supplier supplier;

    @Column(nullable = false, length = 64)
    private String name;

    private String description;

    @Column(nullable = false)
    private long stockQuantity;

    @Column(nullable = false)
    private float price;

    @Column(length = 32)
    private String imgLink;

    @ManyToMany
    private List<Category> categories;

    @OneToMany
    private List<Order> orders;

    public Product(Supplier supplier, String name, String description, long stockQuantity, float price, String imgLink,
                   List<Category> categories) {
        this.supplier = supplier;
        this.name = name;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.price = price;
        this.imgLink = imgLink;
        this.categories = categories;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }



}
