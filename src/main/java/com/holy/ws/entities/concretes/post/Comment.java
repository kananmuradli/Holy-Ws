package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.pages.Page;
import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
/**
 * @author Vugar Mammadli
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column
    private String commentContext;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private final Date commentCreateDate = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    @Column
    private boolean wasUpdateComment;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post postOfComment;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User authorOfComment;
    
}
