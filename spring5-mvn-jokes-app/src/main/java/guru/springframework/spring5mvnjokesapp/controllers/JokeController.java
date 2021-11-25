package guru.springframework.spring5mvnjokesapp.controllers;

import guru.springframework.spring5mvnjokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    // @Autowired is automatically injects it
    // we can admit Autowired annotation as we have a single constructor in the class!
    // Spring will automatically do the dependency injection!!! in this case!
    // @Autowired
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke()) ;
        // model.addAttribute("joke", "HI HI"); // this writes only HIHI on website!
        return "index";
    }
}
