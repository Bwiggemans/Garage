package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityKey.class)
public class Authority implements Serializable{

    //Attributen
    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String authority;

    //Constructors
    public Authority() {}
    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    //Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
