package graphics.core;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GraphicsTest {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 500));

		frame.getContentPane().add(new TestPanel(), BorderLayout.NORTH);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}