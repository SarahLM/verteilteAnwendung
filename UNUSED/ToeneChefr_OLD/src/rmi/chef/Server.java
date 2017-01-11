package rmi.chef;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import rmi.vermittler.*;

public class Server {
	
	public Server() {

		try {
			ServerRemote c = new ServerRemoteImpl();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/ToeneService", c);
			System.out.println("RMI-intefaces-Server is ready.");
		} catch (Exception e) {
			System.out.println("RMI-intefaces-Server failed: " + e);
		}
		System.out.println("RMI-intefaces-Server finished.");
	}
	
	public static void main(String args[]) {
	
		new Server();
		
	}
	
}