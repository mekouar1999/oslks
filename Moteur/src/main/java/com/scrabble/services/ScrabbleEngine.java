package com.scrabble.services;

import com.game.scrabble.websocket.Group;
import com.game.scrabble.websocket.Handler;
import com.game.scrabble.websocket.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrabbleEngine extends Handler {
	@Autowired
	private WordService wordService;

	public ScrabbleEngine() {
		setUrlPaths("/scrabble");
		setMaxGroupSize(2); // Nombre Maximum d'utilisateur dans un groupe, la valeur 0 (par défaut) 
							// signifie un nombre illimité : càd tous les utilisateurs dans un même groupe
							// ici, la valeur 2 => 2 utilisateurs par groupe, les groupes seront créés automatiquement : G1, G2, ...
							// Si on veut gérer les groupe soit même il faut redéfinir la méthode onConnection
		on("login", s -> login(s));		
		//on("request-letters", s -> sendLetters(s));
	}
	
	public void login(Socket s) {
		System.out.println(s.getMessage());
		Group g = addToGroup(s);
		s.emit("login-ok", s.getSessionId() + ";" + g.getId());		
		if (g.size() == getMaxGroupSize()) {
			sendLetters(g);
		}
	}

	public void sendLetters(Group g) {
		List<Socket> list = g.getList();
		for (Socket s : list) {
			sendLetters(s);
		}
		//s.emitToGroup("letters-ok", s.getMessage().getData() + " : " + counter);
	}

	public void sendLetters(Socket s) {
		String letters = wordService.generateLetters(7);
		s.emit("letters", letters);
	}
}
