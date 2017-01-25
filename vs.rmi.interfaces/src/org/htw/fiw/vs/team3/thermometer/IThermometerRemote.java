package org.htw.fiw.vs.team3.thermometer;

public interface IThermometerRemote extends java.rmi.Remote{
	public double getTemperatur() throws java.rmi.RemoteException;
}
