package com.holy.ws.entities.concretes.pages;


import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Vugar Mammadli
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PageEmbed {

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = User.class
    )
    private Set<User> followersList;

}
