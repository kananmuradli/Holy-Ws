package com.holy.ws.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "PostContex")
public class PostContex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postContextId;

    @Column(name = "postContext")
    @OneToOne
    private UserPost userPost;

    @Column(name = "twit")
    @NotNull
    private String twit;

    @Column(name = "tags")
    @OneToMany
    private List<User> tags;

//    @Column(name = "photos")
//    private List<String> photos;

    @Column(name = "sound")
    private String sound;
}
