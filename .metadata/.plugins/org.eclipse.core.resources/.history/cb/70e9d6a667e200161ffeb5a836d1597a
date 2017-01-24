package rmi.chef;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//ist eigentlich der Vermittler!!!

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.registry.RegistryHandler;

import rmi.interfaces.*;

public class ToeneTest implements MitarbeiterRemote {
	
	
	
	public static void main(String[] args)  {

		try{
	
		 MitarbeiterRemote c = (MitarbeiterRemote) Naming.lookup("rmi://localhost:1099/Mitarbeiter");
         c.play(2);


		}catch (Exception e) { 
			e.printStackTrace();
		}

}

	@Override
	public String play(int msg) throws RemoteException {
		// TODO Auto-generated method stub
		return "";
	}
	
		
	}

	
