package application;

import java.io.Serializable;
import java.rmi.RemoteException;

public class MainScreenInterfaceImpl implements MainScreenInterface, Serializable{

	//	MainScreenController msc;

	public MainScreenInterfaceImpl() {
		super();

		//		this.msc = msc;
	}

	@Override
	public void setText(int buttonIndex, String text) throws RemoteException {
		//		msc.setText(buttonIndex, text);
		System.out.println("fsdf");	
	}

	@Override
	public void setBodyText(String text) throws RemoteException {
		//		msc.setBodyText(text);

	}

	@Override
	public void setPictures(int pictureIndex, boolean visible) throws RemoteException {
		//		msc.setPictures(pictureIndex, visible);

	}




}