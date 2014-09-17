package studentBackup.interfaces;

/**
 * @author Prajakta More IBSTBuilder is interface that BSTBuilder
 */
public interface IBSTBuilder {
	/**
	 * @param filename
	 * @param update_Value
	 */
	public void readFile(String filename, int update_Value);

	/**
	 * printInOrder method
	 */
	public void printInOrder();
	/**
	 * @param bstVisitorElement
	 */
	public void accept(BSTVisitor visit);

}
