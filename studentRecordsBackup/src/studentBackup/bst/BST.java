package studentBackup.bst;

import studentBackup.interfaces.IBST;
import studentBackup.util.BSTBuilder;
import studentBackup.utilClasses.Debug;

/**
 * @author Prajakta More BST class that is Binary Search Tree
 */
public class BST implements IBST {

	/**
	 * Constructor of BST
	 */
	public BST() {
		if (Debug.getDEBUG_VALUE() == 2) {
			Debug.strbuild.append("\n\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	Node nodeVisit = null;
	BSTBuilder bstBuilder = new BSTBuilder();

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.IBST#insert(studentBackup.bst.Node, int)
	 */
	@Override
	public void insert(Node node, int value) {
		if (value < node.getValue()) {
			if (node.getLeft() != null) {
				insert(node.getLeft(), value);
			} else {
				Debug.strbuild.append("\n  Inserted " + value + " to left of "
						+ node.getValue());
				node.setLeft(new Node(value));
			}
		} else if (value > node.getValue()) {
			if (node.getRight() != null) {
				insert(node.getRight(), value);
			} else {
				Debug.strbuild.append("\n  Inserted " + value + " to right of "
						+ node.getValue());
				node.setRight(new Node(value));
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.IBST#printInOrder(studentBackup.bst.Node)
	 */
	@Override
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.getLeft());
			Debug.strbuild.append(" " + node.getValue());
			printInOrder(node.getRight());
		}
	}

	/**
	 * @param root
	 * @param root1
	 * @param root2
	 */
	public void updateValue(Node root, Node root1, Node root2) {
		if (root != null) {
			updateValue(root.getLeft(), root1.getLeft(), root2.getLeft());
			int i = root.getValue() + BSTBuilder.UPDATE_VALUE;
			root.addObserver(root1);
			root.addObserver(root2);
			root.setValue(i);
			updateValue(root.getRight(), root1.getRight(), root2.getRight());
		}
	}

	int add = 0;

	/**
	 * @param node
	 * @return int
	 */
	public int addInOrder(Node node) {
		if (node != null) {
			addInOrder(node.getLeft());
			add = add + node.getValue();
			addInOrder(node.getRight());
		}
		return add;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.IBST#acceptAddValue(studentBackup.bst.BST)
	 */
	@Override
	public void acceptAddValue(BST bstVisitorElement) {
		acceptAdd(bstVisitorElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.BSTElement#acceptAdd(studentBackup.bst.BST)
	 */
	public void acceptAdd(BST bstVisitorElement) {
		visitAdd(bstVisitorElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.BSTVisitor#visitAdd(studentBackup.bst.BST)
	 */
	public void visitAdd(BST bstVisitor) {
		add = 0;
		Debug.strbuild.append(" " + addInOrder(bstVisitor.getNodeVisit()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studentBackup.interfaces.IBST#acceptUpdateValue(studentBackup.bst.BST)
	 */
	@Override
	public void acceptUpdateValue(BST bstVisitorElement) {
		acceptUpdate(bstVisitorElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studentBackup.interfaces.BSTElement#acceptUpdate(studentBackup.bst.BST)
	 */
	public void acceptUpdate(BST bstVisitorElement) {
		visitUpdate(bstVisitorElement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studentBackup.interfaces.BSTVisitor#visitUpdate(studentBackup.bst.BST)
	 */
	public void visitUpdate(BST bstVisitor) {
		Node root = bstVisitor.getNodeVisit();
		Node root1 = BSTBuilder.getRoot1();
		Node root2 = BSTBuilder.getRoot2();
		updateValue(root, root1, root2);
	}

	/**
	 * @return the nodeVisit
	 */
	public Node getNodeVisit() {
		return nodeVisit;
	}

	/**
	 * @param nodeVisit
	 *            the nodeVisit to set
	 */
	public void setNodeVisit(Node nodeVisit) {
		this.nodeVisit = nodeVisit;
	}

	/**
	 * @param node
	 * @param value
	 */
	public void updateInOrder(Node node, int value) {
		if (node != null) {
			updateInOrder(node.getLeft(), value);
			node.setValue(value);
			updateInOrder(node.getRight(), value);
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("" + NEW_LINE);

		return result.toString();
	}

}
