package org.omni.spy.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

public class SpyTreePanel {

	private JPanel treePanel;
	private JTabbedPane tabbedPane;

	public SpyTreePanel() {
		treePanel = new JPanel();
		tabbedPane = new JTabbedPane();
		buildGUI();
	}

	private void buildGUI() {

		treePanel.setBackground(Color.decode("#CCE0FF"));

		JScrollPane scrollPane = new JScrollPane(SpyTree.getTree());
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		tabbedPane.setPreferredSize(new Dimension(300, 613));
		tabbedPane.addTab("Spy Hierarchy", null, scrollPane, "Component Hierarchy");
		treePanel.add(tabbedPane);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}

	public JPanel getTreePanel() {
		return treePanel;
	}
}