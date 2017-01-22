package application;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiService extends UnicastRemoteObject implements MainScreenInterface{

	MainScreenController msc;



	public RmiService(MainScreenController msc) throws RemoteException {
		super(0);
		this.msc = msc;
	}

	public void start() throws MalformedURLException, RemoteException, AlreadyBoundException{



		try{
			//MainScreenInterface stub = (MainScreenInterface) UnicastRemoteObject.exportObject(this,0);


			Registry registry = LocateRegistry.createRegistry(1099);
			Naming.rebind("rmi://localhost:1099/RmiService" , new MainScreenInterfaceImpl());

			System.out.println("Frontend Service ist ready");
		} catch (Exception e){
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	@Override
	public void setText(int buttonIndex, String text) throws RemoteException {
		msc.setText(buttonIndex, text);
		System.err.println("blah");

	}

	@Override
	public void setBodyText(String text) throws RemoteException {
		msc.setBodyText(text);

	}

	@Override
	public void setPictures(int pictureIndex, boolean visible) throws RemoteException {
		msc.setPictures(pictureIndex, visible);

	}



}