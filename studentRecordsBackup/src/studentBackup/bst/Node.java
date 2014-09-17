package studentBackup.bst;

import java.util.Observable;
import java.util.Observer;

import studentBackup.util.BSTBuilder;

/**
 * @author Prajakta More Node class that is Node of tree
 */
public class Node extends Observable implements Observer {

	private Node left;
	private Node right;
	private int value;

	/**
	 * @param invalue
	 */
	public Node(int invalue) {
		value = invalue;
	}

	/**
	 * @return the left
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * @return the right
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
		setChanged();
		notifyObservers();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.setValue(BSTBuilder.UPDATE_VALUE + this.getValue());
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("" + NEW_LINE);

		return result.toString();
	}

}
