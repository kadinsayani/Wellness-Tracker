import javafx.application.Application;
import javafx.geometry.Insets;
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
public class TrackerGUI extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {

		// Create VBox and Scene
		VBox root = new VBox();
		Scene scene = new Scene(root, 350, 500);
		
		userRegistration(root);
		
		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Wellness Tracker");
		primaryStage.show();
	}
	
	public void userRegistration(VBox root)	{
		Label myLabel = new Label(
				"Please enter your information below: ");
		myLabel.setWrapText(true);
		myLabel.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		root.getChildren().add(myLabel);

		// HBox elements for text fields

		Label label1 = new Label("Name:");
		TextField nameField = new TextField();
		HBox hb1 = new HBox();
		hb1.getChildren().addAll(label1, nameField);
		hb1.setSpacing(10);
		hb1.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		root.getChildren().add(hb1);

		Label label2 = new Label("Age: ");
		TextField ageField = new TextField();
		HBox hb2 = new HBox();
		hb2.getChildren().addAll(label2, ageField);
		hb2.setSpacing(10);
		hb2.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		root.getChildren().add(hb2);

		Label label3 = new Label("Weight: ");
		TextField weightField = new TextField();
		HBox hb3 = new HBox();
		hb3.getChildren().addAll(label3, weightField);
		hb3.setSpacing(10);
		hb3.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		root.getChildren().add(hb3);

		Label label4 = new Label("Step Goal: ");
		TextField stepGoalField = new TextField();
		HBox hb4 = new HBox();
		hb4.getChildren().addAll(label4, stepGoalField);
		hb4.setSpacing(10);
		hb4.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		root.getChildren().add(hb4);

		Label label5 = new Label("CalorieGoal: ");
		TextField calorieGoalField = new TextField();
		HBox hb5 = new HBox();
		hb5.getChildren().addAll(label5, calorieGoalField);
		hb5.setSpacing(10);
		hb5.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		root.getChildren().add(hb5);

		// Button and button handler to create new user object
		Button myButton = new Button("Submit");
		myButton.setOnAction((event) -> {
			User user = new User(nameField.getText(), Integer.parseInt(ageField.getText()),
					Integer.parseInt(weightField.getText()), Integer.parseInt(stepGoalField.getText()),
					Integer.parseInt(calorieGoalField.getText()));
			System.out.println(user.toString());
			root.getChildren().remove(myButton);
			root.getChildren().removeAll(myLabel, hb1, hb2, hb3, hb4, hb5, myButton);
			
			summarizeWellnessMetrics(root, user);
		});
		root.getChildren().add(myButton);
	}
	
	public void summarizeWellnessMetrics(VBox root, User user) {
		Metric steps = new Metric("steps");
		Metric water = new Metric("water");
		Metric sleep = new Metric("sleep");
		Metric exercise = new Metric("exercise");
		Metric calories = new Metric("calories");
		
		VBox summary = new VBox();
		Label stepCount = new Label("Step count: " + String.valueOf(steps.getMetricCount()));
		summary.getChildren().add(stepCount);
		Label waterCount = new Label("Water intake: " + String.valueOf(water.getMetricCount()));
		summary.getChildren().add(waterCount);
		Label sleepCount = new Label("Sleep time: " + String.valueOf(sleep.getMetricCount()));
		summary.getChildren().add(sleepCount);
		Label exerciseCount = new Label("Exercise minutes: " + String.valueOf(exercise.getMetricCount()));
		summary.getChildren().add(exerciseCount);
		Label calorieCount = new Label("Calorie count: " + String.valueOf(calories.getMetricCount()));
		summary.getChildren().add(calorieCount);
		
		root.getChildren().add(summary);
				
	}

}
