package rmi.chef;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import rmi.interfaces.MainScreenInterface;
import rmi.interfaces.Observer;
import rmi.interfaces.SoundInterface;

public class Vermittler extends java.rmi.server.UnicastRemoteObject implements Observer {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> usersGUI;
	private ArrayList<String> usersSounds;
	Registry registry;
	
	public Vermittler() throws RemoteException {
		super();
		usersGUI = new ArrayList<>();
		usersSounds = new ArrayList<>();
	}
	
	public void start() {
		
		try {
			
			registry = LocateRegistry.createRegistry(1099);
			
			while ( true ) {
				
				Thread.sleep(5000);
				
				final String[] services = registry.list();
				for ( String service : services ) {
					if ( service.substring(0, 3).equals("GUI") && !this.usersGUI.contains(service) ) {
						System.out.println("GUI Service added: " + service);
						MainScreenInterface msi = (MainScreenInterface) registry.lookup(service);
						msi.register(this);
						this.usersGUI.add(service);
					}
					
					if ( service.substring(0, 3).equals("SND") && !this.usersSounds.contains(service) ) {
						System.out.println("Sound Service added: " + service);
						this.usersSounds.add(service);
					}
				
				}
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws RemoteException {
		Vermittler s = new Vermittler();
		s.start();
}

	@Override
	public void update(int buttonId) throws RemoteException, NotBoundException {
		System.out.println("Button " + buttonId + " clicked.");
		try {
			for ( String service : usersSounds ) {
				System.out.println(service);
				SoundInterface si = (SoundInterface) registry.lookup(service);
				si.play(buttonId);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
