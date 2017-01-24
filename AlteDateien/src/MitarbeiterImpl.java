

import java.rmi.Remote;
import java.rmi.RemoteException;

import rmi.interfaces.MitarbeiterRemote;
import rmi.interfaces.Sound;
import rmi.interfaces.VermittlerRemote;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class MitarbeiterImpl extends UnicastRemoteObject implements Remote, MitarbeiterRemote {
	
	protected MitarbeiterImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	Sound sound = new Sound();
	String fromUser="";

	
	@Override
	public String play(int msg) throws RemoteException {
		sound.run(msg);
		
		return "";
	}
	
	

}
