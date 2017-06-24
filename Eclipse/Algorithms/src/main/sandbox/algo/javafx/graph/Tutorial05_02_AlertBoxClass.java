package algo.javafx.graph;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tutorial05_02_AlertBoxClass {

	Stage alertBoxWindow;

	public void show(String title) {

		alertBoxWindow = new Stage();
		alertBoxWindow.setTitle(title);
		alertBoxWindow.initModality(Modality.APPLICATION_MODAL);
		alertBoxWindow.setMinWidth(200);
		alertBoxWindow.setMinHeight(100);

		Label label = new Label();
		label.setText("Hi, i am a new window");

		Button closeButton = new Button();
		closeButton.setText("Close Window");
		closeButton.setOnAction(action -> alertBoxWindow.close());

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(label);
		layout.getChildren().add(closeButton);

		Scene scene = new Scene(layout, 199, 99);

		alertBoxWindow.setScene(scene);
		alertBoxWindow.showAndWait();
	}
}