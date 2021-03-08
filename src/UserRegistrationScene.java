import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author kadinsayani
 *
 */
public class UserRegistrationScene extends Application {
	
	private User user;

	public void start(Stage stage) {

		// Create VBox and Scene
		VBox root = new VBox();
		Scene scene = new Scene(root, 500, 500);
		
		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

		Label myLabel = new Label(
				"Please enter your information below: ");
		myLabel.setWrapText(true);
		root.getChildren().add(myLabel);

		// HBox elements for text fields

		Label label1 = new Label("Name:");
		TextField nameField = new TextField();
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(label1, nameField);
		hb1.setSpacing(10);
		root.getChildren().add(hb1);

		Label label2 = new Label("Age: ");
		TextField ageField = new TextField();
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(label2, ageField);
		hb2.setSpacing(10);
		root.getChildren().add(hb2);

		Label label3 = new Label("Weight: ");
		TextField weightField = new TextField();
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(label3, weightField);
		hb3.setSpacing(10);
		root.getChildren().add(hb3);

		Label label4 = new Label("Step Goal: ");
		TextField stepGoalField = new TextField();
		HBox hb4 = new HBox();
		hb4.getChildren().addAll(label4, stepGoalField);
		hb4.setSpacing(10);
		root.getChildren().add(hb4);

		Label label5 = new Label("CalorieGoal: ");
		TextField calorieGoalField = new TextField();
		HBox hb5 = new HBox();
		hb5.getChildren().addAll(label5, calorieGoalField);
		hb5.setSpacing(10);
		root.getChildren().add(hb5);

		// Button and button handler to create new user object
		Button myButton = new Button("Submit");
		myButton.setOnAction((event) -> {
			user = new User(nameField.getText(), Integer.parseInt(ageField.getText()),
					Integer.parseInt(weightField.getText()), Integer.parseInt(stepGoalField.getText()),
					Integer.parseInt(calorieGoalField.getText()));
			
			// Switch to next scene
			TrackerAppScene t = new TrackerAppScene();
			t.getUser(user);
			t.start(stage);
		});
		root.getChildren().add(myButton);

		stage.setScene(scene);
	}

}
