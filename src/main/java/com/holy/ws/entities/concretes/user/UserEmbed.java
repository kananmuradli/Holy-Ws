package com.holy.ws.entities.concretes.user;


import com.holy.ws.entities.concretes.pages.PagesOfUsers;
import com.holy.ws.entities.concretes.post.UserPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
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

    @Nullable
    @JoinColumn(name = "owner")
    @OneToMany(fetch = FetchType.LAZY)
    @Length(max = 5)
    private Set<PagesOfUsers> pagesOfUsers;

    @Nullable
    @OneToMany(fetch = FetchType.LAZY)
    private List<UserPost> posts;

}
