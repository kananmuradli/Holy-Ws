package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private String commentContext;

    private User commentAuthorId;

    private Set<User> likedCommentUserList;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean wasUpdateComment;
}
