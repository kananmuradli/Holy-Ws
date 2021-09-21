package com.holy.ws.entities.concretes.post;

import com.holy.ws.entities.concretes.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PostEmbed {

    @ManyToMany(mappedBy = "userId")
    private Set<User> likedPostUserList;

    private Date commentCreateDate;
    private Date commentUpdateDate;
    private boolean isUpdate = false;
}
