package com.example.filmList.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(name = "film_name", nullable = false)
    private String name;

    @Column(name = "film_release_date", nullable = false)
    private String releaseDate;

    @Column(name = "film_genre", nullable = false)
    private String genre;

    @Column(name = "film_desc", nullable = false)
    private String desc;

    @Column(name = "film_media_link")
    private String mediaLink;

    @Column(name = "film_lang", nullable = false)
    private ArrayList<String> lang;

    @Column(name = "component_status")
    private boolean editComponentStatus = false;

    @Lob
    @Column(name = "performers")
    private ArrayList<Performer> performers = new ArrayList<Performer>();

    public Film(){

    }

    public Film(String name, String releaseDate, String genre, String desc, String mediaLink, ArrayList<String> lang){
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.desc = desc;
        this.mediaLink = mediaLink;
        this.lang = lang;
    }

    public Film(String name, String releaseDate, String genre, String desc, String mediaLink, ArrayList<String> lang, ArrayList<Performer> performers) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.desc = desc;
        this.mediaLink = mediaLink;
        this.lang = lang;
        this.performers = performers;
    }

    public void addToPerformers(Performer performer){
        performers.add(performer);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", Name=" + name +
                ", Release Date: " + releaseDate +
                ", Genre: " + genre +
                ", Media Link: " + mediaLink +
                ", Desc: " + desc +
                ", Lang: " + lang +
                ", Performers: " +performers+
                '}';
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setMediaLink(String mediaLink){ this.mediaLink =  mediaLink; }

    public void setLang(ArrayList<String> lang) { this.lang = lang; }

    public void setEditComponentStatus(){ this.editComponentStatus = !this.editComponentStatus; }

    public void setPerformers(ArrayList<Performer> performers) {
        this.performers = performers;
    }

    //GETTERS

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public String getDesc() {
        return desc;
    }

    public String getMediaLink() { return mediaLink; }

    public ArrayList<String> getLang() {
        return lang;
    }

    public boolean getEditComponentStatus() {return editComponentStatus;}

    public ArrayList<Performer> getPerformers() {
        return performers;
    }
}
