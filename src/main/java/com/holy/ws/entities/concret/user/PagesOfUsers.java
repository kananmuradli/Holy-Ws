package com.holy.ws.entities.concret.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pageOfUsers")
public class PagesOfUsers {
    @Id
    private long pageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    private User owner;

    private String pageName;
    private String pageAvatar;
    private String pageCoverImage;
    private Date createDate;

}
