package main;

import threads.Coche;

public class Main {

	public static void main(String[] args) {
		int Ncoches = 10; // Cantidad de pilotos en la carrera
		Coche[] coches = new Coche[Ncoches];
		int vuetlascompletadas = 10;

		// Inicializar los coches y comenzar la carrera
		for (int i = 0; i < Ncoches; i++) {
			coches[i] = new Coche("Coche" + (i + 1));
			coches[i].start();
		}

		// Simular la carrera durante 10 vueltas
		do {

			try {
				Thread.sleep(1000); // Esperar 1 segundo entre actualizaciones
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Ordenar los coches según las vueltas completadas y mostrar el estado
			ordenarCoches(coches);
			System.out.println("Coche   Vuelta   Posición");
			System.out.println("---------------------");
			for (int i = 0; i < Ncoches; i++) {
				Coche coche = coches[i];
				System.out.println(coche.getNombre() + "       " + coche.getVueltas() + "        " + (i + 1));
			}
			System.out.println("\n");
		} while (quedanCoches(coches) == true);

	}

	private static void ordenarCoches(Coche[] coches) {
		for (int i = 0; i < coches.length - 1; i++) {
			for (int c = 0; c < coches.length - i - 1; c++) {
				if (coches[c].getVueltas() < coches[c + 1].getVueltas()) {
					Coche temp = coches[c];
					coches[c] = coches[c + 1];
					coches[c + 1] = temp;
				}
			}
		}
	}

	public static boolean quedanCoches(Coche[] coches) {

		for (int i = 0; i < 10; i++) {

			if (coches[i].getVueltas() != 10) {
				return true;
			} else {

			}

		}

		return false;

	}

}
