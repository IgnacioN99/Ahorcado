package Ahorcado;
import java.util.ArrayList;
import java.util.Scanner;
		/*
		 * en esta clase se generan las palabras para el juego
		 */
public abstract class generadorDePalabras {
	Scanner keyboard = new Scanner (System.in);
		ArrayList<String> words= new ArrayList<String>();
		public void newWords(){
			words.add("gato");
			words.add("perro");
			words.add("droga");
			words.add("kill");
			words.add("algo");
			words.add("buenos aires");
			words.add("jirafa");
			words.add("trabajo");
			words.add("jamon y queso");
		}
		public String randomWord(){
			newWords();
			int arrayWord;
			arrayWord=(int) Math.floor(Math.random() * words.size());
			return words.get(arrayWord);
		}
		
	}
