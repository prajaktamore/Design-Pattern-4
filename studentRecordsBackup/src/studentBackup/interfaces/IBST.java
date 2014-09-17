package studentBackup.interfaces;

import studentBackup.bst.BST;
import studentBackup.bst.Node;

/**
 * @author Prajakta More IBST interface for BST class
 */
public interface IBST {
	/**
	 * @param node
	 * @param value
	 */
	public void insert(Node node, int value);

	/**
	 * @param node
	 */
	public void printInOrder(Node node);

	/**
	 * @param bstVisitorElement
	 */
	public void acceptAddValue(BST bstVisitorElement);

	/**
	 * @param bstVisitorElement
	 */
	public void acceptUpdateValue(BST bstVisitorElement);
}
