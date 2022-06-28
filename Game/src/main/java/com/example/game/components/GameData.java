package com.example.game.components;

import com.example.game.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameData {

    private final String CONNECTION_URL = "http://localhost:8081/game/partie";
    private static Game game = new Game("Alex", "http://localhost:8083/");

    public String getCONNECTION_URL() {
        return CONNECTION_URL;
    }

    public static Game getGame() {
        return game;
    }
}
