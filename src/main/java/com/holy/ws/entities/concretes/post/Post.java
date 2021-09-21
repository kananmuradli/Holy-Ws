package com.holy.ws.entities.concretes.post;


import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "User_Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @ManyToOne
    @NotNull
    @Column(name = "Author")
    private User author;

    @Column(name = "ContextText")
    @NotNull
    private String contextText;

    @Column(name = "Tags")
    @OneToMany
    private List<User> tags;


    @Column(name = "SoundsFile")
    private String sound;

    @ElementCollection
    @CollectionTable(name = "CommentsOfPost" , joinColumns = @JoinColumn(name = "postId"))
    private List<Comment> comments = new LinkedList<>();

}
