package com.example.player.components;

import com.example.player.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerData {

    private final String CONNECTION_URL = "http://localhost:8084/game/connexion";
    private static Player player;
    private static String letters = "";

    public String getConnectionUrl(){
        return CONNECTION_URL;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public String getLetters(){
        return letters;
    }

    public void setLetters(String letters){
        this.letters = letters;
    }
}
