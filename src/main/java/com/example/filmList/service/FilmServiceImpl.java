package com.example.filmList.service;

import com.example.filmList.domain.Film;
import com.example.filmList.domain.FilmAddForm;
import com.example.filmList.domain.Performer;
import com.example.filmList.domain.performerAddForm;
import com.example.filmList.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;

    String searchParam = "";
    String sortParam = "";
    Boolean editComponentShown = false;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public void setSearchParam(String searchParam) {
        this.searchParam =  searchParam;
    }

    @Override
    public String getSearchParam() {
        return searchParam;
    }

    @Override
    public void setSortParam(String sortParam) {
        this.sortParam = sortParam;
    }

    @Override
    public String getSortParam() {
        return sortParam;
    }

    @Override
    public void addFilm(FilmAddForm form) {
        Film film = new Film(form.getFilmName(), form.getFilmReleaseDate(), form.getFilmGenre(), form.getFilmDesc(), form.getFilmMediaLink(), form.getFilmLang());
        filmRepository.save(film);
        System.out.println(filmRepository.findById(film.getId()));
    }

    @Override
    public Iterable<Film> getAllFilms(String searchParam, String sortParam){
        if (sortParam.equals("sortByYear")){
            return filmRepository.findAll(Sort.by("releaseDate").descending());
        }

        return filmRepository.findByNameOrGenreContaining(searchParam, searchParam);
    }

    @Override
    public void deleteFilmById(long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public void updateFilmById(long id, String inputType, String inputValue) {
        Film film = filmRepository.findById(id).get();
        switch (inputType){
            case "name":
                film.setName(inputValue);
                break;
            case "releaseDate":
                film.setReleaseDate(inputValue);
                break;
            case "Genre":
                film.setGenre(inputValue);
                break;
            case "desc":
                film.setDesc(inputValue);
                break;
            case "mediaLink":
                film.setMediaLink(inputValue);
                break;
            case "lang":
                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(inputValue.split(",")));
                film.setLang(arrayList);
                break;
        }
        filmRepository.save(film);
    }

    @Override
    public void addPerformerById(long id, Performer performer) {
        Film film = filmRepository.findById(id).get();
        film.addToPerformers(performer);
        filmRepository.save(film);
    }


}
