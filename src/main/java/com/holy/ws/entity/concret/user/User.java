package com.holy.ws.entity.concret.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "User_AddressId")
    @OneToOne(mappedBy = "Address_Id")
    private Address addressId;

    @Column(name = "User_Email")
    private String email;

    @Column(name = "User_PhoneNumber")
    private String phoneNumber;

    @Column(name = "User_FaxNumber")
    private String faxNumber;

}
