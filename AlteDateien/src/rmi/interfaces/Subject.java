package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subject extends Remote {

	public void registerObserver(Observer observer)  throws RemoteException;
	public void notifyObserver()  throws RemoteException;

	
}