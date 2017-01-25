package rmi.mitarbeiter;

//ist der Mitarbeiter
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.interfaces.SoundInterface;
import rmi.mitarbeiter.Sound;

public class Mitarbeiter extends UnicastRemoteObject implements SoundInterface {

	private static final long serialVersionUID = 1L;
	
	Sound sound;
	
	public Mitarbeiter() throws RemoteException {
		super();
		sound = new Sound();
	}
	
	public void start() {
		
		// Sp�ter um ein Timeout erweitern
		boolean notBound = true;
		while (notBound) {
			try {
				int token = (int) ((Math.random()*99999)+1);
				Registry registry = LocateRegistry.getRegistry("141.45.214.117",1099);
				registry.rebind("SND_" + String.format("%05d", token), this);
				notBound = false;
				System.out.println("Sound Service ist ready");
			} catch (Exception e) {
				System.out.println("RMI-interfaces-client exception: " + e);
			}
		}
		
	}
	  
	public static void main(String[] args) throws RemoteException {

		Mitarbeiter m = new Mitarbeiter();
		m.start();

	}

	@Override
	public void play(int msg) throws RemoteException {
		sound.run(msg);
	}

}
