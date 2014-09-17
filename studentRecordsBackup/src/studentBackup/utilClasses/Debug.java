package studentBackup.utilClasses;

/**
 * @author Prajakta More Debugger class that maintains logging information
 */
public class Debug {
	public static StringBuilder strbuild = new StringBuilder();

	public Debug() {
		if (Debug.getDEBUG_VALUE() == 2) {
			strbuild.append("\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/**
	 * Integer Variable DEBUG_VALUE used for Logger
	 */
	private static int DEBUG_VALUE;

	// accessor and mutator for DEBUG_VALUE

	/**
	 * @return the dEBUG_VALUE
	 */
	public static int getDEBUG_VALUE() {
		return DEBUG_VALUE;
	}

	/**
	 * @param dEBUG_VALUE
	 *            the dEBUG_VALUE to set
	 */
	public static void setDEBUG_VALUE(int dEBUG_VALUE, String className) {
		DEBUG_VALUE = dEBUG_VALUE;
		if (DEBUG_VALUE == 0) {
			strbuild.append("\n Debug Value Selected is No output printed");
			Debug.strbuild.append(strbuild.toString());
			System.exit(0);
		}
	}

	@Override
	public String toString() {
		return Debug.strbuild.toString();
	}

}