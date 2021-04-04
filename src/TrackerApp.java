import javafx.application.Application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author kadinsayani
 *
 */
public class TrackerApp extends Application {

	HBox summarizeSteps;
	HBox summarizeWater;
	HBox summarizeSleep;
	HBox summarizeExercise;
	HBox summarizeCalories;

	// Change this to false to use the text based interface
	static boolean useGraphicalInterface = true;

	// main method
	public static void main(String[] args) {
		if (useGraphicalInterface == true) {
			launch(args);
		} else {
			TextInterface t = new TextInterface();
			t.menu();
		}
	}

	/**
	 * start method
	 */
	public void start(Stage primaryStage) {

		// Create VBox and Scene
		VBox root = new VBox();
		Scene scene = new Scene(root, 400, 500);

		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());

		userRegistration(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Wellness Tracker");
		primaryStage.show();
	}

	/**
	 * userRegistration method for getting info on user and creating user object
	 * 
	 * @param root
	 */
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

			// now that user object is created we can remove the user reg text fields and
			// call recordMetrics
			recordMetrics(root, user);
		});
		root.getChildren().add(myButton);
	}

	/**
	 * recordMetrics generates text fields and button handlers for users to record
	 * metrics
	 * 
	 * @param root
	 * @param user
	 */
	public void recordMetrics(VBox root, User user) {
		// create metric objects for 5 metrics
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

		HBox waterBox = new HBox();
		Label waterCount = new Label("Water intake (fluid ounces): " + String.valueOf(water.getMetricCount()));
		TextField waterEntry = new TextField();
		waterBox.getChildren().addAll(waterCount, waterEntry);
		waterBox.setSpacing(10);
		waterBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));

		HBox sleepBox = new HBox();
		Label sleepCount = new Label("Sleep time (hours): " + String.valueOf(sleep.getMetricCount()));
		TextField sleepEntry = new TextField();
		sleepBox.getChildren().addAll(sleepCount, sleepEntry);
		sleepBox.setSpacing(10);
		sleepBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));

		HBox exerciseBox = new HBox();
		Label exerciseCount = new Label("Exercise minutes: " + String.valueOf(exercise.getMetricCount()));
		TextField exerciseEntry = new TextField();
		exerciseBox.getChildren().addAll(exerciseCount, exerciseEntry);
		exerciseBox.setSpacing(10);
		exerciseBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));

		HBox calorieBox = new HBox();
		Label calorieCount = new Label("Calorie count: " + String.valueOf(calories.getMetricCount()));
		TextField calorieEntry = new TextField();
		calorieBox.getChildren().addAll(calorieCount, calorieEntry);
		calorieBox.setSpacing(10);
		calorieBox.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		Button questionMark = new Button("?");
		questionMark.setOnAction((event) -> {
			Alert alert = new Alert(AlertType.INFORMATION,
					"Please enter the food you ate. For example, type one glass of milk, or two apples.");
			alert.showAndWait();
		});
		calorieBox.getChildren().add(questionMark);

		summary.getChildren().addAll(stepBox, waterBox, sleepBox, exerciseBox, calorieBox);

		root.getChildren().add(summary);

		Button addButton = new Button("Add");
		Tooltip tAddButton = new Tooltip("Click to submit entries. You can submit as many as you want at a time.");
		Tooltip.install(addButton, tAddButton);
		addButton.setOnAction((event) -> {
			// button handler checks if user has inputted to text fields and if so adds user
			// metric recordings to metricCount in metric object
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
			if (!(calorieEntry.getText().isEmpty())) {
				FoodAPI f = new FoodAPI();
				calories.addToCalorieCount(f.requestCalories(calorieEntry.getText()));
				calorieCount.setText("Calories: " + String.valueOf(calories.getCalorieCount()));
				calorieEntry.clear();
			}

			summarizeMetrics(root, steps, water, sleep, exercise, calories, user);

		});

		Button reportButton = new Button("Generate Report");
		Tooltip tReportButton = new Tooltip(
				"Click to generate a report on today's wellness metrics. The report will be located in home/Wellness Tracker Reports/.");
		Tooltip.install(reportButton, tReportButton);
		reportButton.setOnAction((event) -> {
			LocalDateTime now = LocalDateTime.now();
			System.out.println("Wellness report generated " + now);

			// Create directory in home folder if not exists
			File directory = new File(File.listRoots()[0],
					"Users" + System.getProperty("file.separator") + System.getProperty("user.name")
							+ System.getProperty("file.separator") + "Wellness Tracker Reports");
			if (!directory.exists()) {
				directory.mkdir();
			}

			// Create report txt file in Wellness Tracker Reports directory
			String fileName = "Wellness Report " + now + ".txt";
			File file = new File(directory + "/" + fileName);
			try {
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Wellness Report generated " + now + "\n");
				bw.write("User: " + user.getName() + "\n");
				bw.write("Steps: " + steps.getMetricCount() + " steps\n");
				bw.write("Water: " + water.getMetricCount() + " fluid ounces\n");
				bw.write("Sleep: " + sleep.getMetricCount() + " hours\n");
				bw.write("Exercise: " + exercise.getMetricCount() + " minutes\n");
				bw.write("Calories: " + calories.getCalorieCount() + " calories\n");
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		root.getChildren().add(addButton);
		root.getChildren().add(reportButton);

	}

	/**
	 * summarizeMetrics provides progress bars for summarizing metrics and how far a
	 * user is from their goals
	 * 
	 * @param root
	 * @param steps
	 * @param water
	 * @param sleep
	 * @param exercise
	 * @param calories
	 * @param user
	 */
	public void summarizeMetrics(VBox root, Metric steps, Metric water, Metric sleep, Metric exercise, Metric calories,
			User user) {

		root.getChildren().removeAll(summarizeSteps, summarizeWater, summarizeSleep, summarizeExercise,
				summarizeCalories);

		summarizeSteps = new HBox();
		Label s1 = new Label("% of step goal reached");
		ProgressBar stepProgress = new ProgressBar(0);
		stepProgress.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		stepProgress.setProgress(steps.getMetricCount() / user.getStepGoal());
		Label s2 = new Label(Math.round((steps.getMetricCount() / user.getStepGoal()) * 100) + "%");
		summarizeSteps.getChildren().addAll(s1, stepProgress, s2);

		summarizeWater = new HBox();
		Label w1 = new Label("% of water intake goal reached");
		ProgressBar waterProgress = new ProgressBar(0);
		waterProgress.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		waterProgress.setProgress(water.getMetricCount() / water.calculateRequiredWaterIntake(user));
		Label w2 = new Label(
				Math.round((water.getMetricCount() / water.calculateRequiredWaterIntake(user)) * 100) + "%");
		summarizeWater.getChildren().addAll(w1, waterProgress, w2);

		summarizeSleep = new HBox();
		Label sl1 = new Label("% of sleep goal reached");
		ProgressBar sleepProgress = new ProgressBar(0);
		sleepProgress.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		sleepProgress.setProgress(sleep.getMetricCount() / sleep.calculateRecommendedSleep(user.getAge()));
		Label sl2 = new Label(
				Math.round((sleep.getMetricCount() / sleep.calculateRecommendedSleep(user.getAge())) * 100) + "%");
		summarizeSleep.getChildren().addAll(sl1, sleepProgress, sl2);

		summarizeExercise = new HBox();
		Label e1 = new Label("% of exercise minutes goal reached");
		ProgressBar exerciseProgress = new ProgressBar(0);
		exerciseProgress.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		exerciseProgress.setProgress(exercise.getMetricCount() / 60.0);
		Label e2 = new Label(Math.round((exercise.getMetricCount() / 60.0) * 100) + "%");
		summarizeExercise.getChildren().addAll(e1, exerciseProgress, e2);

		summarizeCalories = new HBox();
		Label c1 = new Label("% of calorie goal reached");
		ProgressBar calorieProgress = new ProgressBar(0);
		calorieProgress.setPadding(new Insets(5.0, 5.0, 5.0, 5.0));
		calorieProgress.setProgress(calories.getCalorieCount() / user.getCalorieGoal());
		Label c2 = new Label(Math.round((calories.getCalorieCount() / user.getCalorieGoal()) * 100) + "%");
		summarizeCalories.getChildren().addAll(c1, calorieProgress, c2);

		root.getChildren().addAll(summarizeSteps, summarizeWater, summarizeSleep, summarizeExercise, summarizeCalories);

	}

}
