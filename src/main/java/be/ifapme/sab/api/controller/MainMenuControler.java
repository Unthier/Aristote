package be.ifapme.sab.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainMenuControler {
    @GetMapping("/")
    public String home(){
        return "Main menu";
    }

    @GetMapping("/secure")
    public String secured(){
        return "main menu secure";
    }
}
