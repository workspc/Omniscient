package algo.javafx.graph;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Tutorial07_ClosingWindowProperly extends Application {

	private String title = "FX Application";
	private String buttonText = "Close";
	private int width = 400;
	private int height = 200;
	private Button button;
	private StackPane layout;
	private Scene scene;
	private Tutorial06_02_ConfirmBox confirm;
	private Stage windows;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		windows = primaryStage;
		windows.setTitle(title);

		windows.setOnCloseRequest(closeAction -> {
			closeAction.consume();
			closeOperation();
		});

		button = new Button();
		button.setText(buttonText);
		button.setOnAction(closeAction -> closeOperation());

		layout = new StackPane();
		layout.getChildren().add(button);

		scene = new Scene(layout, width, height);

		windows.setScene(scene);
		windows.show();
	}

	private void closeOperation() {
		confirm = new Tutorial06_02_ConfirmBox();

		if (confirm.confirm("Exit", "Are you sure?"))
			windows.close();
	}
}
