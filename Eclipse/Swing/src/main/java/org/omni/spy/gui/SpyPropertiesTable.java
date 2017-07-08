package org.omni.spy.gui;

import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableColumn;

import org.omni.spy.listeners.SpyTableListeners;
import org.omni.spy.models.SpyTableModel;

public class SpyPropertiesTable {

	private JTable table;
	private JTextArea textArea;

	public SpyPropertiesTable(JTextArea textArea) {
		this(new String[] { "Selected", "Properties", "Values" },
				new Object[][] { { false, "Name", "Exoskel" }, { false, "Age", "12" },
						{ false, "Organization", "S.T.A.R. Laboratories" }, { false, "Experience", "4" },
						{ false, "Manager", "Collins" } },
				textArea);

	}

	public SpyPropertiesTable(String[] cols, Object[][] data, JTextArea textArea) {
		table = new JTable(new SpyTableModel(cols, data));
		this.textArea = textArea;
		build(cols, data);
	}

	public void build(String[] cols, Object[][] data) {

		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		table.getModel().addTableModelListener(new SpyTableListeners(textArea));

		TableColumn column = null;
		int length = cols.length;
		for (int i = 0; i < length; i++) {
			column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(50);
		}
	}

	public JTable getTable() {
		return table;
	}
}