package studentBackup.utilClasses;

import studentBackup.bst.BST;
import studentBackup.interfaces.BSTVisitor;
import studentBackup.interfaces.IBST;
import studentBackup.util.BSTBuilder;
/**
 * @author Prajakta More
 *  BSTVisitor implementation BSTVisitorUpdate
 */
public class BSTVisitorUpdate implements BSTVisitor{

	/* (non-Javadoc)
	 * @see studentBackup.interfaces.BSTVisitor#visit(studentBackup.interfaces.BSTVisitor)
	 */
	@Override
	public void visit(BSTVisitor bstVisitor) {
		IBST bst1 = new BST();
		if (null != BSTBuilder.getRoot1()) {
			BSTBuilder.setRoot1(BSTBuilder.getRoot1());
		}
		if (null != BSTBuilder.getRoot2()) {
			BSTBuilder.setRoot2(BSTBuilder.getRoot2());
		}
		if (null != BSTBuilder.getBst()) {
			bst1.acceptUpdateValue(BSTBuilder.getBst());
		}
	}

}
