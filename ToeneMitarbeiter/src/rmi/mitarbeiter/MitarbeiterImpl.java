package rmi.mitarbeiter;

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.interfaces.Sound;
import rmi.interfaces.VermittlerRemote;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class MitarbeiterImpl extends UnicastRemoteObject implements Remote, VermittlerRemote {
	
	protected MitarbeiterImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	Sound sound = new Sound();
	@Override
	public String play(int msg) throws RemoteException {
		sound.run(msg);
		return "";
	}
	

}