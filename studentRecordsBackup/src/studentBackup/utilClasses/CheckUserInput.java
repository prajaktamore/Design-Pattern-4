package studentBackup.utilClasses;

/**
 * @author Prajakta More Checks the input validity
 */
public class CheckUserInput implements studentBackup.interfaces.ICheckUserInput {

	/**
	 * CheckUserInput COnstructor
	 */
	public CheckUserInput() {
		if (Debug.getDEBUG_VALUE() == 2) {
			Debug.strbuild.append("\nConstructor is called :: "
					+ this.getClass().getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * studentBackup.interfaces.ICheckUserInput#checkUserInput(java.lang.String,
	 * int)
	 */
	@Override
	public void checkUserInput(String inputFile, int input)
			throws CatchWrongInputException {
		try {
			if (null == inputFile || inputFile.trim().equals(" ")
					|| inputFile.length() == 0) {
				throw new CatchWrongInputException("Input String is not valid");
			}

			if (input < 0 && input > 5) {
				throw new CatchWrongInputException(
						"MM and NN should be between 1 to 5");
			}

		} catch (CatchWrongInputException e) {
			System.err.println("Exception Occured :: " + e.getMessage());
			System.exit(0);

		} finally {
		}
	}
}
