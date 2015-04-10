package my.ebizapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


/**
 * Created by Vance on 4/9/15.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 64)
    private String orgName;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    private String description;

    @Column(length = 16)
    private String avatarLink;

    @ManyToOne
    private Area area;

    Customer(){}

    public Customer(String username, String password, String orgName, String email, String description, String avatarLink, Area area) {
        this.username = username;
        this.password = password;
        this.orgName = orgName;
        this.email = email;
        this.description = description;
        this.avatarLink = avatarLink;
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public Area getArea() {
        return area;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }
}