package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import threads.HiloProductor;

public class MainHiloVariable {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<HiloProductor>hilos = new ArrayList<>();
		int[]numeros;
		int cantidad;
		
		System.out.println("Introduce ña cantidad de numeros que quieres");
		cantidad=scanner.nextInt();
		
		numeros = new int [cantidad];
		//1. CREAMOS UN NUEVO HILO Y LE PASAMOS SU POSICION
		for(int i =0; i< cantidad;i++ ) {
			HiloProductor newHilo = new HiloProductor(numeros, i);
		//2. AÑADIMOSEL HILO A LA LISTA
			hilos.add(newHilo);
		//3ARRANCAMOS EL HILO
			newHilo.start();
		}
		try {
		//4 ESPERAR A TODOS LOS HILOS	
			for (HiloProductor hilo :hilos) {
				hilo.join();
			}
		//5 MOSTRAR EL ARRAY	
			System.out.println(Arrays.toString(numeros));
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
