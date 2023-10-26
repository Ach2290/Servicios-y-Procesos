package threads;

import java.util.Random;

public class Coche  extends Thread {
	 
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
	               
	                try {
	                	 int tiempoVuelta = random.nextInt(2500+500); // Tiempo aleatorio entre 0.5 y 3 segundos
	                	 vueltas++;
	                    Thread.sleep(tiempoVuelta);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                
	            }
	        }
    
    }



