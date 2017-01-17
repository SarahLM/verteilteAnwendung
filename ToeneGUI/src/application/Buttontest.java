package application;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import rmi.interfaces.*;

//Simulation des Frontends wo eine ButtonID �bergeben wird und ein status clicked

public class Buttontest extends UnicastRemoteObject implements Subject{

		protected Buttontest() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		private String buttonID;
		
		private boolean clicked;
		
		private List<Observer> ListOfObservers = new ArrayList<Observer>();
		
	

	public String getButtonID() {
		return buttonID;
	}

	public void setButtonID(String buttonID) {
		this.buttonID = buttonID;
	}

	public List<Observer> getListOfObservers() {
		return ListOfObservers;
	}

	public void setListOfObservers(List<Observer> listOfObservers) {
		this.ListOfObservers = listOfObservers;
	}
	
	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) throws RemoteException {
		this.clicked = clicked;
		if (clicked == true){
			notifyObserver(); //hier werden alle angemeldeten Observer informiert dass der button seinen Status ge�ndert hat
		}
	}
	
	
	
	@Override
	public void registerObserver(Observer observer) throws RemoteException {
		// TODO Auto-generated method stub
		ListOfObservers.add(observer); //f�ge den Observer zu der Liste hinzu
	}

	@Override
	public void notifyObserver() throws RemoteException {
		// informiere alle Observer dar�ber dass etwas passiert ist
		
		System.out.println("notify all Vermittler that Button has been clicked:");
		for(Observer observer : ListOfObservers){ 
		
			observer.update(this.buttonID);
		
		
		}
		System.out.println(ListOfObservers);
		
	}

	public static void main(String[] args) throws RemoteException, IOException {
		Buttontest button1 = new Buttontest();
		Naming.rebind("rmi://localhost:1099/ToeneServiceneu", button1);
	}

}
