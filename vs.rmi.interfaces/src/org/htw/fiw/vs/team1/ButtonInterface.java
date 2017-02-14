package org.htw.fiw.vs.team1;


public interface ButtonInterface extends java.rmi.Remote {
	
	public void press() throws java.rmi.RemoteException;
	
	public void register(ControllerInterface ci) throws java.rmi.RemoteException;
	
	public void unregister(ControllerInterface ci) throws java.rmi.RemoteException;

}
