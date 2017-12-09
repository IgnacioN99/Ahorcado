package Ahorcado;

import java.util.Arrays;

public class adivinandoPalabra extends generadorDePalabras implements muchosEnter {
	private String letters;
	private char[] quantityOfLetters;
	private char[] misteryWordArr;
	private int lifes;
	/*
	 * Getter de las letras
	 */
	public String getLetters() {
		return letters;
	}
	/*
	 * Auxiliar para las vidas sin nescesidad de modificar las vidas de la clase de los datos del jugador
	 */
	public void setLifes(playerData p1){
		this.lifes=p1.getLifes();
	}
	public int getLifes() {
		return lifes;
	}
	@Override
	/**
	 * Metodo de interfaz para aplicar muchos enter
	 */
	public void aLotOfEnter() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}
	public void setLetters() {
		this.letters = randomWord();
	}

	public void setQuantityOfLetters() {
		this.quantityOfLetters = randomWord().toCharArray();
	}
	public char[] getNumberOfLetters() {
		return quantityOfLetters;
	}
	

	public char[] getQuantityOfLetters() {
		return quantityOfLetters;
	}

	public char[] getMisteryWordArr() {
		return misteryWordArr;
	}
	/**
	 * Metodo para escribir los Guiones bajos o medios si son espacios
	 */
	public void emptyWord() {
		letters=randomWord();
		quantityOfLetters=letters.toCharArray();
		String misteryWord = "";
		aLotOfEnter();
		for (char c : quantityOfLetters) {
			if(c==(char)32){
				System.out.print("- ");
				misteryWord+="-";
				
			}else{
			System.out.print("_ ");
			misteryWord += "_";
			}
		}
		System.out.println("Cantidad de vidas " + getLifes());
		misteryWordArr = misteryWord.toCharArray();
	}
	
	private boolean correct=false;
	/**
	 * Metodo para cuando el usuario esta adivinando las letras
	 * @param letter= Letra ingresada
	 * @param p1
	 */
	public void guessingLetter(char letter, playerData p1) {
	
		aLotOfEnter();
		for (int c = 0; c < quantityOfLetters.length; c++) {
			if(quantityOfLetters[c]==(char) 32){
				quantityOfLetters[c] = '-';
			}
			if (quantityOfLetters[c] == letter){
				misteryWordArr[c] = quantityOfLetters[c];
				correct=true;
				}
		
			System.out.print(misteryWordArr[c]);
			System.out.print(" ");

		}
		if (correct==false) {
			p1.setLifes(--lifes);
		}else{
			correct=false;
		}
		System.out.println("Cantidad de vidas " + p1.getLifes());

	}
	/**
	 * Metodo para para detener la partida en caso de que las vidas sean iguales a 0 pierde y si ambos arrays son iguales gana
	 * @param p1
	 * @return
	 */
	public boolean palabraAdivinada(playerData p1){
		if(Arrays.equals(quantityOfLetters, misteryWordArr)){
			p1.setWinGames();
			p1.setWordsGuessed(letters);
			return false;
		}else if(p1.getLifes()==0){
			p1.setLostGames();
			p1.setNotGuessedWrds(letters);
			return false;
		}
		return true;
	}
	public boolean winGame(playerData p1){
		if(Arrays.equals(quantityOfLetters, misteryWordArr)){
			return true;
		}else if(p1.getLifes()==0){
			return false;
		}
		return false;
	}
	
}
