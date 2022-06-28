package com.example.appariement.controllers;

import com.example.appariement.model.Anagrameur;
import com.example.appariement.model.Game;
import com.example.appariement.model.Player;
import com.example.appariement.services.AppariementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppariementController {

    @Autowired
    private AppariementService appariementService;

    @PostMapping("/game/connexion")
    public ResponseEntity<String> initConnection(@RequestBody Player player) {
        if (player != null) {
            appariementService.addPlayer(player);
            return new ResponseEntity(player.getId(),HttpStatus.OK);

        } else {
            throw new RuntimeException("Player can't be null");
        }

       // return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/game/partie")
    public ResponseEntity<String> initPartie(@RequestBody Game game) {
        if(game != null) {
            appariementService.addGame(game);
            String resp = "game id :"+game.getIdGame()+ " | "+"game url : "+game.getUrlGame();
            return new ResponseEntity<>(resp,HttpStatus.OK);

        } else {
            throw new RuntimeException("Game can't be null");
        }
    }

    @PostMapping("game/anagrammeur")
    public ResponseEntity<String> initAnagrammeur(@RequestBody Anagrameur anagrameur) {
        if(anagrameur != null ){
            appariementService.addAnagrammeur(anagrameur);
            String resp = "Anagrammeur id:"+anagrameur.getId();
            return  new ResponseEntity<>(resp,HttpStatus.OK);
        } else {
                throw new RuntimeException("Game can't be null");
        }
    }

    @GetMapping("/game/players")
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<>(appariementService.listPlayers(), HttpStatus.OK);
    }

}
