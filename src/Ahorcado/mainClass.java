package Ahorcado;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) throws InterruptedException {
		Scanner keyboard = new Scanner (System.in);
		mainScreen player1 = new mainScreen();
		playerData p1=  new playerData();
		adivinandoPalabra l1= new adivinandoPalabra();
		player1.helloScreen(p1);
		player1.gameStart(0,p1,l1);
	}

}
