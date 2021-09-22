package com.holy.ws.entities.concretes.post;


import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    @Column(name = "CONTEXT_TEXT",nullable = false)
    private String contextText;

    @Column(name = "TAGS")
    @ElementCollection
    @CollectionTable(name = "TAGS",joinColumns = @JoinColumn(name = "postId"))
    private Set<User> tags;

    @Column(name = "SOUND_FIELD")
    private String sound;
    
    @Transient
    private int countComments = getCount(new ArrayList<>());
    private int getCount(List<Comment> list){
        if(!(list==null)) return list.size();
        else return 0;
    }


    @Embedded
    @AttributeOverrides({
    })
    private PostEmbed postEmbed;
}
