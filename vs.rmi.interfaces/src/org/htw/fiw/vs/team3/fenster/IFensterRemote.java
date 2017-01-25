package org.htw.fiw.vs.team3.fenster;

public interface IFensterRemote extends java.rmi.Remote{
	public void openWindow() throws java.rmi.RemoteException;
	public void closeWindow() throws java.rmi.RemoteException;
}
