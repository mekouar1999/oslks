package com.example.player.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    private String name;
    private String url;

    public Player(String name, String url){
        this.name = name;
        this.url = url;
    }

}
