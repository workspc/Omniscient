package algo.javafx.graph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
public class Tutorial04_SwitchingScenes extends Application {

	private Scene scene1, scene2;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Label label1 = new Label("Scene 1");
		Button button1 = new Button(STYLESHEET_CASPIAN);
		button1.setOnAction(action -> primaryStage.setScene(scene2));

		VBox box = new VBox(20);
		box.getChildren().addAll(label1, button1);

		scene1 = new Scene(box, 200, 200);

		Label label2 = new Label("Scene 2");
		Button button2 = new Button(STYLESHEET_MODENA);
		button2.setOnAction(action -> primaryStage.setScene(scene1));

		StackPane pane = new StackPane();
		pane.getChildren().add(label2);
		pane.getChildren().add(button2);

		scene2 = new Scene(pane, 200, 200);

		primaryStage.setTitle("Switching Scenes");
		primaryStage.setScene(scene1);
		primaryStage.show();

	}
}