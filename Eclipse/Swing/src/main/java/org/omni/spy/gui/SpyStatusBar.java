package org.omni.spy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import org.apache.commons.configuration2.Configuration;

public class SpyStatusBar {

	private Configuration ctx;
	private JPanel statusBarPanel = new JPanel();
	private static JLabel msg;

	public SpyStatusBar(Configuration ctx) {
		this.ctx = ctx.subset("bar");
		msg = new JLabel("Swing Spy. Version-2.0", JLabel.RIGHT);
		buildGUI();
	}

	private void buildGUI() {

		Border border = msg.getBorder();
		Border margin = new EmptyBorder(12, 10, 10, 20);
		msg.setBorder(new CompoundBorder(border, margin));

		statusBarPanel.setLayout(new BorderLayout());
		Dimension dimension = statusBarPanel.getSize();
		dimension.height = ctx.getInt("height");
		statusBarPanel.setPreferredSize(dimension);
		statusBarPanel.add(msg, BorderLayout.EAST);
		statusBarPanel.setBackground(Color.decode("#CCE0FF"));
	}

	public static void updateStatus(String text) {
		if (msg != null) {
			msg.setText("");
			msg.setText(text);
		}
	}

	public JPanel getStatusBarPanel() {
		return statusBarPanel;
	}
}