package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Post {
    private long idOfPost;

    private String contextOfPost;

    private List<String> photosOfPost;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateOfPost = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateOfPost;

    @ElementCollection
    @CollectionTable(name = "LIKED_LIST_OF_POST",joinColumns = @JoinColumn(name = "ID_OF_POST"))
    private Set<User> likedUserList;


}
