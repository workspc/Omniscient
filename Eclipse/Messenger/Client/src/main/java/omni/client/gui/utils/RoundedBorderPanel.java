package omni.client.gui.utils;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RoundedBorderPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// Stroke size, it is recommended to set it to 1 for better view.
	protected int strokeSize = 1;
	// Sets it to true for high quality view.
	protected boolean highQuality = true;
	// Double value for horizontal and vertical arcs.
	protected Dimension arcs = new Dimension(20, 20);

	public RoundedBorderPanel() {
		super();
		setOpaque(false);
	}

	public RoundedBorderPanel(Dimension curve) {
		this();
		this.arcs = curve;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics = (Graphics2D) g;

		// Sets anti aliasing if HQ.
		if (highQuality) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}

		graphics.drawRoundRect(0, 0, getWidth(), getHeight(), arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(strokeSize));

		// Sets strokes to default, is better.
		graphics.setStroke(new BasicStroke());
	}
}