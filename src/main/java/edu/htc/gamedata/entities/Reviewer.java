package edu.htc.gamedata.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Reviewer {

    @Id
    private String userName;

    private String name;
    private int age;
    private String gender;
    private String comments;
    private String password;

    @ManyToMany
    private List<Game> favoriteGames;

    @OneToMany
    private List<Review> reviews;


}
