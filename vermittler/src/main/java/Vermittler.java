//package rmi.chef;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import org.htw.fiw.vs.IBinder;

//import rmi.interfaces.MainScreenInterface;
import org.htw.fiw.vs.team2.Buttons.*;
import org.htw.fiw.vs.team2.MitarbeiterToene.SoundInterface;


//import rmi.interfaces.Observer;
//import rmi.interfaces.SoundInterface;


public class Vermittler extends java.rmi.server.UnicastRemoteObject implements Observer {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> usersGUI;
	private ArrayList<String> usersSounds;

	private IBinder registry;
	
	public Vermittler() throws RemoteException {
		super();
		usersGUI = new ArrayList<>();
		usersSounds = new ArrayList<>();
	}
	
	public void start() {
		
		
		
		try {
			
			//registry = LocateRegistry.getRegistry(1099);
			Registry connectRegistry = LocateRegistry.getRegistry("141.45.207.220", 1099);
			registry = (IBinder) connectRegistry.lookup("binder");
			
			
			while ( true ) {
				
				Thread.sleep(5000);
				
				
				final String[] services = registry.list();
				for ( String service : services ) {
					
					if ( service.substring(0, 3).equals("GUI") && !usersGUI.contains(service) ) {
						System.out.println("GUI Service added: " + service);
						MainScreenInterface msi = (MainScreenInterface) registry.lookup(service);
						msi.register(this);
						msi.setBodyText("Bis Boss ruft zum");
						msi.setText(1, "Meeting");
						msi.setText(2, "Dinner");
						msi.setText(3, "After Work");
						usersGUI.add(service);
						
					}
					
					if ( service.substring(0, 3).equals("SND") && !usersSounds.contains(service) ) {
						System.out.println("Sound Service added: " + service);
						usersSounds.add(service);
					}
					
					//System.out.println(service);
				
				}
				
				//System.out.println("");				
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