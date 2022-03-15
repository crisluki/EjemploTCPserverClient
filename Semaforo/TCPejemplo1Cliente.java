package Semaforo;


public class TCPejemplo1Cliente implements Runnable{
	public Portero cola;
	String cadena="El PÉrico  SalIó bueno";
	public TCPejemplo1Cliente(Portero cola) {
		this.cola = cola;
		this.cadena="El PÉrico  SalIó bueno";
	}
	@Override
	public void run() {
		System.out.println("Inicio Peticion y envio cadena" );
		try {
			cola.coger(cadena);
		} catch (InterruptedException e) {
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
		}
	}

}