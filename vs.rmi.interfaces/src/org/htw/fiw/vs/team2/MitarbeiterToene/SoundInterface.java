package org.htw.fiw.vs.team2.MitarbeiterToene;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SoundInterface extends Remote {

	public void play(int msg) throws RemoteException;
	
}