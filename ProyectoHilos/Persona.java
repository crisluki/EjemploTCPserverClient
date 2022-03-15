package ProyectoHilos;

public class Persona implements Runnable{
	public int numeroPersona;
	public Portero portero;
	@Override
	public void run() {
		System.out.println("Pido un numero a la cola: " );
		try {
			portero.permitirODenegar();
		} catch (InterruptedException e) {
			System.out.println("Ha ocurrido un error");
			e.printStackTrace();
		}
	}}
