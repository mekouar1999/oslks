package com.example.player.services;

import com.example.player.components.PlayerData;
import com.example.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerService {

    @Autowired
    private PlayerData playerData;


    public void connectToAppariement(Player player) {
        RestTemplate restTemplate = new RestTemplate();
        playerData.setPlayer(player);
        ResponseEntity<String> response = restTemplate.postForEntity(playerData.getConnectionUrl(), player, String.class);
        System.out.println(response.getStatusCode());
    }

    public void setLetters(String letters){
        playerData.setLetters(letters);
    }

    public String getLetters(){
        return playerData.getLetters();
    }





}
