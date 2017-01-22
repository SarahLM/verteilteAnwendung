package application;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import rmi.interfaces.InterfaceOfButtontest;
import rmi.interfaces.Observer;
import rmi.interfaces.Subject;

public class ButtonImpl extends UnicastRemoteObject implements Observer,{

		protected ButtonImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
	}

		/**
	 * 
	 */
		private String buttonID;

		Buttontest button = new Buttontest();
		
	private static final long serialVersionUID = 1L;

		@Override
		public void update(String buttonID) throws RemoteException {
			this.buttonID = buttonID;
		
		}

		public static void main(String[] args) throws RemoteException, IOException {
			Buttontest button1 = new Buttontest();
			Naming.rebind("rmi://localhost:1099/Button", button1);
		}

}
