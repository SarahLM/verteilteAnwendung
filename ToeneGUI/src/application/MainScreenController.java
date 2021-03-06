package src.application;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.htw.fiw.vs.team2.Buttons.Observer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MainScreenController implements Initializable {
	
	private ArrayList<Observer> observers;
	
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
		observers = new ArrayList<>();
	}

	@FXML
	protected void actButton( ActionEvent event ) throws RemoteException, NotBoundException {
		
		Button btn = (Button) event.getSource();
		int buttonID = Integer.parseInt(btn.getId().substring(6));
		for ( Observer observer : observers ) {
			observer.update(buttonID);
		}
		
	}

	public void setText(int buttonIndex, String text) throws RemoteException {
		
		Platform.runLater(new Runnable() {
            @Override public void run() {

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
        });

	}

	public void setBodyText(String text) throws RemoteException{
		Platform.runLater(new Runnable() {
            @Override public void run() {
            	bodytext.setText(text);
            }
        });
	}

	public void setPictures(int pictureIndex, boolean visible) throws RemoteException {
		
		Platform.runLater(new Runnable() {
            @Override public void run() {
            	
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
        });

	}

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		this.observers.remove(observer);		
	}

}
