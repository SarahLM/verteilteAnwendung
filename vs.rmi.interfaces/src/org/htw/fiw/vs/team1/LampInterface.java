package org.htw.fiw.vs.team1;


public interface LampInterface extends java.rmi.Remote {
	
	public void changeStatus() throws java.rmi.RemoteException;
	public void turnOff() throws java.rmi.RemoteException;
}
