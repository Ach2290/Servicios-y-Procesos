package threads;

import java.util.Random;

import main.FinCarrera;

public class Coche extends Thread {
	private static int maxVueltas = 10;
	private int vueltas;
	private FinCarrera tabla;

	public Coche(int n,FinCarrera tabla) {
		setName("Coche" + n);
		vueltas = 0;
		this.tabla=tabla;
	}

	public void run() {
		do {
			try {
				sleep(new Random().nextLong(500, 3001));
				vueltas++;
				tabla.actualizar(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (vueltas < maxVueltas);
	}
	
	public int getVueltas() {
		return vueltas;
	}
}