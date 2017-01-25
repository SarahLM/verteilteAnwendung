package rmi.chef;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.interfaces.VermittlerRemote;
import rmi.interfaces.VermittlerRemoteImpl;

public class RegistryStarten {
	
	public RegistryStarten() throws RemoteException, IOException{

		VermittlerRemote c = new VermittlerRemoteImpl();
		try
		{
		  LocateRegistry.createRegistry( Registry.REGISTRY_PORT );
		  System.out.println("gestartet");
		}
		catch (Exception e) {
			System.out.println("RMI-intefaces-Server failed: " + e);
		}
		Naming.rebind("rmi://localhost:1099/TestService", c);//stellt Service für TöneVermittlung
	}
		
	public static void main(String[] args) throws RemoteException, IOException  {
		// TODO Auto-generated method stub
		new RegistryStarten();
	}

}
