package nl.novi.garage.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

    //Constructor is not necessary within Springboot

/*  Getters and setters in code ++
    are dropped in connection with adding Lombok dependency
 */
}
