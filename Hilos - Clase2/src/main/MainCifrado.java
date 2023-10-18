package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import threads.HiloCifrado;
import threads.HiloProductor;

public class MainCifrado {

	//El USUARIO INTRODUCE UNA CADENA
	//LUEGO TENEMOS CODIGO DE CIFRADO QUE ES UN ENTERO
	//
	//CODIGO DE CIFRADO : 20
	//HOLA
	//H -> + 20
	//O -> + 20
	//L -> + 20
	//A -> + 20
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<HiloCifrado>hilos = new ArrayList<>();
		String cifrado;
		int codigo;
		
		System.out.println("Introduce una cadena");
		cifrado=scanner.nextLine();
		
		for(int i =0; i< cifrado.length();i++ ) {
			HiloCifrado newHilo = new HiloCifrado(cifrado, i);
	
			hilos.add(newHilo);
			newHilo.start();
		}
		try {
			
				for (HiloCifrado hilo :hilos) {
					hilo.join();
				}
				
				System.out.println(Arrays.toString());
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


