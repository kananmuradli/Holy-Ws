package com.holy.ws.entities.concretes.pages;


import com.holy.ws.entities.concretes.post.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
/**
 * @author Vugar Mammadli
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PageEmbed {

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST})
    @JoinTable(name = "PAGE_COMMENTS",joinColumns = @JoinColumn(name = "PAGE_ID"),
    inverseJoinColumns = @JoinColumn(name = "COMMENT_ID"))
    private List<Comment> comments;

}
