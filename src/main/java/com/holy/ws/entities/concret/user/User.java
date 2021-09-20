package com.holy.ws.entities.concret.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id",nullable = false,updatable = false)
    private int id;

    @Column(name = "User_Name",length = 30,updatable = false)
    @NotNull(message = "Field may not be null")
    private String name;

    @Column(name = "User_LastName",length = 50,updatable = false)
    @NotNull(message = "Field may not be null")
    private String lastName;

    @Column(name = "User_Username",length = 20)
    @NotNull(message = "Field may not be null")
    private String username;

    @Column(name = "User_BirthOfDate",updatable = false)
    @NotNull(message = "Field may not be null")
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    @JoinColumn(name = "User_AddressId",referencedColumnName = "id")
    @OneToOne
    private Address address;

    @Column(name = "User_Email",length = 40)
    @NotNull(message = "Field may not be null")
    private String email;

    @Column(name = "User_PhoneNumber",length = 14)
    @NotNull(message = "Field may not be null")
    private String phoneNumber;

    @Column(name = "User_FaxNumber",length = 20)
    private String faxNumber;

    @Column(name = "User_About")
    @Lob
    private String about;


}