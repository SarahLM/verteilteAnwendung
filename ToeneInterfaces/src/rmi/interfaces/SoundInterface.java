package rmi.interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SoundInterface extends Remote {

	public void play(int msg) throws RemoteException;
	
}