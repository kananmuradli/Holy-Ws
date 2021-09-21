package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "COMMENTS")
@Embeddable
public class Comment {
    @Id
    private long commentId;

    @Column(name = "PostId")
    @ManyToOne
    private Post postId;

    @Lob
    private String commentContext;


    @Column(name = "Author")
    @ManyToOne
    private User commentAuthorId;

    @OneToMany
    private Set<User> likedCommentUserList;

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean wasUpdateComment;
}
