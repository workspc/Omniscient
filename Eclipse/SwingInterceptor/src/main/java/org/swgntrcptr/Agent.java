package org.swgntrcptr;

import java.awt.AWTEvent;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.WindowEvent;

public class Agent {

	public static void premain(String agentArgument) {
		System.out.println("Installing swing interceptor");
		attachWindowEventListener();
	}

	private static final void attachWindowEventListener() {

		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

			@Override
			public void eventDispatched(AWTEvent event) {

				if (event.getID() == WindowEvent.WINDOW_OPENED) {
					Container container = (Container) event.getSource();
					ContainerCache.setContainer(container);
				}
			}
		}, AWTEvent.WINDOW_EVENT_MASK | AWTEvent.WINDOW_FOCUS_EVENT_MASK | AWTEvent.WINDOW_STATE_EVENT_MASK);
	}
}