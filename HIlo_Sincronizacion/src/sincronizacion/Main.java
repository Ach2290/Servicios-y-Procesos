package sincronizacion;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria();
		ArrayList<HiloCliente>clientes = new ArrayList<HiloCliente>();
		
		for(int i = 0; i<25;i++) {
			HiloCliente hc = new HiloCliente(cuenta);
			clientes.add(hc);
			hc.start();
			
		}
		try {
			for(int i = 0; i<25;i++ ) {
				clientes.get(i).join();
			}
		}catch(InterruptedException ex) {
			System.err.println(ex.getMessage());
		}
		System.out.println(cuenta.getSaldo());
		System.out.println(cuenta.getRegistro());
		System.out.println(cuenta.getNumIngresos());
	}

}
