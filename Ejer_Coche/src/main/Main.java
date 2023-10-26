package main;

import java.util.ArrayList;

import threads.Coche;

public class Main {

	public static void main(String[] args) {
		int nPilotos = 10;
		ArrayList<Coche> coches = new ArrayList<Coche>();

		FinCarrera tabla = new FinCarrera(coches);
		
		System.out.println("---------------------");
		System.out.println("Coche   Vuelta   Posición");
        System.out.println("---------------------");
		for (int i = 0; i < nPilotos; i++) {
			Coche coche = new Coche(i + 1, tabla);
			coches.add(coche);
			System.out.print(coches.get(i).getName() + "    ");
			System.out.print( coches.get(i).getVueltas() + "    ");
			System.out.println( (i + 1));
			coche.start();
		}
	}
	}

