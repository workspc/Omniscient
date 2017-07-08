package org.omni.spy.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SpyPropertiesPanel {

	private JPanel propertiesPanel;
	private JTabbedPane tabbedPane;
	private JTextArea textArea;

	public SpyPropertiesPanel() {
		propertiesPanel = new JPanel();
		tabbedPane = new JTabbedPane();
		textArea = new JTextArea();
		buildGUI();
	}

	private void buildGUI() {

		propertiesPanel.setBackground(Color.decode("#CCE0FF"));

		JScrollPane scrollPane = new JScrollPane(new SpyPropertiesTable(textArea).getTable());
		scrollPane.setPreferredSize(new Dimension(1042, 500));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		tabbedPane.addTab("Mango Properties", null, scrollPane, "Component Hierarchy");
		propertiesPanel.add(tabbedPane, BorderLayout.NORTH);

		JScrollPane textScrollPane = new JScrollPane(textArea);
		textScrollPane.setPreferredSize(new Dimension(1042, 79));
		textScrollPane.setBackground(Color.WHITE);
		propertiesPanel.add(textScrollPane, BorderLayout.SOUTH);
	}

	public JPanel getPropertiesPanel() {
		return propertiesPanel;
	}
}