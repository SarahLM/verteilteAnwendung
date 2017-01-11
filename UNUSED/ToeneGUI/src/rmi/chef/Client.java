package rmi.chef;



import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.interfaces.Toene;
//import rmi.mitarbeiter.ToeneImpl;
import rmi.mitarbeiter.Server;





public class Client {
	//Chef stellt Dienst zur Verfügung um nach ButtonKlick die entsprechende ID zur Verfügung zu stellen
	

	public Client() {
		try {
			LocateRegistry.createRegistry(1099); //erstellt Registry 
		} catch (RemoteException e1) {
			
			e1.printStackTrace();
		}
		try {
			Toene a = new ToeneImpl();
			Naming.rebind("rmi://localhost:1099/ToeneService", a);//ID für Töne wird rausgegeben 
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		
			//Toene a = new ToeneImpl();
			//int a = eingegebener Button;  
			//Naming.rebind("rmi://localhost:1099/ToeneService",a);
			/*Toene a = (Toene) Naming
			.lookup("rmi://localhost:1099/KlickService");*/
			
			
		new Client();
		
	}
}


