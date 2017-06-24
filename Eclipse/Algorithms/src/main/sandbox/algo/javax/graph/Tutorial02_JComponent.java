package algo.javax.graph;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.JComponent;

public class Tutorial02_JComponent extends JComponent {

	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics graphics) {

		Graphics2D graphics2D = (Graphics2D) graphics;
		Shape rectangle = new Rectangle(5, 5, 100, 100);
		graphics2D.draw(rectangle);
	}
}
