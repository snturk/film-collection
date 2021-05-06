package com.example.filmList.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class FilmAddForm {

    @NotEmpty
    @Size(min=1, max=40)
    private String filmName;

    @NotEmpty
    @Size(min=1, max=20)
    private String filmReleaseDate;

    @NotEmpty
    @Size(min=1, max=20)
    private String filmGenre;

    @NotEmpty
    @Size(min=1, max=300)
    private String filmDesc;

    @NotEmpty
    @Size(min = 1, max = 10000)
    private String filmMediaLink;

    @NotEmpty
    @Size(min=1, max=20)
    private ArrayList<String> filmLang;

    @Size(min=0, max=20)
    private ArrayList<Performer> filmPerformers;

    //GETTERS
    public String getFilmName() {
        return filmName;
    }

    public String getFilmReleaseDate() {
        return filmReleaseDate;
    }

    public String getFilmGenre() {
        return filmGenre;
    }

    public String getFilmDesc() {
        return filmDesc;
    }

    public String getFilmMediaLink() { return filmMediaLink; }

    public ArrayList<String> getFilmLang() {
        return filmLang;
    }

    public ArrayList<Performer> getFilmPerformers() {
        return filmPerformers;
    }

    //SETTERS
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setFilmReleaseDate(String filmReleaseDate) {
        this.filmReleaseDate = filmReleaseDate;
    }

    public void setFilmGenre(String filmGenre) {
        this.filmGenre = filmGenre;
    }

    public void setFilmDesc(String filmDesc) {
        this.filmDesc = filmDesc;
    }

    public void setFilmMediaLink(String filmMediaLink) { this.filmMediaLink = filmMediaLink; }

    public void setFilmLang(ArrayList<String> filmLang) {
        this.filmLang = filmLang;
    }

    public void setFilmPerformers(ArrayList<Performer> filmPerformers) {
        this.filmPerformers = filmPerformers;
    }
}
