package com.holy.ws.entities.concretes.user;

import com.holy.ws.entities.concretes.user.other.Address;
import com.holy.ws.entities.concretes.user.other.PhoneNumberSort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Map;
import java.util.Set;


@Data @NoArgsConstructor @AllArgsConstructor
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
    @Length(min = 6)
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
    @Size(max = 2)
    @CollectionTable(name = "User_Addresses", joinColumns = @JoinColumn(name = "userId"))
    @AttributeOverrides({
            @AttributeOverride(name = "country",column = @Column(name = "Address_Country")),
            @AttributeOverride(name = "city",column = @Column(name = "Address_City")),
            @AttributeOverride(name = "street",column = @Column(name = "Address_Street")),
            @AttributeOverride(name = "postalCode",column = @Column(name = "Address_PostalCode"))
    })
    private Set<Address> addresses;

    @Column(name = "User_Email")
    @Size(min = 1,max = 3)
    @ElementCollection
    @CollectionTable(name = "EMAILS",joinColumns = @JoinColumn(name = "User_ID"))
    private Set<String> emails;

    @Column(name = "PhoneNumber",length = 14)
    @Size(min = 1,max = 2)
    @ElementCollection
    @MapKeyColumn(name = "SORT_NUMBER")
    @CollectionTable(name = "User_PhoneNumbers",joinColumns = @JoinColumn(name = "User_Id"))
    private Map<PhoneNumberSort,String> phoneNumbers;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aboutUser",column = @Column(name = "User_About"))
    })
    private UserEmbed userEmbed;


}
