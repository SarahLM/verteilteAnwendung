package rmi.interfaces;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import rmi.interfaces.*;

//Simulation des Frontends wo eine ButtonID übergeben wird und ein status clicked

public interface InterfaceOfButtontest {


		/**
	 * 
	 */

		//public String buttonID;
		
		//public boolean clicked;
		
		public List<Observer> ListOfObservers = new ArrayList<Observer>();
		
	

	public String getButtonID() ;
	//{return buttonID;}

	public void setButtonID(String buttonID) ;
	//{this.buttonID = buttonID;}

	public List<Observer> getListOfObservers() ;
	//{return ListOfObservers;}

	public void setListOfObservers(List<Observer> listOfObservers) ;
	//{this.ListOfObservers = listOfObservers;}
	
	public boolean isClicked() ;
	//{return clicked;}

	public void setClicked(boolean clicked) throws RemoteException ;
	/*{this.clicked = clicked;
		if (clicked == true){
			notifyObserver(); //hier werden alle angemeldeten Observer informiert dass der button seinen Status geändert hat
		}
	}*/
	
	
	
	/*@Override
	public void registerObserver(Observer observer) throws RemoteException ;
	{
		// TODO Auto-generated method stub
		ListOfObservers.add(observer); //füge den Observer zu der Liste hinzu
	}

	@Override
	public void notifyObserver() throws RemoteException {
		// informiere alle Observer darüber dass etwas passiert ist
		
		System.out.println("notify all Vermittler that Button has been clicked:");
		for(Observer observer : ListOfObservers){ 
		
			observer.update(this.buttonID);
		
		
		}
		System.out.println(ListOfObservers);
		
	}

	public static void main(String[] args) throws RemoteException, IOException {
		InterfaceOfButtontest button1 = new InterfaceOfButtontest();
		Naming.rebind("rmi://localhost:1099/ToeneServiceneu", button1);
	}
*/
}
