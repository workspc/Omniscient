package org.omni.spy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.omni.spy.gui.SpyStatusBar;
import org.omni.spy.gui.SpyTree;

public class SpyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("Start Spy".equals(e.getActionCommand())) {
			SpyStatusBar.updateStatus("Spy Started");
		}
		if ("Stop Spy".equals(e.getActionCommand())) {
			SpyStatusBar.updateStatus("Spy Stopped");
		}
		if ("About".equals(e.getActionCommand())) {
			SpyStatusBar.updateStatus("About Swing Spy");
		}
		if ("Highlight".equals(e.getActionCommand())) {
			SpyStatusBar.updateStatus("Showing : 0 of 0");
		}
		if ("Expand All".equals(e.getActionCommand())) {
			SpyTree.expandAll();
		}
		if ("Collapse All".equals(e.getActionCommand())) {
			SpyTree.collapseAll();
		}
		if ("Exit".equals(e.getActionCommand())) {
			SpyStatusBar.updateStatus("Spy Stopped");
			SpyStatusBar.updateStatus("Goodbye.");
			System.exit(0);
		}
	}
}