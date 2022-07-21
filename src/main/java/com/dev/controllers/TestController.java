package com.dev.controllers;

import com.dev.objects.Results;
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
        System.out.println(gameManagement.getUserGuess());
        gameManagement.turn();
        System.out.println(gameManagement.getResults().getResultString());
        return gameManagement.getResults();
    }

    @RequestMapping("set-word")
    public String setWord (String userWord) {
        gameManagement.setUserWord(userWord);
        System.out.println(gameManagement.getUserWord());
        return gameManagement.getUserWord();
    }
}
