package com.JwA.models;

import com.JwA.dtos.RegisterRequest;
import com.JwA.dtos.UserResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String role;

    public User(RegisterRequest registerRequest) {
        this.email = registerRequest.getEmail();
        this.firstName = registerRequest.getFirstName();
        this.lastName = registerRequest.getLastName();
        this.password = registerRequest.getPassword();
        this.role = registerRequest.getRole();
    }

    
    
    public User(UserResponse userResponse) {
        this.id = userResponse.getUserId();
        this.email = userResponse.getEmail();
        this.firstName = userResponse.getFirstName();
        this.lastName = userResponse.getLastName();
        this.role = userResponse.getRole();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
