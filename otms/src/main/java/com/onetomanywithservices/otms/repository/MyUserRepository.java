package com.onetomanywithservices.otms.repository;

import com.onetomanywithservices.otms.entity.MyUser;
import com.onetomanywithservices.otms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByEmail(String email);
}
