package org.omni.spy.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.omni.spy.SpyActionListener;

public class SpyToolBar {

	private JPanel toolBar;
	private SpyActionListener spyMenuListener;

	public SpyToolBar(SpyStatusBar statusBar) {
		spyMenuListener = new SpyActionListener();
		toolBar = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2d = (Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
				int w = getWidth();
				int h = getHeight();

				Color darker = Color.decode("#E5EFFF");
				Color lighter = Color.decode("#CCE0FF");

				GradientPaint gp = new GradientPaint(0, 0, darker, 0, h, lighter);
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, w, h);
			}
		};
		buildGUI();
	}

	private void buildGUI() {

		JButton startSpyButton = null;
		JButton stopSpyButton = null;
		JButton highlightButton = null;
		JButton expandAll = null;
		JButton collapseAll = null;

		// Spy start button.
		startSpyButton = buildButton("start.png", "Start Spy", "Start Spy");
		// Spy stop button.
		stopSpyButton = buildButton("stop.png", "Stop Spy", "Stop Spy");
		// Spy item highlight button.
		highlightButton = buildButton("highlight.png", "Highlight", "Highlight");

		expandAll = buildButton("expand.png", "Expand All", "Expand All");
		collapseAll = buildButton("collapse.png", "Collapse All", "Collapse All");

		toolBar.add(startSpyButton);
		toolBar.add(stopSpyButton);
		toolBar.add(highlightButton);
		toolBar.add(expandAll);
		toolBar.add(collapseAll);

		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		toolBar.setLayout(layout);

		toolBar.setPreferredSize(new Dimension(450, 33));
	}

	protected JButton buildButton(String image, String actionCommand, String tooltip) {

		URL imageURL = SpyToolBar.class.getResource("/images/" + image);

		// Create and initialize the button.
		JButton button = new JButton();
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setActionCommand(actionCommand);
		button.setToolTipText(tooltip);
		button.addActionListener(spyMenuListener);

		if (imageURL != null) {
			button.setIcon(new ImageIcon(imageURL, tooltip));
		} else {
			button.setText(tooltip);
			System.err.println("Resource not found: " + image);
		}

		return button;
	}

	public JPanel getToolBar() {
		return toolBar;
	}
}