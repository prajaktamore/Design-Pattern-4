package studentBackup.driver;

import java.io.IOException;

import studentBackup.interfaces.IBSTBuilder;
import studentBackup.interfaces.ICheckUserInput;
import studentBackup.util.BSTBuilder;
import studentBackup.utilClasses.BSTVisitorAdd;
import studentBackup.utilClasses.BSTVisitorUpdate;
import studentBackup.utilClasses.CatchWrongInputException;
import studentBackup.utilClasses.CheckUserInput;
import studentBackup.utilClasses.Debug;

/**
 * @author Prajakta More Driver class is Driver class that calls all Binary
 *         Search Tree Builder method
 */
public class Driver {
	/**
	 * Constructor of Driver
	 */
	public Driver() {
		if (Debug.getDEBUG_VALUE() == 2) {
			Debug.strbuild.append("\n\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	public static void main(String[] args) throws IOException {
		try {
			ICheckUserInput checkUserInput = new CheckUserInput();
			checkUserInput.checkUserInput(args[0], 2);
			IBSTBuilder bstBuild = new BSTBuilder();
			bstBuild.readFile(args[0], Integer.parseInt(args[1]));
			Debug.setDEBUG_VALUE(Integer.parseInt(args[2]), null);
			if (Debug.getDEBUG_VALUE() == 1) {
				bstBuild.printInOrder();
				bstBuild.accept(new BSTVisitorAdd());
				bstBuild.accept(new BSTVisitorUpdate());
				bstBuild.printInOrder();
				bstBuild.accept(new BSTVisitorAdd());
			}
		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Execution Failed");
		} finally {
			Debug d = new Debug();
			System.out.println(d.toString());
		}
	}

}
