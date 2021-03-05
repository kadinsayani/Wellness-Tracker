import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrackerAppWindow extends Application {

	public void start(Stage stage) {
		VBox root = new VBox();
		Label myLabel = new Label(
				"Welcome to Wellness Tracker! Wellness Tracker records steps, water intake, time spent sleeping, and also does food tracking! Please enter your information below: ");
		myLabel.setWrapText(true);
		root.getChildren().add(myLabel);

		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.show();

	}
}