package sincronizacion;

public  class CuentaBancaria {
	private double saldo;
	private int numIngresos;
	private String registro="";
	
	public synchronized void ingresar(double cantidad) {
		saldo+= cantidad;
		registro += "saldo: "+ saldo + "\n"; 
		numIngresos++;
	}
	public double getSaldo() {
		return saldo;
	}
	public String getRegistro() {
		return registro;
	}
	public int getNumIngresos() {
		return numIngresos;
	}
	
	

}
