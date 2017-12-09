package Ahorcado;


import java.util.Scanner;

public class mainScreen  implements muchosEnter {
	Scanner keyboard = new Scanner (System.in);
	@Override
	public void aLotOfEnter() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
	}
	public void helloScreen(playerData p1) throws InterruptedException {
		System.out.println("================================================");
		System.out.println("|         Bienvenido a el ahorcado	        |");
		System.out.println("================================================");
		System.out.println("Por favor ingrese su nombre");
		p1.setName(keyboard.nextLine());
	}
	public boolean mainMenu(playerData p1, adivinandoPalabra a) throws InterruptedException{
		int seleccion;
		boolean continuar = true;
		System.out.println("Bienvenido " + p1.getName() + " seleccione lo que desea hacer" );
		System.out.println(" 1. Comenzar el juego \n 2. Retomar el anterior juego \n 3. Mostrar estadisticas \n 4.Creditos \n 5. Salir");
		seleccion = keyboard.nextInt();
		switch(seleccion){
		case 1:
			return continuar = false;
		case 2:
			if (p1.getGamesPlayed()==0){
				System.out.println(p1.getName()+" NO HAS JUGADO NINGUN JUEGO!!!!!");
				return mainMenu(p1,a);
			}else{
				gameStart(1, p1, a);
			}
			break;
		case 3:
			System.out.println("======================================================================");
			System.out.println("|\t Cantidad de juegos: "+p1.getGamesPlayed());
			Thread.sleep(1000);
			System.out.println("|\t Cantidad de juegos ganados: "+p1.getWinGames());
			Thread.sleep(1000);
			System.out.println("|\t Cantidad de juegos perdidos: "+p1.getLostGames() );
			Thread.sleep(1000);
			System.out.println("|\tEstas son las palabras que adivinaste: " + p1.getWordsGuessed());
			Thread.sleep(1000);
			System.out.println("|\tEstas son las palabras que no adivinaste: "+ p1.getNotGuessedWrds());
			Thread.sleep(1000);
			System.out.println("=====================================================================");
			Thread.sleep(1000);
			aLotOfEnter();
			return mainMenu(p1,a);
		case 4:
			System.out.println("Juego creado por el alumno Ignacio Nicolas Flores del Curso inicial de Java");
			Thread.sleep(1000);
			System.out.println("Profesor a cargo del Trabajo:  Martin Isusi");
			Thread.sleep(1000);
			System.out.println("Nombre del tp: Ahorcado");
			Thread.sleep(1000);
			aLotOfEnter();
			return mainMenu(p1,a);
		case 5:
			System.out.println("Gracias por haber jugado "+ p1.getName()+" Espero que vuelvas pronto");
			break;
		default:
			System.out.println("Error, No existe ese comando!");
			return mainMenu(p1,a);
			
		}
		return continuar;
	}
	public void gameStart(int primerJuego, playerData p1, adivinandoPalabra a) throws InterruptedException{
		switch (primerJuego) {
		case 0:
			if(mainMenu(p1,a)==false){
				p1.setLifes(5);
				a.setLifes(p1);
				a.emptyWord();
				do{
				a.guessingLetter(keyboard.next().charAt(0), p1);
				}while(a.palabraAdivinada(p1));
				gameEnded(newGame(a,p1),p1,a);
			}
			break;
		case 1:
			p1.setLifes(5);
			a.setLifes(p1);
			a.emptyWord();
			do{
				a.guessingLetter(keyboard.next().charAt(0), p1);
			}while(a.palabraAdivinada(p1));
			gameEnded(newGame(a,p1),p1,a);
			break;
		}
		
	}
	public boolean newGame(adivinandoPalabra a,playerData p1){
		char rta='a';
		boolean gameEnded = false;
		if(a.winGame(p1)== false){
			aLotOfEnter();
			System.out.println("Palabra del juego: " +a.getLetters());
			System.out.println("Juego Terminado");
			System.out.println("YOU LOSE BITCH");
			System.out.println("Desea jugar de nuevo? s/n");
			rta=(char)keyboard.next().charAt(0);
		}
		if(a.winGame(p1)==true){
			aLotOfEnter();
			System.out.println("Palabra del juego: " +a.getLetters());
			System.out.println("Juego Terminado");
			System.out.println("YOU WIN, CONGRATULEISHONS :D");	
			System.out.println("Desea jugar de nuevo? s/n");
			rta=keyboard.next().charAt(0);
		}
		Character.toLowerCase(rta);
		switch (rta){
			case 's':
			case 'S':
				gameEnded=false;
				break;
			case 'N':
			case 'n':
				gameEnded=true;
				break;
		}
		return gameEnded;
		
	}
	public void gameEnded(boolean a,playerData p1,adivinandoPalabra b) throws InterruptedException{
		p1.setGamesPlayed();
		if (a== true){
			System.out.println("Juego TERMINADO \nespero que haya disfrutado el juego, sin mas preambulos aqui estan sus Estadisticas de juego");
			System.out.println("======================================================================");
			System.out.println("|\t Cantidad de juegos: "+p1.getGamesPlayed());
			Thread.sleep(1000);
			System.out.println("|\t Cantidad de juegos ganados: "+p1.getWinGames());
			Thread.sleep(1000);
			System.out.println("|\t Cantidad de juegos perdidos: "+p1.getLostGames() );
			Thread.sleep(1000);
			System.out.println("|\tEstas son las palabras que adivinaste: " + p1.getWordsGuessed());
			Thread.sleep(1000);
			System.out.println("|\tEstas son las palabras que no adivinaste: "+ p1.getNotGuessedWrds());
			Thread.sleep(1000);
			System.out.println("=====================================================================");
			Thread.sleep(1000);
			aLotOfEnter();
			mainMenu(p1,b);
		}else{
			gameStart(1,p1,b);
		}
	}
	
}
