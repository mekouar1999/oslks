package com.example.appariement.services;

import com.example.appariement.model.Anagrameur;
import com.example.appariement.components.AppariementData;
import com.example.appariement.model.Game;
import com.example.appariement.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppariementService {

    @Autowired
    private AppariementData appariementData;

    public void addPlayer(Player player){
        appariementData.addPlayer(player);
        System.out.println("New player has been added : " + player.getName());
    }
    public void addGame(Game game){
        appariementData.addGame(game);
    }

    public void addAnagrammeur(Anagrameur anagrameur){appariementData.addAnagrameur(anagrameur);}

    public List<Player> listPlayers() {
        return appariementData.getPlayers();
    }
}
