package org.omni.spy.gui;

import java.awt.Component;
import java.awt.Container;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Enumeration;
import java.util.TreeSet;

import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.omni.spy.listeners.PopupMenuListener;

public class SpyTree {

	private static JTree tree;
	private DefaultMutableTreeNode root;

	public SpyTree() {
		buildGUI();
	}

	private void buildGUI() {

		root = new DefaultMutableTreeNode("Dashboard");

		DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
		vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
		vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
		vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
		vegetableNode.add(new DefaultMutableTreeNode("Potato"));

		DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
		fruitNode.add(new DefaultMutableTreeNode("Banana"));
		fruitNode.add(new DefaultMutableTreeNode("Mango"));
		fruitNode.add(new DefaultMutableTreeNode("Apple"));
		fruitNode.add(new DefaultMutableTreeNode("Grapes"));
		fruitNode.add(new DefaultMutableTreeNode("Orange"));

		root.add(vegetableNode);
		root.add(fruitNode);

		tree = new JTree(root);
		tree.setShowsRootHandles(true);
		tree.addMouseListener(new PopupMenuListener(tree));
	}

	public void reload(Component rootComponent, Component selectedComponent) {
		root.removeAllChildren();
		addNode(root, rootComponent, selectedComponent);
		SwingUtilities.updateComponentTreeUI(tree);
	}

	protected void addNode(DefaultMutableTreeNode parent, Component component, Component selectedComponent) {
		DefaultMutableTreeNode componentNode = new DefaultMutableTreeNode(new ComponentWrapper(component));
		parent.add(componentNode);
		if (component == selectedComponent) {
			TreePath selectedPath = new TreePath(componentNode.getPath());
			tree.setSelectionPath(selectedPath);
			tree.scrollPathToVisible(selectedPath);
		}

		if (component instanceof Container) {
			Container container = (Container) component;
			Component[] childComponents = container.getComponents();
			for (Component child : childComponents) {
				addNode(componentNode, child, selectedComponent);
			}
		}
	}

	static class ComponentWrapper {
		Component component;

		ComponentWrapper(Component component) {
			this.component = component;
		}

		@Override
		public String toString() {
			String name = component.getName();
			return (name != null ? name + "  " : "") + '(' + component.getClass().getSimpleName() + ')';
		}

		public String toHtmlString() {
			StringBuilder str = new StringBuilder("<html>");
			str.append("&nbsp;name: ").append("<b>").append(component.getName()).append("</b><br>");
			str.append("&nbsp;class: ").append("<b>").append(component.getClass().getName()).append("</b><br>");
			return str.toString();
		}

		public String toDetailedString() {
			Object bean = component;
			if (bean == null) {
				return "<null>";
			}

			TreeSet<String> treeSet = new TreeSet<String>();

			Class<?> clazz = bean.getClass();
			Field[] fields = clazz.getDeclaredFields();

			for (Field field : fields) {
				StringBuilder str = new StringBuilder();

				int modifiers = field.getModifiers();
				if (Modifier.isPublic(modifiers)) {
					str.append('+');
				} else if (Modifier.isProtected(modifiers)) {
					str.append('#');
				} else if (Modifier.isPrivate(modifiers)) {
					str.append('-');
				} else {
					str.append(' ');
				}

				str.append(field.getName()).append(':');

				try {
					Object value = field.get(bean);

					if (value == null) {
						str.append("<null>");
					} else {
						String valueString = value.toString();
						if (valueString.length() > 250) {
							valueString = valueString.substring(0, 250) + "...";
						}
						str.append(valueString);
					}
				} catch (IllegalAccessException ignore) {
					str.append("N/A");
				}

				str.append('\n');

				treeSet.add(htmlSafe(str.toString()));
			}

			StringBuilder resolve = new StringBuilder("<html>");
			for (String s1 : treeSet) {
				resolve.append(s1);
			}
			return resolve.toString();
		}
	}

	private static String htmlSafe(String str) {
		str = str.replace("<", "&gt;");
		str = str.replace(">", "&lt;");
		str = str.replace(" ", "&nbsp;");
		str = str.replace("\n", "<br>");
		return str;
	}

	public static JTree getTree() {
		return tree;
	}

	public static void expandAll() {
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		expandAll(tree, new TreePath(root));
	}

	public static void collapseAll() {
		TreeNode root = (TreeNode) tree.getModel().getRoot();
		collapseAll(tree, new TreePath(root));
	}

	private static void expandAll(JTree tree, TreePath parent) {

		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration<?> e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path);
			}
		}
		tree.expandPath(parent);
	}

	private static void collapseAll(JTree tree, TreePath parent) {

		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration<?> e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path);
			}
		}
		tree.collapsePath(parent);
	}
}