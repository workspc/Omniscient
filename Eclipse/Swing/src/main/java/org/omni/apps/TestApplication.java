package org.omni.apps;

import static org.omni.Property.prop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

import org.apache.commons.configuration2.Configuration;
import org.omni.Application;

public class TestApplication implements Application {

	private Configuration ctx = prop.subset("test");

	@Override
	public void execute() {

		createGUI();
	}

	private void createGUI() {

		JFrame frame = new JFrame(ctx.getString("title"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Configuration menuCtx = ctx.subset("menu");
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.decode(menuCtx.getString("color")));
		menuBar.setPreferredSize(new Dimension(menuCtx.getInt("width"), menuCtx.getInt("height")));

		Configuration lblCtx = ctx.subset("label");
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.decode(lblCtx.getString("color")));
		label.setPreferredSize(new Dimension(lblCtx.getInt("width"), lblCtx.getInt("height")));

		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(label, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}
}