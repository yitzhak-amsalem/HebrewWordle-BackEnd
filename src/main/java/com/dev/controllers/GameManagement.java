package com.dev.controllers;
import com.dev.objects.Results;
import com.dev.utils.Util;
import java.lang.*;

public class GameManagement {
    private Boolean word_found;
    private int word_length;
    private String userWord;
    private String userGuess;
    private Results results;

    public GameManagement(){
        results = new Results();
    }
    public void turn() {
        String result = Util.check_word(userWord, userGuess);
        results.setResultString(result);
        check_results(result);
    }

    private void check_results(String result) {
        word_found = result.replaceAll("\\" + Util.HIT, "").length() == 0;
        results.setCorrectGuess(word_found);
    }

    public void setUserWord(String userWord){
        this.userWord = userWord;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    public Results getResults() {
        return results;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public String getUserWord() {
        return userWord;
    }
}
