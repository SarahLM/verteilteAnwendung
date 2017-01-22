package application;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterface extends Remote {
	
	MainScreenController lookup() throws RemoteException;
	
	

}
