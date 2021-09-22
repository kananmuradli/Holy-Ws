package com.holy.ws.entities.concretes.user;

import com.holy.ws.entities.abstracts.Occupant;
import com.holy.ws.entities.concretes.utilities.Address;
import com.holy.ws.entities.concretes.utilities.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vugar Mammadli
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Occupant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id",nullable = false,updatable = false)
    private int userId;

    @Column(name = "USER_NAME",length = 30,updatable = false)
    @NotNull(message = "Field may not be null")
    private String name;

    @Column(name = "USER_LASTNAME",length = 50,updatable = false)
    @NotNull(message = "Field may not be null")
    private String lastName;

    @Column(name = "USER_USERNAME",length = 20)
    @NotNull(message = "Field may not be null")
    private String username;

    @Column(name = "PASSWORD")
    @Length(min = 6)
    @NotNull
    @NotEmpty
    private String password;

    @Column(name = "USER_PROFILAVATAR")
    private String avatar;

    @Column(name = "USER_BIRTDAY",updatable = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;


    @Size(max = 2,message = "Max 2")
    @Column(name = "ADDRESSES")
    @OneToMany
    private Set<Address> addresses;

    @Column(name = "USER_EMAILS")
    @Size(min = 1,max = 3)
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "EMAILS",joinColumns = @JoinColumn(name = "User_ID"))
    private Set<String> emails;

    @OneToMany
    @JoinTable(name = "PHONE_NUMBERS",joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "PHONE_NUMBER_ID"))
    private Set<PhoneNumber> phoneNumbers;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "aboutUser",column = @Column(name = "User_About"))
    })
    private UserEmbed userEmbed;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId() && getName().equals(user.getName()) && getLastName().equals(user.getLastName()) && getUsername().equals(user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getAvatar(), user.getAvatar()) && getBirthOfDate().equals(user.getBirthOfDate()) && Objects.equals(getAddresses(), user.getAddresses()) && getEmails().equals(user.getEmails()) && getPhoneNumbers().equals(user.getPhoneNumbers()) && Objects.equals(getUserEmbed(), user.getUserEmbed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getName(), getLastName(), getUsername(), getPassword(), getAvatar(), getBirthOfDate(), getAddresses(), getEmails(), getPhoneNumbers(), getUserEmbed());
    }

    @NotNull
    @Override
    public int compareTo(Occupant o) {
        return 0;
    }
}
