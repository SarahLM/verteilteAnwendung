package rmi.mitarbeiter;

//ist der Mitarbeiter
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

import rmi.interfaces.*;

public class Mitarbeiter extends UnicastRemoteObject implements MitarbeiterRemote  {
	
	private static final long serialVersionUID = 1L;
	
	Sound sound;
	
	public Mitarbeiter() throws java.rmi.RemoteException{
		
		sound = new Sound();
	
	}
	  
	public static void main(String[] args) {

		try {
    
			String fromUser="";
			Mitarbeiter client = new Mitarbeiter();
    
			VermittlerRemote c = (VermittlerRemote) Naming.lookup("rmi://localhost/ToeneService");
			//ServerRemote c = (ServerRemote) Naming.lookup("rmi://192.168.178.21/ToeneService");
			System.out.println(c.sayHello("me"));
			c.addClient((MitarbeiterRemote)client);
	
			// Programm so lange auf�hren bis 'exit' �ber die Konsole eingegeben wird
			while (!fromUser.equals("exit")) {	
				BufferedReader user_br = new BufferedReader(new InputStreamReader(System.in));
				fromUser = user_br.readLine();
			}
	
			System.out.println("RMI-interaces-client already finished");
			
	
		} catch (Exception e) {
	
			System.out.println("RMI-interaces-client exception: " + e);
	
		}
	}

	public String play(int msg) {
	
		sound.run(msg);
		System.out.println("ClientRemote.play");	
		return "";
		
	}

}
