package rmi.chef;


import java.rmi.RemoteException;

import rmi.interfaces.Toene;

public class ToeneImpl extends java.rmi.server.UnicastRemoteObject implements Toene {
	
	protected ToeneImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String ton(String b) throws RemoteException {
		
		
		return b;
	}

	

	

	
}
