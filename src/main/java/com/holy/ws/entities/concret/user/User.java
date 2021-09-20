package com.holy.ws.entities.concret.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

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

    @Column(name = "password")
    @Size(min = 6)
    @NotNull
    @NotEmpty
    private String password;

    @Column(name = "User_ProfilAvatar")
    private String avatar;

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

    @Column(name = "User_About")
    @Nullable
    @Lob
    private String about;

    @Column(name = "User_Pages")
    @Nullable
    @JoinColumn(name = "User_PagesId",referencedColumnName = "")
    @OneToMany
    private List<PagesOfUsers> pagesOfUsers;


}
