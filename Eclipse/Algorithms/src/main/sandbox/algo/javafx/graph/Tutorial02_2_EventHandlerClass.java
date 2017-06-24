package algo.javafx.graph;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Tutorial02_2_EventHandlerClass implements EventHandler<ActionEvent> {

	public void handle(ActionEvent event) {

		System.out.println("You clicked me :-)");
	}
}