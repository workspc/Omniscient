package algo.javafx.graph;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Tutorial06_02_ConfirmBox {

	private Stage confirmBoxWindow;
	private static boolean confirm;

	public boolean confirm(String title, String message) {

		confirmBoxWindow = new Stage();
		confirmBoxWindow.setTitle(title);
		confirmBoxWindow.initModality(Modality.APPLICATION_MODAL);
		confirmBoxWindow.setMinWidth(200);
		confirmBoxWindow.setMinHeight(100);

		Label label = new Label();
		label.setText(message);

		Button yes = new Button();
		yes.setText("Yes");
		yes.setOnAction(action -> {
			confirm = true;
			confirmBoxWindow.close();
		});

		Button no = new Button();
		no.setText("No");
		no.setOnAction(action -> {
			confirm = false;
			confirmBoxWindow.close();
		});

		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(label, yes, no);

		Scene scene = new Scene(layout, 199, 99);

		confirmBoxWindow.setScene(scene);
		confirmBoxWindow.showAndWait();

		return confirm;
	}
}