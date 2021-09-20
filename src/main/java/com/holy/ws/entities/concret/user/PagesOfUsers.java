package com.holy.ws.entities.concret.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pageOfUsers")
public class PagesOfUsers {
    @Id
    @Column(name = "Page_Id")
    private long pageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id")
    @NotNull
    private User owner;

    @Column(name = "")
    @NotNull
    @Size(min = 5,max = 50)
    private String pageName;

    @Column(name = "")
    @Lob
    private String pageAvatar;

    @Column(name = "")
    @Lob
    private String pageCoverImage;

    @Column(name = "")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

}
