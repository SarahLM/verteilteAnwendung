package rmi.chef;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//ist eigentlich der Vermittler!!!

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.registry.RegistryHandler;

import rmi.interfaces.*;

public class ToeneTest implements Observer{
	
	private String vermittlerName;
	private Subject subject;
	
	
	public ToeneTest() {

		try {
			String fromUser="";

			//VermittlerRemote c = new VermittlerRemoteImpl();
			//LocateRegistry.createRegistry(Registry.REGISTRY_PORT); //RMI-Registry starten
			//Registry registry = LocateRegistry.getRegistry(); //Erstellung der Registy
			
			//Naming.rebind("rmi://localhost:1099/vermittler", c);//stellt Service f�r T�neVermittlung

	         
			Registry registry = LocateRegistry.getRegistry(); 
			
			//hier bis
			
			
			
			final String[] boundNames = registry.list();
			for (int i = 0; i < registry.list().length; i++) {
				
				String string = registry.list()[i];
				System.out.println("Servicename: "+ string);
			}
			
			//hier
			//for (){
			System.out.println("ist gestartet");

			/*while (!fromUser.equals("exit")) {	
				BufferedReader user_br = new BufferedReader(new InputStreamReader(System.in));
				fromUser = user_br.readLine();
			}*/
			//}
			
			//Naming.rebind("rmi://localhost:1099/ToeneService", c);//stellt Service f�r T�neVermittlung
			//System.out.println("RMI-Registry und Service is ready.");
		} catch (Exception e) {
			System.out.println("RMI-intefaces-Server failed: " + e);
		}
	}
	
	
	



	public String getVermittlerName() {
		return vermittlerName;
	}

	public void setVermittlerName(String vermittlerName) {
		this.vermittlerName = vermittlerName;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	@Override
	public void update(String ButtonID) throws RemoteException {
			System.out.println("Hallo "+ vermittlerName +" der Button "+ ButtonID + " wurde gedr�ckt");
	}





}