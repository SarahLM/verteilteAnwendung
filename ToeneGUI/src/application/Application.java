package src.application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Application extends javafx.application.Application{
	
	RmiService service;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/ChefAnsicht.fxml"));
			Parent root = (Parent) loader.load();
			MainScreenController msc = (MainScreenController) loader.getController();
			Scene scene = new Scene(root);
			RmiService service = new RmiService(msc);
			service.start();
			primaryStage.setScene(scene);
			primaryStage.centerOnScreen();
			primaryStage.setTitle("T�neApp");
			service.setText(1, "Meeting");
			service.setText(2, "Dinner");
			service.setText(3, "After Work");
			service.setBodyText("Bis Boss ruft zum");
			service.setPictures(1, true);
			service.setPictures(2, true);
			service.setPictures(3, true);
			service.setPictures(4, true);
			service.setPictures(5, true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
