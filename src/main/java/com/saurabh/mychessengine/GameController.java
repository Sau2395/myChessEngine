package com.saurabh.mychessengine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/Chess")
public class GameController {

    /*
    @GetMapping(path="/Game")
    public String showGame() {
        return new Game().displayCurrentStatus();
    }

    @GetMapping(path="/Board")
    public Board showBoard() {
        return new Game().getBoard();
    }
     */
}
