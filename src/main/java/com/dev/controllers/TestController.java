package com.dev.controllers;

import com.dev.objects.Results;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
public class TestController {
    private GameManagement gameManagement;

    @PostConstruct
    private void init () {
        gameManagement = new GameManagement();
    }



    @RequestMapping("guess-and-result")
    public Results setGuess(String userGuess) {
        gameManagement.setUserGuess(userGuess);
        gameManagement.turn();
        return gameManagement.getResults();
    }

    @RequestMapping("set-word")
    public boolean setWord (String userWord) {
        gameManagement.setUserWord(userWord);
        System.out.println(gameManagement.getUserWord());
        return true;
    }
}
