package Ahorcado;

import java.util.ArrayList;
/*
 * En esta clase se almacenan todos los datos del jugador
 */
public class playerData {
	private String name;
	private int lifes, gamesPlayed, winGames, lostGames;
	private ArrayList<String> wordsGuessed= new ArrayList<String>();
	private ArrayList<String> notGuessedWrds= new ArrayList<String>();
	
	public ArrayList<String> getWordsGuessed() {
		return wordsGuessed;
	}
	public void setWordsGuessed(String Word) {
		wordsGuessed.add(Word);
		}
	public ArrayList<String> getNotGuessedWrds() {
		return notGuessedWrds;
	}
	public void setNotGuessedWrds(String wrongWord) {
		notGuessedWrds.add(wrongWord);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLifes() {
		return lifes;
	}
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed() {
		this.gamesPlayed = winGames+lostGames;
	}
	public int getWinGames() {
		return winGames;
	}
	public void setWinGames() {
		this.winGames++;
	}
	public int getLostGames() {
		return lostGames;
	}
	public void setLostGames() {
		this.lostGames++;
	}
	public int substractLifes(){
		int actualLifes = getLifes();
		return actualLifes++;
	}
	
}
