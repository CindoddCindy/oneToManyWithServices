package com.onetomanywithservices.otms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(targetEntity = User.class, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<User> users;

    @OneToMany(targetEntity = MyUser.class, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<MyUser> myUsers;

    public List<MyUser> getMyUsers() {
        return myUsers;
    }

    public void setMyUsers(List<MyUser> myUsers) {
        this.myUsers = myUsers;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }



}
