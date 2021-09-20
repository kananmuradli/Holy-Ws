package com.holy.ws.entities.concret.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "pageOfUsers")
public class PagesOfUsers {
    @Id
    private long pageId;

    @OneToMany(mappedBy = "pagesOfUsers")
    private User owner;
    private String pageName;
    private String pageAvatar;
    private String pageCoverImage;
    private Date createDate;

}
