package com.example.filmList.controller;


import com.example.filmList.domain.Film;
import com.example.filmList.domain.FilmAddForm;
import com.example.filmList.domain.Performer;
import com.example.filmList.domain.performerAddForm;
import com.example.filmList.repository.FilmRepository;
import com.example.filmList.service.FilmService;
import com.example.filmList.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    /*@RequestMapping("/home")
    public ModelAndView getFilmsPage() {
        return new ModelAndView("films", "films", filmService.getAllFilms("none", true));
    }*/

    @RequestMapping("/home/add")
    public ModelAndView filmAddPage() {
        return new ModelAndView("addFilm", "filmForm", new FilmAddForm());
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String handleFilmAdd(@Valid @ModelAttribute("filmForm") FilmAddForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "addFilm";
        }
        filmService.addFilm(form);
        return "redirect:/home";
    }

    @RequestMapping(value = "/home/delete/{id}")
    public String filmDelete(@PathVariable Long id) {
        filmService.deleteFilmById(id);
        return "redirect:/home";
    }

    @RequestMapping("/home/update/{id}")
    public String filmUpdate(@PathVariable Long id, @ModelAttribute("inputType") String inputType, @ModelAttribute("inputValue") String inputValue, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "home";
        }
        filmService.updateFilmById(id, inputType, inputValue);
        return "redirect:/home";
    }

    @PostMapping("/home/showEdit/{id}")
    public String showEditComponent(@PathVariable Long id){
        Film film = filmRepository.findById(id).get();
        film.setEditComponentStatus();
        filmRepository.save(film);

        return "redirect:/home";
    }

    @PostMapping(value = "/home/addPerformer/{id}")
    public String performerAddPage(@PathVariable Long id, @ModelAttribute("performer") Performer performer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "home";
        }
        filmService.addPerformerById(id, performer);
        return "redirect:/home";

    }

    @GetMapping("/home/search")
    String search(@ModelAttribute("searchParam") String searchParam, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
        }
        filmService.setSearchParam(searchParam);
        return "redirect:/home";
    }

    @GetMapping("/home/sort")
    String sort(){
        filmService.setSortParam("sortByYear");
        return "redirect:/home";
    }

    @GetMapping(value = "/home")
    String getHome(Model model){
        model.addAttribute("films", filmService.getAllFilms(filmService.getSearchParam(), filmService.getSortParam()));
        return "home";
    }

}
