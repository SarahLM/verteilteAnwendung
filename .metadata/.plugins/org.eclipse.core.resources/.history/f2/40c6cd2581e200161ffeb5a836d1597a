package rmi.interfaces;

import java.rmi.RemoteException;

public interface MainScreenInterface extends java.rmi.Remote{
	
	void setText(int buttonIndex, String text) throws RemoteException;
	void setBodyText(String text) throws RemoteException;
	void setPictures(int pictureIndex, boolean visible) throws RemoteException;
	void register(Observer observer) throws RemoteException;
	void unregister(Observer observer) throws RemoteException;
	
}
