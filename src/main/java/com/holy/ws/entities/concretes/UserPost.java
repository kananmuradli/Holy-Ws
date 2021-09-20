package com.holy.ws.entities.concretes;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "User_Posts")
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @ManyToOne
    @NotNull
    private User userOfPost;

    @Column(name = "twit")
    @NotNull
    private String twit;

    @Column(name = "tags")
    @OneToMany
    private List<User> tags;

    /**
     * Burada sekillerde olmalidir
     */

    @Column(name = "sound")
    private String sound;
}
