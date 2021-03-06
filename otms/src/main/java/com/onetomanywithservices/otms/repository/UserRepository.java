package com.onetomanywithservices.otms.repository;

import com.onetomanywithservices.otms.entity.Role;
import com.onetomanywithservices.otms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
    Optional<User> findByFirstName(String firstName);//ikut role
}
