package rmi.registry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Binder extends UnicastRemoteObject implements IBinder {

	private static final long serialVersionUID = 1L;

	private Map<String, Remote> services = new ConcurrentHashMap<>();

	protected Binder() throws RemoteException {
		super();
	}

	@Override
	public void bind(String name, Remote object) throws RemoteException {
		System.out.println("binding: name=" + name + ", object=" + object);
		this.services.put(name, object);
	}

	@Override
	public String[] list() throws RemoteException {
		Set<String> result = this.services.keySet();
		return result.toArray(new String[result.size()]);
	}

	@Override
	public Remote lookup(String name) throws RemoteException {
		return this.services.get(name);
	}

}
