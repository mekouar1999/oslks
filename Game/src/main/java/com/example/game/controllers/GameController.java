package com.example.game.controllers;

import com.example.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/game/newGame")
    public ResponseEntity<String> initGame() {
        gameService.connectToAppariement();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
