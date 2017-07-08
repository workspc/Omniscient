package org.omni;

import javax.swing.UnsupportedLookAndFeelException;

import org.omni.spy.Spy;

public class ApplicationLauncher {

	private static Application application;

	public static void bind() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		if (application == null) {
			application = new Spy();
		}
	}
}