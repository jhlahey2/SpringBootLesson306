package com.lahey.springbootlesson306.controller;

import com.lahey.springbootlesson306.model.Director;
import com.lahey.springbootlesson306.model.DirectorRepository;
import com.lahey.springbootlesson306.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model){

        //first lets creeate a Director
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre("Sci Fi");

        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About the Stars...");

        //add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        //Now we create another Movie
        movie = new Movie();
        movie.setTitle("Deathstar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks on the Death Star...");
        movies.add(movie);

        //add the list of movies to the director's movie list
        director.setMovies(movies);

        directorRepository.save(director);

        //grab all the directors from the database and send them to the template
        model.addAttribute("directors", directorRepository.findAll());
        return "index";

    }

}//end public class HomeController
