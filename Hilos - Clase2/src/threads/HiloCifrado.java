package threads;

public class HiloCifrado extends Thread{
	private String cifrado;
	private int codigo;
	public HiloCifrado(String cifrado, int codigo) {
	
		this.cifrado = cifrado;
		this.codigo = codigo;
	} 

}
