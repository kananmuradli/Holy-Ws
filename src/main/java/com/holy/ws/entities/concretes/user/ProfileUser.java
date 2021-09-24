package com.holy.ws.entities.concretes.user;

import com.holy.ws.entities.concretes.comment.Comment;
import com.holy.ws.entities.concretes.post.Post;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PROFIL_OF_USER")
@Lazy
public class ProfileUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User ownerProfile;

    @Lob
    @Column(name = "ABOUT_OF_USER")
    private String aboutOfUser;

    @Lob
    @Column(name = "AVATAR_OF_PROFILE")
    private String avatarOfProfile;

    @Lob
    @Column(name = "COVER_OF_PROFILE")
    private String coverOfProfile;

    private Set<User> friendList;

    private List<Post> postsOfUser;

    private List<Comment> commentsOfUser;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateOfProfile;
}
