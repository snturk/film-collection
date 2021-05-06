package com.example.filmList.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Performer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "performer_id", nullable = false, updatable = false)
    private long id;

    @Column(name = "performer_name", nullable = false)
    private String name;

    @Column(name = "performer_role")
    private String role;

    public Performer(){

    }

    public Performer(String name){
        this.name = name;
        this.role = null;
    }

    public Performer(String name, String role){
        this.name = name;
        this.role = role;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
