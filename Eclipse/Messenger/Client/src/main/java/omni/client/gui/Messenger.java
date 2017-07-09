package omni.client.gui;

import static omni.commons.utils.Constants.LAF;
import static omni.commons.utils.Constants.TITLE;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

public class Messenger {

	private static Logger log = Logger.getLogger(Messenger.class);
	private static JFrame mainFrame;

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(LAF.toString());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException lafe) {
			log.error("Unable to load the look and feel" + lafe);
		}

		mainFrame = new JFrame(TITLE.toString());
		mainFrame.setPreferredSize(new Dimension(500, 500));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainFrame.getContentPane().add(new JPanel(), BorderLayout.NORTH);
		mainFrame.getContentPane().add(new JPanel(), BorderLayout.WEST);
		mainFrame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
		mainFrame.getContentPane().add(new JPanel(), BorderLayout.EAST);
		mainFrame.getContentPane().add(new JPanel(), BorderLayout.SOUTH);

		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}