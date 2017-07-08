package org.omni.spy.gui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.omni.spy.SpyActionListener;

public class SpyMenu {

	private JMenuBar menuBar;
	private JMenu spy, help;
	private JMenuItem spyStart, spyStop, spyExit;
	private JMenuItem helpAbout;
	private SpyActionListener spyMenuListener;
	private static final int actionEvent = ActionEvent.ALT_MASK | ActionEvent.CTRL_MASK;

	public SpyMenu(SpyStatusBar statusBar) {
		spyMenuListener = new SpyActionListener();
		buildGUI();
	}

	public void buildGUI() {

		menuBar = new JMenuBar();

		// Spy menu.
		spy = new JMenu("Spy");
		spy.setMnemonic(KeyEvent.VK_S);
		spy.setMargin(new Insets(0, 5, 0, 5));
		{
			// Start spy menu item.
			spyStart = new JMenuItem("Start Spy", KeyEvent.VK_S) {

				private static final long serialVersionUID = 1L;

				@Override
				public Dimension getPreferredSize() {
					Dimension d = super.getPreferredSize();
					d.width = Math.max(d.width, 225);
					d.height = Math.max(d.height, 25);
					return d;
				}
			};
			spyStart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, actionEvent));
			spyStart.addActionListener(spyMenuListener);
			spy.add(spyStart);

			// Start spy menu item.
			spyStop = new JMenuItem("Stop Spy", KeyEvent.VK_T) {

				private static final long serialVersionUID = 1L;

				@Override
				public Dimension getPreferredSize() {
					Dimension d = super.getPreferredSize();
					d.width = Math.max(d.width, 225);
					d.height = Math.max(d.height, 25);
					return d;
				}
			};
			spyStop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, actionEvent));
			spyStop.addActionListener(spyMenuListener);
			spy.add(spyStop);

			// The separator.
			spy.addSeparator();

			// Start spy menu item.
			spyExit = new JMenuItem("Exit", KeyEvent.VK_E) {

				private static final long serialVersionUID = 1L;

				@Override
				public Dimension getPreferredSize() {
					Dimension d = super.getPreferredSize();
					d.width = Math.max(d.width, 225);
					d.height = Math.max(d.height, 25);
					return d;
				}
			};
			spyExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
			spyExit.addActionListener(spyMenuListener);
			spy.add(spyExit);
		}

		// Help menu.
		help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		help.setMargin(new Insets(0, 5, 0, 5));
		{
			// Information about the tool menu item.
			helpAbout = new JMenuItem("About", KeyEvent.VK_A) {

				private static final long serialVersionUID = 1L;

				@Override
				public Dimension getPreferredSize() {
					Dimension d = super.getPreferredSize();
					d.width = Math.max(d.width, 225);
					d.height = Math.max(d.height, 25);
					return d;
				}
			};
			helpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, actionEvent));
			helpAbout.addActionListener(spyMenuListener);
			help.add(helpAbout);
		}

		menuBar.add(spy);
		menuBar.add(help);
	}

	public JMenuBar getMenuBar() {
		return menuBar;
	}
}