package ProyectoHilos;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
public class Portero {
	Edificio edi=new Edificio();
	protected int NUM_MAX_PERSONAS=edi.getNUM_MAX_PERSONAS();
	protected int PERSONAS_ACTUALMENTE=0;
	private final Semaphore available = new Semaphore(NUM_MAX_PERSONAS, false);
	protected ArrayList<Integer>listaHuecos = new ArrayList<Integer>();
	protected boolean[] used = new boolean[NUM_MAX_PERSONAS];
	protected int e=0;


	public Portero() {
		super();
	}

	public void permitirODenegar() throws InterruptedException {
	//persona coge espacios
	available.acquire();
	ocupar();
	available.release();
	}

	public void salir(int x) throws InterruptedException {
	//local aumentas espacios
	available.acquire();
	if (reponer(x)) {
	available.release();
	}
	}
	protected synchronized void ocupar() throws InterruptedException {
	for(int i=0;1< items.length;i++) {
	if(!used[i]) {
	System.out.println("Cliente "+e+" coge "+ items[i]);e++;
	used[i]=true;
	reponer(i);
	}
	}
	}

	protected synchronized boolean reponer(int item) throws InterruptedException {
	for (int i = 0; i < MAX_AVAILABLE; ++i) {
	if (used[i]) {
	Thread.sleep(100);
	items[i] = item;
	used[i]=false;
	return true;
	}
	}
	return false;

	}
}
