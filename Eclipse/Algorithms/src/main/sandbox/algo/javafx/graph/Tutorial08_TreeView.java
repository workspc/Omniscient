package algo.javafx.graph;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class Tutorial08_TreeView extends Application {

	private String title = "FX Application";
	private String buttonText = "Click";
	private int width = 400;
	private int height = 200;
	private Button button;
	private StackPane layout;
	private Scene scene;
	private TreeView<String> tree;
	private final Node rootIcon = new ImageView(new Image(getClass().getResourceAsStream("Play-16X16.gif")));

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(title);
		button = new Button();
		button.setText(buttonText);

		// Work area
		TreeItem<String> movies, comedy, action;

		movies = new TreeItem<>("Movies", rootIcon);
		movies.setExpanded(false);

		// Comedy genre movies
		comedy = new TreeItem<>();
		comedy = makeBranch("Comedy", movies);
		makeBranch("Dumb Dumber & Dumbest", comedy);
		makeBranch("Mask", comedy);
		makeBranch("Shangai Knights", comedy);

		// Action genre movies
		action = new TreeItem<>();
		action = makeBranch("Action", movies);
		makeBranch("Transformer", action);
		makeBranch("Batman", action);
		makeBranch("Mission Impossible", action);

		tree = new TreeView<>(movies);
		tree.setShowRoot(true);

		layout = new StackPane();
		layout.getChildren().addAll(tree, button);
		scene = new Scene(layout, width, height);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(title);
		parent.getChildren().add(item);
		return item;
	}
}