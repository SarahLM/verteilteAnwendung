package rmi.chef;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//ist eigentlich der Vermittler!!!

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.registry.RegistryHandler;

import rmi.interfaces.*;

public class weitererVermittler implements Observer{
	
	private String vermittlerName;
	private Subject subject;
	
	
	public weitererVermittler() {

		try {
			String fromUser="";

			VermittlerRemote c = new VermittlerRemoteImpl();
			//Registry registry = LocateRegistry.getRegistry(); //Erstellung der Registy
			
			Naming.rebind("rmi://localhost:1099/vermittlerzwei", c);//stellt Service für TöneVermittlung

	         
			
			//hier bis
			
			
			
			//hier
			//for (){
			System.out.println("ist gestartet2");

			
			//}
			
			//Naming.rebind("rmi://localhost:1099/ToeneService", c);//stellt Service für TöneVermittlung
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
			System.out.println("Hallo "+ vermittlerName +" der Button "+ ButtonID + " wurde gedrückt");
	}





}