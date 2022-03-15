package Semaforo;

import java.util.concurrent.Semaphore;

public class Portero {
	private static final int MAX_AVAILABLE = 5; // tamño maximo de permisos
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, false); // el semaforo
// Lo que la cola administra (un array de enteros que rellena el productor)
	protected String[] items = new String[MAX_AVAILABLE];
//Un array que marca los elementos del array anterior como consumidos o disponibles
//disponible = false, consumido = true
	protected boolean[] used = new boolean[MAX_AVAILABLE];
	protected TCPejemplo1Servidor p1 = new TCPejemplo1Servidor();
	protected int e = 0;

	public void coger(String cadena) throws InterruptedException {
//persona coge espacios
		available.acquire();
		System.out.println(ocupar(cadena));
		available.release();
	}

	protected synchronized String ocupar(String cadena) throws InterruptedException {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (used[i]) {
				Thread.sleep(100);
				used[i] = false;
				return p1.run(cadena);
			}
		}
		return "No hay espacio"; // not reached
	}
	protected synchronized void reponer() throws InterruptedException {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
			}
		} // not reached
	}
}
