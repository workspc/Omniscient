package org.omni.spy.core;

public enum SpyConstants {

	CONTEXT("spy"),

	TITLE("title"),

	WIDTH("width"),
	
	BG_COLOR("bgcolor"),

	HEIGHT("height");

	private final String name;

	private SpyConstants(final String name) {
		this.name = name;
	}

	public String getStr() {
		return name;
	}
}