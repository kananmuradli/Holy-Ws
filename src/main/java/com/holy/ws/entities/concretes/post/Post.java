package com.holy.ws.entities.concretes.post;


import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
/**
 * @author Vugar Mammadli
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "C_POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @Column(name = "AUTHOR")
    @NotNull
    private User authorId;

    @Column(name = "CONTEXT_TEXT")
    @NotNull
    private String contextText;

    @Column(name = "TAGS")
    @ElementCollection
    @CollectionTable(name = "TAGS",joinColumns = @JoinColumn(name = "postId"))
    private Set<User> tags;

    @Column(name = "SOUND_FIELD")
    private String sound;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "POSTS_COMMENTS",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMMENT_ID"))
    private List<Comment> comments;


    @Transient
    private int countComments = getCount(comments);
    private int getCount(List<Comment> list){
        if(!(list==null)) return list.size();
        else return 0;
    }


    @Embedded
    @AttributeOverrides({
    })
    private PostEmbed postEmbed;

}
