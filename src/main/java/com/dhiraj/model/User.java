package com.dhiraj.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    private String location;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;


    private String image;

    private String backgroundImage;

    private String bio;


    private boolean login_with_google;




//    @ManyToMany(mappedBy = "retwitUser",cascade = CascadeType.ALL, or )
//    private List<Twit> retwits = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Twit> twit = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL , orphanRemoval = true )
    private List<Like> likes  = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User>followers=new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "followers", cascade = CascadeType.ALL )
    private List<User>followings=new ArrayList<>();


    public String getPassword() {
        return "";
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
