package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application{
	
	MainScreenController msc;

	public static void main(String[] args) {
		launch(args);
	}
	
	// Alternative, falls keine direkte rmi Freigabe im Controller möglich ist
	public void setText(int buttonIndex, String text){
		try {
			msc.setText(buttonIndex, text);
		} catch (Exception e) {
			
		}
	}
	
	public void setBodyText(String text) {
		// Falls RMI im Controller nicht geht hier rein!	
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/ChefAnsicht.fxml"));
			Parent root = (Parent) loader.load();
			msc = (MainScreenController) loader.getController();
			Scene scene = new Scene(root);
			RmiService service = new RmiService(msc);
			service.start();

			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			
			primaryStage.setTitle("TöneApp");
			msc.setText(1, "Meeting");
			msc.setText(2, "Dinner");
			msc.setText(3, "After Work");
			msc.setBodyText("Bis Boss ruft zum");
			msc.setPictures(1, true);
			msc.setPictures(2, true);
			msc.setPictures(3, true);
			msc.setPictures(4, true);
			msc.setPictures(5, true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
