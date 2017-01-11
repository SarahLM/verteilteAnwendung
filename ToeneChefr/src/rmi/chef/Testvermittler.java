package rmi.chef;

import java.rmi.registry.LocateRegistry;

import rmi.mitarbeiter.testmitarbeiter;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Testvermittler {
	
	public Testvermittler(){
		
		try
	      {
	        final Registry registry = LocateRegistry.getRegistry(1099);
	         final String[] boundNames = registry.list();
	         System.out.println(
	            "Names bound to RMI registry at host " + "localhost" + " and port "+ ":");
	         for (final String name : boundNames)
	         {
	            System.out.println("\t" + name);
	         }
	      }
	      catch (ConnectException connectEx)
	      {
	         System.err.println(
	              "ConnectionException - Are you certain an RMI registry is available at port "
	            + connectEx.toString());
	      }
	      catch (RemoteException remoteEx)
	      {
	         System.err.println("RemoteException encountered: " + remoteEx.toString());
	      }
	   }
	
	
	public static void main(String args[]) {
		
		new Testvermittler();
		
	}
}
