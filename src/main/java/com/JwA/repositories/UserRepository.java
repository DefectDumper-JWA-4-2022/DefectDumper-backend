package com.JwA.repositories;

import com.JwA.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "FROM User where email= :email")
    Optional<User> checkEmail(String email);

    @Query(value = "FROM User where email = :email AND password = :password")
    Optional<User> findByEmailAndPassword(String email, String password);

    /*@Modifying
    @Query("UPDATE User SET is_active = false WHERE id = :userId")
    void deactivateUser(int userId);*/
}
