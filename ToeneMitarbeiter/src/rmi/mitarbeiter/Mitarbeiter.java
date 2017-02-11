package rmi.mitarbeiter;

//ist der Mitarbeiter
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.htw.fiw.vs.IBinder;

//import rmi.interfaces.SoundInterface;
import org.htw.fiw.vs.team2.MitarbeiterToene.*;

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
				
				Registry connectRegistry = LocateRegistry.getRegistry("192.168.100.31", 1099);
				IBinder registry = (IBinder) connectRegistry.lookup("binder");
				
				//Registry registry = LocateRegistry.getRegistry("141.45.207.220",1099);
				registry.bind("SND_" + String.format("%05d", token), this);
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
