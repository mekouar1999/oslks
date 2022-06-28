package com.example.appariement.components;

import com.example.appariement.model.Anagrameur;
import com.example.appariement.model.Game;
import com.example.appariement.model.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AppariementData {

    private static List<Player> players = new ArrayList<>();
    private static List<Game> games = new ArrayList<>();
    private static Anagrameur anagrameur;


    public void addPlayer(Player player){
        players.add(player);
    }
    public void addGame (Game game) {
        games.add(game);
    }

    public static void setAnnagrameur(Anagrameur anagrameur) {
        AppariementData.anagrameur = anagrameur;
    }

    public void addAnagrameur (Anagrameur anagrameur){
        setAnnagrameur(new Anagrameur(anagrameur.getId(),anagrameur.getUrl(),anagrameur.getDescription()));
    }

    public List<Player> getPlayers(){
        return players;
    }
}
