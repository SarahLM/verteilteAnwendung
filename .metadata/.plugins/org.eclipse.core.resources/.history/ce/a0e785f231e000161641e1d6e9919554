package rmi.interfaces;


import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.*;

@SuppressWarnings("serial")
public class VermittlerRemoteImpl extends UnicastRemoteObject implements VermittlerRemote {

	private Vector<MitarbeiterRemote> clients = new Vector<MitarbeiterRemote>();
	
	public VermittlerRemoteImpl() throws RemoteException {
		//super();
	}

	public String sayHello(String user) {
		
		return "hello " + user; //wird in Client übergeben

	}

	public synchronized void addClient ( MitarbeiterRemote o ) throws RemoteException {
		
		clients.addElement( o ); //übergeben Verweis auf sich selber
		System.out.println("added new client");
		
    }

	public  synchronized String play(int msg) throws RemoteException {
    
		for (Enumeration<MitarbeiterRemote> e = clients.elements(); e.hasMoreElements();) {
			MitarbeiterRemote client = (MitarbeiterRemote) e.nextElement();
			try {
				client.play(msg);
			} catch (RemoteException ex) {
				System.out.println("play on client " + client + " failed.");
			}
		}
		
		return "";
	
	}

}
