package algo.javafx.graph;

import javafx.application.Application;
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
public class Tutorial03_EventHandlingUsingLambdaExpression extends Application {

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
		button.setOnAction(e -> {
			System.out.println("Clicked by lambda");
			System.out.println("Nice..");
		});

		layout = new StackPane();
		layout.getChildren().add(button);

		scene = new Scene(layout, width, height);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
