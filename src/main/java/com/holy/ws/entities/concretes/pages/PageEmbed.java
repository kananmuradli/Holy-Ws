package com.holy.ws.entities.concretes.pages;


import com.holy.ws.entities.concretes.user.User;
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

    private List<User> followersList;

}
