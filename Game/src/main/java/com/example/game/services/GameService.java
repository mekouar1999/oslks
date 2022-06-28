package com.example.game.services;

import com.example.game.components.GameData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameService {

    @Autowired
    private GameData gameData;

    public void connectToAppariement() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(gameData.getCONNECTION_URL(), GameData.getGame(), String.class);
        System.out.println(response.getStatusCode());
    }
}
