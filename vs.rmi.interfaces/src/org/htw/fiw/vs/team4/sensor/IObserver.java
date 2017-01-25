package org.htw.fiw.vs.team4.sensor;

import java.rmi.RemoteException;

public interface IObserver extends java.rmi.Remote{

	public void update(int lux) throws RemoteException;
	
}
