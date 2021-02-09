package com.onetomanywithservices.otms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;

    @OneToMany(targetEntity = MyUser.class, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<MyUser> myUsers;

    public List<MyUser> getMyUsers() {
        return myUsers;
    }

    public void setMyUsers(List<MyUser> myUsers) {
        this.myUsers = myUsers;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
