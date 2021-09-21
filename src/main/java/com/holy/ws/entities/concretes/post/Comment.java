package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Comments")
@Embeddable
public class Comment {
    @Id
    private long commentId;

    @ManyToOne
    @Column(name = "PostId")
    private Post post;

    @Lob
    private String commentContext;

    @ManyToOne
    private User commentAuthor;

    @OneToMany
    private Set<User> likedCommentUserList;

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean wasUpdateComment;
}
