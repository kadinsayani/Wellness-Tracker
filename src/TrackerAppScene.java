import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrackerAppScene extends Application {

	private User userCopy;

	public void start(Stage stage) {
		VBox root = new VBox();
		Label myLabel = new Label("Wellness Summary\n\n\n\n\n");
		root.getChildren().add(myLabel);

		Metric steps = new Metric("steps");
		Metric water = new Metric("water");
		Metric sleep = new Metric("sleep");
		Metric exercise = new Metric("exercise");
		Metric calories = new Metric("calories");
		
		VBox summary = new VBox();
		
		HBox stepBox = new HBox();
		Label stepLabel = new Label("Step count: " + steps.getMetricCount());
		stepBox.getChildren().add(stepLabel);
		Label stepGoalPercent = new Label(String.valueOf(((steps.getMetricCount() / userCopy.getStepGoal())) * 100) + "% of calorie goal");
		stepBox.getChildren().add(stepGoalPercent);
		TextField stepEntry = new TextField();
		stepBox.getChildren().add(stepEntry);
		summary.getChildren().add(stepBox);
		
		HBox waterBox = new HBox();
		Label waterLabel = new Label("Water intake: " +  water.getMetricCount() + " fluid ounces");
		waterBox.getChildren().add(waterLabel);
		Label waterGoalPercent = new Label(String.valueOf(((water.getMetricCount() / water.calculateRequiredWaterIntake(userCopy))) * 100) + "% of calorie goal");
		waterBox.getChildren().add(waterGoalPercent);
		TextField waterEntry = new TextField();
		waterBox.getChildren().add(waterEntry);
		summary.getChildren().add(waterBox);
		
		HBox sleepBox = new HBox();
		Label sleepLabel = new Label("Sleep time: " + sleep.getMetricCount() + " hours");
		sleepBox.getChildren().add(sleepLabel);
		Label sleepGoalPercent = new Label(String.valueOf(((sleep.getMetricCount() / 8)) * 100) + "% of calorie goal");
		sleepBox.getChildren().add(sleepGoalPercent);
		TextField sleepEntry = new TextField();
		sleepBox.getChildren().add(sleepEntry);
		summary.getChildren().add(sleepBox);
		
		HBox exerciseBox = new HBox();
		Label exerciseLabel = new Label("Exercise time: " + exercise.getMetricCount() + " minutes");
		exerciseBox.getChildren().add(exerciseLabel);
		Label exerciseGoalPercent = new Label(String.valueOf(((exercise.getCalorieCount() / 60)) * 100) + "% of calorie goal");
		exerciseBox.getChildren().add(exerciseGoalPercent);
		TextField exerciseEntry = new TextField();
		exerciseBox.getChildren().add(exerciseEntry);
		summary.getChildren().add(exerciseBox);
		
		HBox calorieBox = new HBox();
		Label calorieLabel = new Label("Calories: " + calories.getCalorieCount() + " calories");
		calorieBox.getChildren().add(calorieLabel);
		Label calorieGoalPercent = new Label(String.valueOf(((calories.getCalorieCount() / userCopy.getCalorieGoal())) * 100) + "% of calorie goal");
		calorieBox.getChildren().add(calorieGoalPercent);
		TextField calorieEntry = new TextField();
		calorieBox.getChildren().add(calorieEntry);
		summary.getChildren().add(calorieBox);
		
		root.getChildren().add(summary);
		
		Scene scene = new Scene(root, 500, 500);
		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}

	public void getUser(User user) {

		userCopy = user;

	}

}