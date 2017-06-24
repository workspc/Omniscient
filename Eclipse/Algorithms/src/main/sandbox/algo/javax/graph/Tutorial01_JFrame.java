package algo.javax.graph;

import javax.swing.JFrame;

public class Tutorial01_JFrame {

	private static int width = 640;
	private static int height = 480;
	private static int operation = JFrame.EXIT_ON_CLOSE;

	public static void main(String[] args) {

		JFrame window = new JFrame("Tutorial 1");
		window.setSize(width, height);
		window.setDefaultCloseOperation(operation);
		window.setVisible(true);

		Tutorial02_JComponent rectangleDraw = new Tutorial02_JComponent();
		window.add(rectangleDraw);
	}
}
