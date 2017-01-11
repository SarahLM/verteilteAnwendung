package rmi.chef;

//ist eigentlich der Vermittler!!!

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.registry.RegistryHandler;

import rmi.interfaces.*;

public class Vermittler {
	
	public Vermittler() {

		try {
			VermittlerRemote c = new VermittlerRemoteImpl();
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT); //RMI-Registry starten
			//Registry registry = LocateRegistry.getRegistry(); //Erstellung der Registy
			
			Naming.rebind("rmi://localhost:1099/vermittler", c);//stellt Service f�r T�neVermittlung

	         
			Registry registry = LocateRegistry.getRegistry(); //Erstellung der Registy
			
			
			final String[] boundNames = registry.list();
			for (int i = 0; i < registry.list().length; i++) {
				
				String string = registry.list()[i];
				System.out.println(string);
			}
			//for (){
			System.out.println("ist gestartet");

				
			//}
			
			//Naming.rebind("rmi://localhost:1099/ToeneService", c);//stellt Service f�r T�neVermittlung
			//System.out.println("RMI-Registry und Service is ready.");
		} catch (Exception e) {
			System.out.println("RMI-intefaces-Server failed: " + e);
		}
	}
	
	public static void main(String args[]) {
	
		new Vermittler();
		
	}
	
}