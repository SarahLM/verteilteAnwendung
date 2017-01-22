package rmi.mitarbeiter;
import java.rmi.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.interfaces.VermittlerRemote;
import rmi.interfaces.VermittlerRemoteImpl;
import rmi.interfaces.*;

public class testmitarbeiterzwei {

	public testmitarbeiterzwei(){
	try {
		VermittlerRemote c = new VermittlerRemoteImpl(); 

	Naming.rebind("rmi://localhost:1099/test2", c);
	
	System.out.println("angemeldet ");

	
	}
 catch (Exception e) {
	System.out.println("RMI-intefaces-Server failed: " + e);
}}


public static void main(String args[]) {
	
	new testmitarbeiterzwei();
	
}}