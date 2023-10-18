package threads;

import java.util.Random;

public class Coche extends Thread{
	private String nombre;
    private int vueltas;

    public Coche(String nombre) {
        this.nombre = nombre;
        this.vueltas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVueltas() {
        return vueltas;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int vuelta = 1; vuelta <= 10; vuelta++) {
            int tiempoVuelta = random.nextInt(2500) + 500; // Tiempo aleatorio entre 0.5 y 3 segundos
            try {
                Thread.sleep(tiempoVuelta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vueltas++;
        }
    }


// Método para ordenar los coches según las vueltas completadas
public static void ordenarCoches(Coche[] coches) {
    for (int i = 0; i < coches.length - 1; i++) {
        for (int j = 0; j < coches.length - i - 1; j++) {
            if (coches[j].getVueltas() < coches[j + 1].getVueltas()) {
                Coche temp = coches[j];
                coches[j] = coches[j + 1];
                coches[j + 1] = temp;
            }
        }
    }
}
}