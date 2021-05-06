package com.example.filmList.repository;

import com.example.filmList.domain.Film;
import com.example.filmList.domain.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByNameOrGenreContaining(String keyword1, String keyword2);
}


