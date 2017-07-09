package graphics.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPanel;

public class TestPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public TestPanel() {
		setPreferredSize(new Dimension(400, 400));
		setBackground(Color.BLUE);
		setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;

		RoundRectangle2D rect = new RoundRectangle2D.Double();
		rect.setRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 20, 20);

		g2.setPaint(getBackground());
		g2.fill(rect);
		

		Line2D.Double line = new Line2D.Double(5, 5, getWidth() - 10, getHeight() - 10);
		g2.setColor(Color.RED);
		g2.draw(line);
	}
}