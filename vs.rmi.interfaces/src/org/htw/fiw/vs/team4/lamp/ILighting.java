package org.htw.fiw.vs.team4.lamp;

import javafx.scene.paint.Color;

public interface ILighting extends java.rmi.Remote{

	public boolean isSwitchedOn()
			throws java.rmi.RemoteException;
	
	public String switchOn()
			throws java.rmi.RemoteException;
	
	public String switchOn(Color color)
			throws java.rmi.RemoteException;
	
	public String switchOff()
			throws java.rmi.RemoteException;

}
