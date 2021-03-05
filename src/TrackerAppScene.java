import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TrackerAppScene extends Application {

	public void start(Stage stage) {
		VBox root = new VBox();
		Label myLabel = new Label(
				"Main menu");
		myLabel.setWrapText(true);
		root.getChildren().add(myLabel);

		Scene scene = new Scene(root, 500, 500);
		// Application styling
		scene.getStylesheets().add(getClass().getResource("stylesheet.css").toExternalForm());
		stage.setScene(scene);
		stage.show();

	}
}