package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import rmi.interfaces.VermittlerRemote;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class ButtonController {

  @FXML
  protected void callEmployees( ActionEvent event ) {
	  
	  Button buttonPressed = (Button) event.getSource();
	  
	  try {
		VermittlerRemote serverRemote = (VermittlerRemote) Naming.lookup("rmi://localhost/ToeneService");
		serverRemote.play(Integer.parseInt(buttonPressed.getId()));
	  } catch (Exception e) {
		System.out.println("RMI-interaces-client exception: " + e);
	  }
  }
  
}
