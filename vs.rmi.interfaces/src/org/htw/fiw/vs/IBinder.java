package org.htw.fiw.vs;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBinder extends Remote {

	void bind(String name, Remote object) throws RemoteException;

	String[] list() throws RemoteException;

	Remote lookup(String name) throws RemoteException;


}
