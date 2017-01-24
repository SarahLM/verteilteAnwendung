package src.application;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import rmi.interfaces.MainScreenInterface;
import rmi.interfaces.Observer;

public class RmiService extends UnicastRemoteObject implements MainScreenInterface{

	private static final long serialVersionUID = 1L;
	
	MainScreenController msc;

	public RmiService(MainScreenController msc) throws RemoteException {
		super(0);
		this.msc = msc;
	}

	public void start() throws MalformedURLException, RemoteException, AlreadyBoundException{

		// Sp�ter um ein Timeout erweitern
		boolean notBound = true;
		while (notBound) {
			try {
				int token = (int) ((Math.random()*99999)+1);
				Registry registry = LocateRegistry.getRegistry();
				registry.bind("GUI_" + String.format("%05d", token), this);
				notBound = false;
				System.out.println("Frontend Service ist ready");
			} catch (Exception e) {
				System.out.println("RMI-interfaces-client exception: " + e);
			}
		}

	}

	@Override
	public void setText(int buttonIndex, String text) throws RemoteException {
		msc.setText(buttonIndex, text);
	}

	@Override
	public void setBodyText(String text) throws RemoteException {
		msc.setBodyText(text);
	}

	@Override
	public void setPictures(int pictureIndex, boolean visible) throws RemoteException {
		msc.setPictures(pictureIndex, visible);
	}

	@Override
	public void register(Observer observer) throws RemoteException {
		msc.addObserver(observer);
	}

	@Override
	public void unregister(Observer observer) throws RemoteException {
		msc.removeObserver(observer);
}
	
}
