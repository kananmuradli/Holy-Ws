package com.holy.ws.entities.concretes.user;


import com.holy.ws.entities.concretes.pages.Page;
import com.holy.ws.entities.concretes.post.Comment;
import com.holy.ws.entities.concretes.post.Post;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * @author Vugar Mammadli
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEmbed {

    @Nullable
    @Lob
    private String aboutUser;

    @Nullable
    @JoinColumn(name = "owner")
    @OneToMany(fetch = FetchType.LAZY)
    @Length(max = 5)
    private Set<Page> pagesOfUsers;

    @Nullable
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "C_POSTS", joinColumns = { @JoinColumn(name = "authorId")})
    private List<Post> posts;


    @Nullable
    @OneToMany(targetEntity = Comment.class)
    @JoinTable(name = "COMMENTS_OF_USER",
    joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "COMMENT_ID"))
    private List<Comment> comments;

    @Nullable
    @ElementCollection
    @CollectionTable(name = "User_FriendList",joinColumns = @JoinColumn(name = "User_Id"))
    private Set<String> phoneNumber;

    @NotNull
    private Date createAccountDate = new Date();
}
