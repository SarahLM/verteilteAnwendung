package org.htw.fiw.vs.team4.sensor;

import java.rmi.RemoteException;

public interface IObservable extends java.rmi.Remote{
	
	public void register(IObserver o) throws RemoteException;

	public void unregister(IObserver o) throws RemoteException;

	public void notifyObservers(int lux) throws RemoteException;

}
