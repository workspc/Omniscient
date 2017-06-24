package algo.javafx.graph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * <b>Tutorial:</b>
 * <ul>
 * <li>In Java-FX the entire window is called the {@link Stage}.
 * <li>Contents inside the window are called the {@link Scene}.
 * <ul>
 * <li>Inside {@link Scene} we will add the stuff like Binds, Widget.
 * </ul>
 * </ul>
 * <p>
 * <b>Learning:</b>
 * <ul>
 * <li>How to set application/window title.
 * <li>How to create a Java-FX button.
 * <li>In order for button to appear on the window you need to have a layout.
 * <li>You can set the layout in the scene itself.
 * </ul>
 * 
 * @author Gagandeep Singh
 *
 */
public class Tutorial02_1_EventHandling extends Application implements EventHandler<ActionEvent> {

	private String title = "FX Application";
	private String buttonText = "Click";
	private int width = 400;
	private int height = 200;
	private Button button;
	private Button buttonOut;
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
		button.setOnAction(this);

		buttonOut = new Button("Outer");
		buttonOut.setOnAction(new Tutorial02_2_EventHandlerClass());

		layout = new StackPane();
		layout.getChildren().add(0, button);
		layout.getChildren().add(1, buttonOut);

		scene = new Scene(layout, width, height);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void handle(ActionEvent event) {
		if (event.getSource() == button) {
			System.out.println("Cicked from inside :-)");
		}
	}
}
