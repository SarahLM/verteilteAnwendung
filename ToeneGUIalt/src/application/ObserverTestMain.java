package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import rmi.chef.*;

public class ObserverTestMain {

	public static void main(String[] args) throws RemoteException, IOException {
		// TODO Auto-generated method stub
			
			Vermittler Toene = new Vermittler();
			Toene.setVermittlerName("ToeneApp");


			weitererVermittler Lampe = new weitererVermittler();
			Lampe.setVermittlerName("LampeApp");


			/*Buttontest button1 = new Buttontest();
			Naming.rebind("rmi://localhost:1099/ToeneServiceneu", button1);//stellt Service f�r T�neVermittlung
			*/
			//hier muss dann das lookup kommen und ich brauche noch die methoden aus buttontest als interface
			
			
			button1.setButtonID("ton1");

			button1.registerObserver(Toene);
			button1.registerObserver(Lampe);

			button1.setClicked(true);
			button1.setButtonID("ton1");
			

			
			
			
			

			
			
			
			

	}
	

}
