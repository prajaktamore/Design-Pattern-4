package studentBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import studentBackup.bst.BST;
import studentBackup.bst.Node;
import studentBackup.interfaces.BSTVisitor;
import studentBackup.interfaces.IBST;
import studentBackup.interfaces.IBSTBuilder;
import studentBackup.utilClasses.Debug;
import studentBackup.utilClasses.FileReaderClass;

/**
 * @author Prajakta More BSTBuilder class is Binary Search Tree Builder that
 *         calls all methods of BST class
 */
public class BSTBuilder implements IBSTBuilder {
	public static int UPDATE_VALUE;

	private static Node root1 = null;
	private static Node root2 = null;
	private static Node root = null;
	private static BST bst;
	private static BST backupOne;
	private static BST backupTow;

	/**
	 * Constructor of BSTBuilder
	 */
	public BSTBuilder() {
		if (Debug.getDEBUG_VALUE() == 2) {
			Debug.strbuild.append("\n\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.IBSTBuilder#readFile(java.lang.String, int)
	 */
	@Override
	public void readFile(String filename, int update_Value) {
		FileReaderClass.setInputFileName(filename);
		UPDATE_VALUE = update_Value;
		BST bst = new BST();
		backupOne = new BST();
		backupTow = new BST();
		try {
			try {
				FileReaderClass.setFileReader(new FileReader(FileReaderClass
						.getInputFileName()));
			} catch (FileNotFoundException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			}
			FileReaderClass.setBr(new BufferedReader(FileReaderClass
					.getFileReader()));

			String fileData = null;
			try {
				LineNumberReader lnr = new LineNumberReader(new FileReader(
						new File(FileReaderClass.getInputFileName())));
				lnr.skip(Long.MAX_VALUE);
				root = new Node(lnr.getLineNumber());
				root1 = new Node(lnr.getLineNumber());
				root2 = new Node(lnr.getLineNumber());
				lnr.close();
				while ((fileData = FileReaderClass.getBr().readLine()) != null) {
					Debug.strbuild.append(fileData);
					if (fileData != null && fileData != "" && fileData != " ") {
						bst.insert(root, Integer.parseInt(fileData));
						backupOne.insert(root1, Integer.parseInt(fileData));
						backupTow.insert(root2, Integer.parseInt(fileData));
					}
				}
			} catch (NumberFormatException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			} catch (IOException e) {
				System.err.println("Exception Occured :: " + e.getMessage());
				System.exit(0);
			}
			BSTBuilder.setRoot(root);
			BSTBuilder.setRoot1(root1);
			BSTBuilder.setRoot2(root2);

			bst.setNodeVisit(root);
			backupOne.setNodeVisit(root1);
			backupTow.setNodeVisit(root2);

			BSTBuilder.setBst(bst);
			BSTBuilder.setBackupOne(backupOne);
			BSTBuilder.setBackupTow(backupTow);
		} catch (Exception e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see studentBackup.interfaces.IBSTBuilder#printInOrder()
	 */
	@Override
	public void printInOrder() {
		Debug.strbuild.append("\n\n Root BST");
		IBST bst1 = new BST();
		if (null != BSTBuilder.getRoot()) {
			bst1.printInOrder(BSTBuilder.getRoot());
		}
		Debug.strbuild.append("\n\n BST BackUp One");
		if (null != BSTBuilder.getRoot1()) {
			bst1.printInOrder(BSTBuilder.getRoot1());
		}
		Debug.strbuild.append("\n\n BST BackUp Two");
		if (null != BSTBuilder.getRoot1()) {
			bst1.printInOrder(BSTBuilder.getRoot2());
		}
	}

	/**
	 * @return the root
	 */
	public static Node getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public static void setRoot(Node root) {
		BSTBuilder.root = root;
	}

	/**
	 * @return the bst
	 */
	public static BST getBst() {
		return bst;
	}

	/**
	 * @param bst
	 *            the bst to set
	 */
	public static void setBst(BST bst) {
		BSTBuilder.bst = bst;
	}

	/**
	 * @return the backupOne
	 */
	public static BST getBackupOne() {
		return backupOne;
	}

	/**
	 * @param backupOne
	 *            the backupOne to set
	 */
	public static void setBackupOne(BST backupOne) {
		BSTBuilder.backupOne = backupOne;
	}

	/**
	 * @return the backupTow
	 */
	public static BST getBackupTow() {
		return backupTow;
	}

	/**
	 * @param backupTow
	 *            the backupTow to set
	 */
	public static void setBackupTow(BST backupTow) {
		BSTBuilder.backupTow = backupTow;
	}

	/**
	 * @return the root1
	 */
	public static Node getRoot1() {
		return root1;
	}

	/**
	 * @param root1
	 *            the root1 to set
	 */
	public static void setRoot1(Node root1) {
		BSTBuilder.root1 = root1;
	}

	/**
	 * @return the root2
	 */
	public static Node getRoot2() {
		return root2;
	}

	/**
	 * @param root2
	 *            the root2 to set
	 */
	public static void setRoot2(Node root2) {
		BSTBuilder.root2 = root2;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("" + NEW_LINE);

		return result.toString();
	}

	@Override
	public void accept(BSTVisitor visit) {
		visit.visit(visit);
	}

}
