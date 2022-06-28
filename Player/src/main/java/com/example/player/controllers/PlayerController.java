package com.example.player.controllers;


import com.example.player.model.Player;
import com.example.player.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/player/connexion")
    public ResponseEntity<String> initConnection(@RequestBody Player player) {
        playerService.connectToAppariement(player);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/letters")
    public ResponseEntity<String> receiveLettre(@RequestBody String letters) {
        playerService.setLetters(letters);
        System.out.println("New Letters Received " + letters);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
