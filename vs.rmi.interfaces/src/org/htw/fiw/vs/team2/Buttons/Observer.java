package org.htw.fiw.vs.team2.Buttons;

	import java.rmi.NotBoundException;
import java.rmi.Remote;
	import java.rmi.RemoteException;

	public interface Observer extends Remote {

		public void update(int ButtonId)  throws RemoteException, NotBoundException;
		
	}
