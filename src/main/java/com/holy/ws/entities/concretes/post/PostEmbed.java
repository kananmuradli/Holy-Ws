package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PostEmbed {


    @ElementCollection
    @CollectionTable(name = "LIKED_POST_USER",joinColumns = @JoinColumn(name = "postId"))
    private Set<User> likedPostUserList;

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean isUpdate = false;
}
