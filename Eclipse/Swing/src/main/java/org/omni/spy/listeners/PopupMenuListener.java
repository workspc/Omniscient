package org.omni.spy.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;

import org.omni.spy.gui.SpyStatusBar;

public class PopupMenuListener extends MouseAdapter implements ActionListener {

	private JTree tree;
	private MouseEvent event;

	public PopupMenuListener(JTree tree) {
		this.tree = tree;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if ("View Properties".equals(e.getActionCommand())) {

			JTree tree = (JTree) event.getSource();
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			SpyStatusBar.updateStatus("Getting properties for : " + node);
		}
		if ("Set Component".equals(e.getActionCommand()))
			System.out.println("Set Component");
		if ("Set Parent".equals(e.getActionCommand()))
			System.out.println("Set Parent");
		if ("Set Following Sibling".equals(e.getActionCommand()))
			System.out.println("Set Following Sibling");
		if ("Set Previous Sibling".equals(e.getActionCommand()))
			System.out.println("Set Previous Sibling");
		if ("Set Ancestor".equals(e.getActionCommand()))
			System.out.println("Set Ancestor");
		if ("Set Child".equals(e.getActionCommand()))
			System.out.println("Set Child");
		if ("Set Descandant".equals(e.getActionCommand()))
			System.out.println("Set Descandant");
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (SwingUtilities.isRightMouseButton(e)) {

			this.event = e;

			JPopupMenu popup = new JPopupMenu();

			JMenuItem viewProperties = new JMenuItem("View Properties");
			viewProperties.addActionListener(this);
			popup.add(viewProperties);

			popup.addSeparator();

			JMenuItem addComponent = new JMenuItem("Set Component");
			addComponent.addActionListener(this);
			popup.add(addComponent);

			JMenuItem withParent = new JMenuItem("Set Parent");
			withParent.addActionListener(this);
			popup.add(withParent);

			JMenuItem withFollowingSibling = new JMenuItem("Set Following Sibling");
			withFollowingSibling.addActionListener(this);
			popup.add(withFollowingSibling);

			JMenuItem withPreviousSibling = new JMenuItem("Set Previous Sibling");
			withPreviousSibling.addActionListener(this);
			popup.add(withPreviousSibling);

			JMenuItem withAncestor = new JMenuItem("Set Ancestor");
			withAncestor.addActionListener(this);
			popup.add(withAncestor);

			JMenuItem withChild = new JMenuItem("Set Child");
			withChild.addActionListener(this);
			popup.add(withChild);

			JMenuItem withDescendant = new JMenuItem("Set Descandant");
			withDescendant.addActionListener(this);
			popup.add(withDescendant);

			int row = tree.getClosestRowForLocation(e.getX(), e.getY());
			tree.setSelectionRow(row);
			popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}