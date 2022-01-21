package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

        //Attributen
        @Id
        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private boolean enabled = true;

        private String email;

        @OneToMany(
                targetEntity = Authority.class,
                mappedBy = "username",
                cascade = CascadeType.ALL,
                orphanRemoval = true,
                fetch = FetchType.EAGER)
        private Set<Authority> authorities = new HashSet<>();

        public Set<Authority> getAuthorities() { return authorities; }
        public void setAuthorities(Set<Authority> authorities) { this.authorities = authorities; }

        public void addAuthority(Authority authority) {
                this.authorities.add(authority);
        }
        public void addAuthority(String authorityString) {
                this.authorities.add(new Authority(this.username, authorityString));
        }
        public void removeAuthority(Authority authority) {
                this.authorities.remove(authority);
        }
        public void removeAuthority(String authorityString) {
                this.authorities.removeIf(authority -> authority.getAuthority().equalsIgnoreCase(authorityString));
        }


        //Constructor is not necessary within Springboot

/*  Getters and setters in code ++
    are dropped in connection with adding Lombok dependency
 */
}
