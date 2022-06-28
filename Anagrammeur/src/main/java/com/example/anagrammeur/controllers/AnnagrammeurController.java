package com.example.anagrammeur.controllers;

import com.example.anagrammeur.model.Player;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
public class AnnagrammeurController {

    @PostMapping("/letters")
    public void sendLettersToPlayers(){

        String letters = "aiofzjoifer";


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Player>> response = restTemplate.exchange("http://localhost:8084/game/players", HttpMethod.GET, null, new ParameterizedTypeReference<List<Player>>(){});

        List<Player> players = response.getBody();

        players.forEach(player -> {
                    restTemplate.postForEntity(player.getUrl() + "/letters", letters, String.class);
                });

    }
}
