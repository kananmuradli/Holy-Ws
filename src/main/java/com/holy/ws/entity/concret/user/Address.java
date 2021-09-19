package com.holy.ws.entity.concret.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_Id")
    private long id;

    @Column(name = "Address_UserId")
    private int userId;

    @Column(name = "Address_Country")
    private String country;

    @Column(name = "Address_City")
    private String city;

    @Column(name = "Address_Street")
    private String street;

    @Column(name = "Address_postalCode")
    private String postalCode;

}
