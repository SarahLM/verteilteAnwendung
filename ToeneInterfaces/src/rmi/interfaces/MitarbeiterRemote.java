package rmi.interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MitarbeiterRemote extends Remote {

	public String play(int msg)  throws RemoteException;
	
}