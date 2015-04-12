package my.ebizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vance on 4/11/2015.
 */
@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private long id;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String orgName;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 15)
    private String phone;

    private String description;

    @Column(length = 32)
    private String imgLink;

    @ManyToOne
    private Area area;

    @OneToMany
    private List<Product> products;


    Supplier() {
    }

    public Supplier(String username, String password, String orgName, String email, String phone, String description,
                    String imgLink, Area area) {
        this.username = username;
        this.password = password;
        this.orgName = orgName;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.imgLink = imgLink;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatarLink() {
        return imgLink;
    }

    public void setAvatarLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
