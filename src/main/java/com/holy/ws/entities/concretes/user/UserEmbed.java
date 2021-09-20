package com.holy.ws.entities.concretes.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEmbed {

    @Nullable
    @Lob
    private String about;

    @JoinColumn(name = "owner")
    @OneToMany(fetch = FetchType.LAZY)
    private Set<PagesOfUsers> pagesOfUsers;



    @OneToMany(fetch = FetchType.LAZY)
    private List<UserPost> posts;

}
