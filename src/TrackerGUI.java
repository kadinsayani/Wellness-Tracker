import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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
		Scene scene = new Scene(root, 400, 500);

		userRegistration(root);

		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

		primaryStage.setScene(scene);
		primaryStage.setTitle("Wellness Tracker");
		primaryStage.show();
	}

	public void userRegistration(VBox root) {
		Label myLabel = new Label("Please enter your information below: ");
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
			System.out.println("User object created: " + user.toString());
			root.getChildren().remove(myButton);
			root.getChildren().removeAll(myLabel, hb1, hb2, hb3, hb4, hb5, myButton);

			recordMetrics(root, user);
		});
		root.getChildren().add(myButton);
	}

	public void recordMetrics(VBox root, User user) {
		Metric steps = new Metric("steps");
		Metric water = new Metric("water");
		Metric sleep = new Metric("sleep");
		Metric exercise = new Metric("exercise");
		Metric calories = new Metric("calories");

		VBox summary = new VBox();

		HBox stepBox = new HBox();
		Label stepCount = new Label("Step count: " + String.valueOf(steps.getMetricCount()));
		TextField stepEntry = new TextField();
		stepBox.getChildren().addAll(stepCount, stepEntry);
		stepBox.setSpacing(10);
		stepBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		summary.getChildren().add(stepBox);

		HBox waterBox = new HBox();
		Label waterCount = new Label("Water intake: " + String.valueOf(water.getMetricCount()));
		TextField waterEntry = new TextField();
		waterBox.getChildren().addAll(waterCount, waterEntry);
		waterBox.setSpacing(10);
		waterBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		summary.getChildren().add(waterBox);

		HBox sleepBox = new HBox();
		Label sleepCount = new Label("Sleep time: " + String.valueOf(sleep.getMetricCount()));
		TextField sleepEntry = new TextField();
		sleepBox.getChildren().addAll(sleepCount, sleepEntry);
		sleepBox.setSpacing(10);
		sleepBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		summary.getChildren().add(sleepBox);

		HBox exerciseBox = new HBox();
		Label exerciseCount = new Label("Exercise minutes: " + String.valueOf(exercise.getMetricCount()));
		TextField exerciseEntry = new TextField();
		exerciseBox.getChildren().addAll(exerciseCount, exerciseEntry);
		exerciseBox.setSpacing(10);
		exerciseBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		summary.getChildren().add(exerciseBox);

		HBox calorieBox = new HBox();
		Label calorieCount = new Label("Calorie count: " + String.valueOf(calories.getMetricCount()));
		TextField calorieEntry = new TextField();
		calorieBox.getChildren().addAll(calorieCount, calorieEntry);
		calorieBox.setSpacing(10);
		calorieBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		summary.getChildren().add(calorieBox);

		root.getChildren().add(summary);
		Button myButton = new Button("Add");
		Tooltip t = new Tooltip("Click to submit entries. You can submit as many as you want at a time.");
		Tooltip.install(myButton, t);
		myButton.setOnAction((event) -> {
			if (!(stepEntry.getText().isEmpty())) {
				steps.recordMetric(Integer.parseInt(stepEntry.getText()));
				stepCount.setText("Step count: " + String.valueOf(steps.getMetricCount()));
				stepEntry.clear();
			}
			if (!(waterEntry.getText().isEmpty())) {
				water.recordMetric(Integer.parseInt(waterEntry.getText()));
				waterCount.setText("Water Intake: " + String.valueOf(water.getMetricCount()));
				waterEntry.clear();
			}
			if (!(sleepEntry.getText().isEmpty())) {
				sleep.recordMetric(Integer.parseInt(sleepEntry.getText()));
				sleepCount.setText("Sleep Time: " + String.valueOf(sleep.getMetricCount()));
				sleepEntry.clear();
			}
			if (!(exerciseEntry.getText().isEmpty())) {
				exercise.recordMetric(Integer.parseInt(exerciseEntry.getText()));
				exerciseCount.setText("Exercise Minutes: " + String.valueOf(exercise.getMetricCount()));
				exerciseEntry.clear();
			}
		});

		root.getChildren().add(myButton);

	}

}
