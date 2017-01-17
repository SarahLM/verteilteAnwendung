package rmi.interfaces;

	import java.rmi.Remote;
	import java.rmi.RemoteException;

	public interface Observer extends Remote {

		public void update(String ButtonID)  throws RemoteException;
		
	}
