package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import rmi.interfaces.*;

import java.awt.Image;
import java.io.Serializable;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ResourceBundle;

import org.omg.CORBA.INITIALIZE;

public class MainScreenController implements Initializable, MainScreenInterface {

	
	@FXML
	private Button button1;

	@FXML
	private Button button2;

	@FXML
	private Button button3;

	@FXML
	private Text bodytext;
	
	@FXML
	private ImageView image1;
	
	@FXML
	private ImageView image2;
	
	@FXML
	private ImageView image3;
	
	@FXML
	private ImageView image4;
	
	@FXML
	private ImageView image5;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}


	@FXML
	protected void actButton( ActionEvent event ) {

		// Was soll in Zukunft passieren
		// Vorher per rmi festgelegte Remote Methoden sollen hier ausgef�hrt werden
		

	}

	@Override
	public void setText(int buttonIndex, String text) throws RemoteException {

		switch(buttonIndex) {

		case 1:
			button1.setText(text);
			break;

		case 2:
			button2.setText(text);				
			break;

		case 3:
			button3.setText(text);
			break;

		}

	}


	@Override
	public void setBodyText(String text) throws RemoteException{
		bodytext.setText(text);
	}


	@Override
	public void setPictures(int pictureIndex, boolean visible) throws RemoteException {
		
		switch(pictureIndex) {

		case 1:
			image1.setVisible(visible);
			break;

		case 2:			
			image2.setVisible(visible);
			break;

		case 3:
			image3.setVisible(visible);
			break;
			
		case 4:
			image4.setVisible(visible);
			break;
			
		case 5:
			image5.setVisible(visible);
			break;

		}
		
		
	}






}