package com.holy.ws.entities.concretes.pages;

import com.holy.ws.entities.abstracts.Occupant;
import com.holy.ws.entities.concretes.user.User;
import com.holy.ws.entities.concretes.utilities.Address;
import com.holy.ws.entities.concretes.utilities.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


/**
 * @author Vugar Mammadli
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pageOfUsers")
public class Page implements Occupant {
    @Id
    @Column(name = "Page_Id")
    private long pageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    @NotNull
    private User owner;

    @Column(name = "PAGE_NAME")
    @NotNull
    @Size(min = 5,max = 50)
    private String pageName;

    @Column(name = "PAGE_AVATAR")
    @Lob
    private String pageAvatar;

    @Column(name = "PAGE_COVER_IMAGE")
    @Lob
    private String pageCoverImage;

    @Column(name = "PAGE_CREATE_DATE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Size(max = 2,message = "Max 2")
    @Column(name = "ADDRESSES")
    @OneToMany
    private Set<Address> addresses;


    @Column(name = "PHONE_NUMBERS",length = 14)
    @Size(min = 1,max = 3)
    @OneToMany
    private Set<PhoneNumber> phoneNumbers;


    @Embedded
    @AttributeOverrides({

    })
    private PageEmbed pageEmbed;

    @NotNull
    @Override
    public int compareTo(Occupant o) {
        return 0;
    }
}
