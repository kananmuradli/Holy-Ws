package com.holy.ws.entities.concretes.user;


import com.holy.ws.entities.concretes.pages.PagesOfUsers;
import com.holy.ws.entities.concretes.post.Post;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Embeddable @Data @NoArgsConstructor @AllArgsConstructor
public class UserEmbed {

    @Nullable
    @Lob
    private String aboutUser;

    @Nullable
    @JoinColumn(name = "owner")
    @OneToMany(fetch = FetchType.LAZY)
    @Length(max = 5)
    private Set<PagesOfUsers> pagesOfUsers = new HashSet<>();

    @Nullable
    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;

    @Nullable
    @ElementCollection
    @CollectionTable(name = "User_FriendList",joinColumns = @JoinColumn(name = "User_Id"))
    private Set<String> phoneNumber = new HashSet<>();

    @NotNull
    private Date createAccountDate = new Date();
}
