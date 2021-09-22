package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
/**
 * @author Vugar Mammadli
 */
@Data @NoArgsConstructor @AllArgsConstructor
@Embeddable
public class PostEmbed {

    @OneToMany(mappedBy = "postOfComment")
    private List<Comment> comments;

    @ElementCollection
    @CollectionTable(name = "LIKED_POST_USER",joinColumns = @JoinColumn(name = "postId"))
    private Set<User> likedPostUserList;

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentCreateDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date commentUpdateDate;

    private boolean isUpdate = false;
}
