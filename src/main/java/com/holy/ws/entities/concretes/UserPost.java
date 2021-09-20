package com.holy.ws.entities.concretes;


import javax.persistence.*;

@Entity
@Table(name = "User_Posts")
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;

    @JoinColumn(name = "")
    @OneToOne
    private PostContex postContex;
}
