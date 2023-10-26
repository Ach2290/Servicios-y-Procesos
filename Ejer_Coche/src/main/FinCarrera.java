package main;

import java.util.ArrayList;

import threads.Coche;

public class FinCarrera {
	private ArrayList<Coche> coches;

	public FinCarrera(ArrayList<Coche> coches) {
		this.coches = coches;
	}

	public synchronized void actualizar(Coche coche) { 
		boolean added = false;
		for (int i = 0; i < coches.size(); i++) {
			if (!added) {
				if (coche.getVueltas() > coches.get(i).getVueltas()) {
					coches.add(i, coche);
					added = true;
				}else{
					
					if(coche.equals(coches.get(i))){
						break;
					}
				}
			} else {
				if (coche.equals(coches.get(i))) {
					coches.remove(i);
					break;
				}
			}
		}
		System.out.println("---------------------");
		System.out.println("Coche   Vuelta   Posición");
        System.out.println("---------------------");
		for (int i = 0; i < coches.size(); i++) {
			System.out.print(coches.get(i).getName() + "    ");
			System.out.print( coches.get(i).getVueltas() + "    ");
			System.out.println( (i + 1));
			
		}
	}

	public ArrayList<Coche> getCoches() {
		return coches;
	}

}