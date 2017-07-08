package org.omni.spy;

import static javax.swing.SwingUtilities.invokeLater;
import static org.omni.Property.prop;
import static org.omni.spy.core.SpyConstants.BG_COLOR;
import static org.omni.spy.core.SpyConstants.CONTEXT;
import static org.omni.spy.core.SpyConstants.HEIGHT;
import static org.omni.spy.core.SpyConstants.TITLE;
import static org.omni.spy.core.SpyConstants.WIDTH;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.configuration2.Configuration;
import org.omni.Application;
import org.omni.spy.gui.SpyMenu;
import org.omni.spy.gui.SpyPropertiesPanel;
import org.omni.spy.gui.SpyStatusBar;
import org.omni.spy.gui.SpyToolBar;
import org.omni.spy.gui.SpyTreePanel;

public class Spy implements Application {

	private static final int MOUSE_HOTKEY = MouseEvent.SHIFT_DOWN_MASK | MouseEvent.CTRL_DOWN_MASK
			| MouseEvent.BUTTON1_DOWN_MASK;
	private JFrame frame;
	private SpyStatusBar statusBar;
	private Configuration ctx = prop.subset(CONTEXT.getStr());

	public Spy() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {

		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

			public void eventDispatched(AWTEvent awtEvent) {
				MouseEvent event = (MouseEvent) awtEvent;
				if ((event.getModifiersEx() == MOUSE_HOTKEY) && (event.getClickCount() == 1)) {
					launch((Component) event.getSource());
					event.consume();
				}
			}
		}, AWTEvent.MOUSE_EVENT_MASK);

		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		frame = new JFrame();
	}

	private void launch(final Component component) {
		launch(SwingUtilities.getRoot(component), component);
	}

	private void launch(final Component root, final Component currentComponent) {

		invokeLater(new Runnable() {
			public void run() {
				build(root, currentComponent);
			}
		});
	}

	@Override
	public void build(final Component root, final Component currentComponent) {

		// Spy framework's main frame.
		frame = new JFrame(ctx.getString(TITLE.getStr()));
		frame.getContentPane().setBackground(Color.decode(ctx.getString(BG_COLOR.getStr())));
		frame.setPreferredSize(new Dimension(ctx.getInt(WIDTH.getStr()), ctx.getInt(HEIGHT.getStr())));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Spy framework's status bar.
		statusBar = new SpyStatusBar(ctx);
		frame.getContentPane().add(statusBar.getStatusBarPanel(), BorderLayout.SOUTH);

		// Spy framework's menu.
		SpyMenu spyMenu = new SpyMenu(statusBar);
		frame.setJMenuBar(spyMenu.getMenuBar());

		// Spy framework's toolbar.
		SpyToolBar toolBar = new SpyToolBar(statusBar);
		frame.getContentPane().add(toolBar.getToolBar(), BorderLayout.NORTH);

		// Spy framework's tree panel.
		SpyTreePanel treePanel = new SpyTreePanel();
		frame.getContentPane().add(treePanel.getTreePanel(), BorderLayout.WEST);

		// Spy framework's properties panel.
		SpyPropertiesPanel propertiesPanel = new SpyPropertiesPanel();
		frame.getContentPane().add(propertiesPanel.getPropertiesPanel(), BorderLayout.CENTER);

		JPanel fut = new JPanel();
		fut.setBackground(Color.decode("#CCE0FF"));
		frame.getContentPane().add(fut, BorderLayout.EAST);

		// Spy framework's settings for display.
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
	}
}