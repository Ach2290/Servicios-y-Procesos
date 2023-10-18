package main;

import threads.Coche;

public class Main {

	public static void main(String[] args) {
        int N = 10; // Cantidad de pilotos en la carrera
        Coche[] coches = new Coche[N];

        // Inicializar los coches y comenzar la carrera
        for (int i = 0; i < N; i++) {
            coches[i] = new Coche("C" + (i + 1));
            coches[i].start();
        }

        // Simular la carrera durante 10 vueltas
        for (int vuelta = 1; vuelta <= 10; vuelta++) {
            try {
                Thread.sleep(1000); // Esperar 1 segundo entre actualizaciones
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Ordenar los coches según las vueltas completadas y mostrar el estado
            ordenarCoches(coches);
            System.out.println("Coche   Vuelta   Posición");
            System.out.println("---------------------");
            for (int i = 0; i < N; i++) {
                Coche coche = coches[i];
                System.out.println(coche.getNombre() + "       " + coche.getVueltas() + "        " + (i + 1));
            }
            System.out.println("\n");
        }
    }
}
