package rmi.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VermittlerInterface extends Remote {
	
	void update(int buttonIndex) throws RemoteException;

}
