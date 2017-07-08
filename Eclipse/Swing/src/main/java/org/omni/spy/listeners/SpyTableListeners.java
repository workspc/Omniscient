package org.omni.spy.listeners;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class SpyTableListeners implements TableModelListener {

	private Map<Integer, Object[]> myValues;
	private JTextArea textArea;

	public SpyTableListeners(JTextArea textArea) {
		myValues = new HashMap<>();
		this.textArea = textArea;
	}

	@Override
	public void tableChanged(TableModelEvent e) {

		int row = e.getFirstRow();
		TableModel model = (TableModel) e.getSource();

		boolean value = (boolean) model.getValueAt(row, 0);
		Object[] values = new Object[2];

		values[0] = model.getValueAt(row, 1);
		values[1] = model.getValueAt(row, 2);

		if (value)
			myValues.put(row, values);
		else if (myValues.containsKey(row))
			myValues.remove(row);

		String text = "";
		for (Map.Entry<Integer, Object[]> entry : myValues.entrySet()) {
			Object[] val = entry.getValue();
			text = text.concat(Arrays.deepToString(val) + "\n");
		}
		textArea.setText(text);
	}
}
