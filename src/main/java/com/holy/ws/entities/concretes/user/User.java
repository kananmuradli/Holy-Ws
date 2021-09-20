package com.holy.ws.entities.concretes.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id",nullable = false,updatable = false)
    private int userId;

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
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;


    @ElementCollection
    @CollectionTable(name = "User_Addresses", joinColumns = @JoinColumn(name = "userId"))
    private Set<Address> address;

    @Column(name = "User_Email")
    @Length(min = 1,max = 3)
    @ElementCollection
    private Set<String> email;

    @Column(name = "PhoneNumber",length = 14)
    @Length(min = 1,max = 2)
    @ElementCollection
    @CollectionTable(name = "User_PhoneNumbers",joinColumns = @JoinColumn(name = "User_Id"))
    private Set<String> phoneNumber;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "about",column = @Column(name = "User_About"))
    })
    private UserEmbed userEmbed;


}
