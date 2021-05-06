package com.example.filmList.service;

import com.example.filmList.domain.Film;
import com.example.filmList.domain.FilmAddForm;
import com.example.filmList.domain.Performer;

public interface FilmService {
    void setSearchParam(String searchParam);
    String getSearchParam();

    void setSortParam(String sortParam);
    String getSortParam();

    void addFilm(FilmAddForm form);
    Iterable<Film> getAllFilms(String searchParam, String sortParam);
    void deleteFilmById(long id);
    void updateFilmById(long id, String inputType, String inputValue);
    void addPerformerById(long id, Performer performer);
}
