package com.holy.ws.entities.concretes.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEmbed {

    @Column(name = "User_About")
    @Nullable
    @Lob
    private String about;

    @Column(name = "User_Pages")
    @Nullable
    @JoinColumn(name = "owner")
    @OneToMany(fetch = FetchType.LAZY)
    private List<PagesOfUsers> pagesOfUsers;


    @Column(name = "User_Post")
    @OneToMany(fetch = FetchType.LAZY)
    private List<UserPost> posts;

}
