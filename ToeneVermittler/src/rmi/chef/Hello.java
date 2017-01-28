package rmi.chef;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.htw.fiw.vs.IBinder;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import org.htw.fiw.vs.IBinder;



@Path("/hello")
public class Hello {

	private String[] services;
	private IBinder registry;
    
	
	@GET

	public String[] hello() {
		try{
			services = registry.list();
		} catch (Exception e) {
			System.out.println(e);
		}
		return services;
	}
	

	@GET
	@Path("/{user}")
	public String hello(@PathParam("user") String user) {
		return "hello " + user;
	}

	public Hello() throws RemoteException, NotBoundException {
		
		Registry connectRegistry = LocateRegistry.getRegistry("192.168.178.21", 1099);
		registry = (IBinder) connectRegistry.lookup("binder");
		
	}
	
}
