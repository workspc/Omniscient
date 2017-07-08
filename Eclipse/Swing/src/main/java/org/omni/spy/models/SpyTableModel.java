package org.omni.spy.models;

import javax.swing.table.AbstractTableModel;

public class SpyTableModel extends AbstractTableModel {

	private Object[] cols;
	private Object[][] data;

	public SpyTableModel(Object[] columns, Object[][] data) {

		this.cols = columns;
		this.data = data;
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return cols.length;
	}

	@Override
	public String getColumnName(int col) {
		return String.valueOf(cols[col]);
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		if (col > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void setValueAt(Object value, int row, int col) {

		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}
}