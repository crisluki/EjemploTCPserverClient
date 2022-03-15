package Semaforo;

public class Lanzador {
	
	public static Portero cola = new Portero();		//Cola con semaforo
	public static TCPejemplo1Servidor p1 = new TCPejemplo1Servidor(cola);	//Le paso al constructor la cola compartida
	public static TCPejemplo1Cliente c1 = new TCPejemplo1Cliente(cola);	//Le pàso al consumidor la cola compartida

	public Lanzador() {
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		//Un hilo productor y un hilo consumidor
		Thread hiloProductor = new Thread(p1);
		Thread hiloConsumidor = new Thread(c1);

		System.out.println("Empieza el metodo main ");
		//Lanzo un productor y un consumidor cada vez
		for (int i = 0; i<20; i++) {
			if(i<5) {hiloProductor.run();}
			else {
				hiloConsumidor.run();
			}
		}
	}
}