package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.abstracts.Occupant;
import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Vugar Mammadli
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    private String commentContext;

    @Temporal(TemporalType.TIMESTAMP)
    private final Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean wasUpdateComment;


}
