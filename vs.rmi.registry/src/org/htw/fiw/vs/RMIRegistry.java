package org.htw.fiw.vs;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIRegistry {

	public static void main(String[] args) throws AlreadyBoundException, IOException {
		System.setProperty("java.rmi.server.hostname", "141.45.207.220");
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("binder", new Binder());
		System.out.println("rmi registry running... (press any key to quit)");
		System.in.read();
		System.exit(0);
	}
}