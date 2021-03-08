import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LaunchScreen extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		Label myLabel = new Label(
				"Welcome to Wellness Tracker! Wellness Tracker records steps, water intake, time spent sleeping, and also does food tracking!");
		myLabel.setWrapText(true);
		root.getChildren().add(myLabel);
		
		// progress bar (5 seconds), then button appears - TODO
		 
		// Button handler for start button
		Button myButton = new Button("Start");
		myButton.setOnAction((event) -> {
			// Switch to next scene
			UserRegistrationScene u = new UserRegistrationScene();
			u.start(primaryStage);
		});
		root.getChildren().add(myButton);

		// Scene window
		Scene scene = new Scene(root, 500, 500);
		
		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		primaryStage.setTitle("Wellness Tracker");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}