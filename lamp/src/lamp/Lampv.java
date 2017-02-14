package lamp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.htw.fiw.vs.IBinder;

public class Lampv extends java.rmi.server.UnicastRemoteObject implements ActionListener, org.htw.fiw.vs.team1.LampInterface  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean status = false;
	LampUI lUi;
	IBinder registry;
	String name;
	
	public Lampv() throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException, NotBoundException {
		super();
		lUi= new LampUI();

	}
		public void start() {
			
		boolean notBound = true;
		while (notBound) {
			try {
					int token = (int) ((Math.random()*99999)+1);
       
					Registry connectRegistry = LocateRegistry.getRegistry("192.168.178.23", 1099);
					IBinder registry = (IBinder) connectRegistry.lookup("binder");
		
		//this.registry = (IBinder) Naming.lookup("rmi://localhost/binder");
		//this.name = "LAM_" + String.format("%05d", token);
			registry.bind("LAM_" + String.format("%05d", token), this);

		//this.name = "lamp" +"-"+InetAddress.getLocalHost().getHostName()+"-"+ System.currentTimeMillis();
		this.registry.bind(name, this);
		notBound = false;
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	@Override
	public void changeStatus() throws RemoteException {
		if (status) {
			lUi.changeColor(status);
			status = false;
			
		}
		else {		
			lUi.changeColor(status);
			status = true;
		}
		System.out.println("Lamp is on: " + status);
	}
	
	@Override
	public void turnOff() throws RemoteException {
		//true because there is a bug in UI, sorry af
		this.status = true;
		lUi.changeColor(this.status);
		System.out.println("Lamp turned off");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	
	public static void main(String[] args) throws RemoteException, AlreadyBoundException, UnknownHostException, MalformedURLException, NotBoundException {
		Lampv l = new Lampv();
		l.start();
		
		/*Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				try {
					l.registry.unbind(l.name);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		});*/
	}
}
