package com.scrabble.services;

import org.springframework.stereotype.Service;

@Service
public class WordService {
	public WordService() {
	}
	
	public char generateLetter() {
		return (char)('A' + (int)(Math.random() * 26));
	}
	
	public String generateLetters(int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s = s + generateLetter();
		}
		return s;
	}
}
