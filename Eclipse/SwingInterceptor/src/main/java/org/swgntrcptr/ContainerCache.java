package org.swgntrcptr;

import java.awt.Container;

public class ContainerCache {

	private static Container container = null;

	public static Container getContainer() {
		return container;
	}

	public static void setContainer(Container container) {
		if (ContainerCache.container == null) {
			ContainerCache.container = container;
			System.out.println(container);
		}
	}
}