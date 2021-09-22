package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private long commentId;

    private String commentContext;

    private User commentAuthorId;

    private Set<User> likedCommentUserList;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean wasUpdateComment;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getCommentId() == comment.getCommentId() && isWasUpdateComment() == comment.isWasUpdateComment() && getCommentContext().equals(comment.getCommentContext()) && getCommentAuthorId().equals(comment.getCommentAuthorId()) && Objects.equals(getLikedCommentUserList(), comment.getLikedCommentUserList()) && getCommentCreateDate().equals(comment.getCommentCreateDate()) && Objects.equals(getCommentUpdateDate(), comment.getCommentUpdateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommentId(), getCommentContext(), getCommentAuthorId(), getLikedCommentUserList(), getCommentCreateDate(), getCommentUpdateDate(), isWasUpdateComment());
    }
}
