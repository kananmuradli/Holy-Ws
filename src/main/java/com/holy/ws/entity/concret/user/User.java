package com.holy.ws.entity.concret.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private int id;

    @Column(name = "User_Name")
    private String name;

    @Column(name = "User_LastName")
    private String lastName;

    @Column(name = "User_Username")
    private String username;

    @JoinColumn(name = "User_AddressId",referencedColumnName = "id")
    @OneToOne
    private Address address;

    @Column(name = "User_Email")
    private String email;

    @Column(name = "User_PhoneNumber")
    private String phoneNumber;

    @Column(name = "User_FaxNumber")
    private String faxNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId() == user.getId() && Objects.equals(getName(), user.getName()) && Objects.equals(getLastName(), user.getLastName()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getAddress(), user.getAddress()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPhoneNumber(), user.getPhoneNumber()) && Objects.equals(getFaxNumber(), user.getFaxNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getUsername(), getAddress(), getEmail(), getPhoneNumber(), getFaxNumber());
    }
}
