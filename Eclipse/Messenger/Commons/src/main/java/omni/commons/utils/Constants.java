package omni.commons.utils;

import javax.swing.UIManager;

public enum Constants {

	TITLE("Messenger"),

	LAF(UIManager.getSystemLookAndFeelClassName());

	private final Object value;

	private Constants(Object value) {
		this.value = value;
	}

	public Object toObject() {
		return value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public Integer toInt() {
		return Integer.valueOf(toString());
	}
}