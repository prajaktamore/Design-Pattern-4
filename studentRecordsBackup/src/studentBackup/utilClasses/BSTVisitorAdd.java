package studentBackup.utilClasses;

import studentBackup.bst.BST;
import studentBackup.interfaces.BSTVisitor;
import studentBackup.interfaces.IBST;
import studentBackup.util.BSTBuilder;
/**
 * @author Prajakta More
 *  BSTVisitor implementation BSTVisitorAdd
 */
public class BSTVisitorAdd implements BSTVisitor{

	/* (non-Javadoc)
	 * @see studentBackup.interfaces.BSTVisitor#visit(studentBackup.interfaces.BSTVisitor)
	 */
	@Override
	public void visit(BSTVisitor bstVisitor) {
		IBST bst1 = new BST();
		Debug.strbuild.append("\n\n Root BST Total :: ");
		if (null != BSTBuilder.getBst()) {
			bst1.acceptAddValue(BSTBuilder.getBst());
		}
		Debug.strbuild.append("\n\n BST BackUp One Total :: ");
		if (null != BSTBuilder.getBackupOne()) {
			bst1.acceptAddValue(BSTBuilder.getBackupOne());
		}
		Debug.strbuild.append("\n\n BST BackUp Two Total :: ");
		if (null != BSTBuilder.getBackupTow()) {
			bst1.acceptAddValue(BSTBuilder.getBackupTow());
		}
	}

}
