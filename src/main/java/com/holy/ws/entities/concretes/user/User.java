package com.holy.ws.entities.concretes.user;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User implements Comparable<User>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;

    @Column(name = "NAME_OF_USER",nullable = false)
    @Length(min = 4,max = 30)
    private String name;

    @Column(name = "LASTNAME_OF_USER",nullable = false)
    @Length(min = 4,max = 30)
    private String lastName;

    @Column(name = "USERNAME_OF_USER",unique = true,updatable = false)
    @Length(min = 4,max = 30)
    private String username;

    @Column(name = "PASSWORD_OF_USER",nullable = false)
    @Lob
    @Length(min = 6)
    private String password;

    @Column(name = "EMAIL_OF_USER",unique = true,nullable = false)
    @Length(min = 8,max = 35)
    private String email;

    @OneToOne(mappedBy = "ownerProfile")
    private ProfileUser profileUserOfUser;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date dateOfCreate = new Date();

    public User(){}

    public User(String name, String lastName, String username, String password, String email) {
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileUserOfUser = new ProfileUser();
    }

    public long getUserid() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //@JsonIgnore
    public String getPassword() {
        return password;
    }

    //@JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public ProfileUser getProfileOfUser() {
        return profileUserOfUser;
    }

    public void setProfileOfUser(ProfileUser profileUserOfUser) {
        this.profileUserOfUser = profileUserOfUser;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserid() == user.getUserid() && getName().equals(user.getName()) && getLastName().equals(user.getLastName()) && getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) && getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserid(), getName(), getLastName(), getUsername(), getPassword(), getEmail());
    }

}
