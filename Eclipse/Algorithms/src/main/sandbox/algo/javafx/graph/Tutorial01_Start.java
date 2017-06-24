package algo.javafx.graph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * <b>Tutorial:</b>
 * <ul>
 * <li>To handle the event we implement {@link EventHandler} with the generic
 * type as some event.
 * <li>For mouse there are {@link MouseEvent}
 * <li>For touch screen {@link TouchEvent}
 * <li>For button we use {@link ActionEvent}
 * </ul>
 * <p>
 * <b>Learning:</b>
 * <ul>
 * <li>
 * </ul>
 * 
 * @author Gagandeep Singh
 *
 */
public class Tutorial01_Start extends Application {

	private String title = "FX Application";
	private String buttonText = "Click";
	private int width = 400;
	private int height = 200;
	private Button button;
	private StackPane layout;
	private Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(title);
		button = new Button();
		button.setText(buttonText);

		layout = new StackPane();
		layout.getChildren().add(button);

		scene = new Scene(layout, width, height);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}