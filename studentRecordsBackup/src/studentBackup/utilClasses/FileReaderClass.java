package studentBackup.utilClasses;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Prajakta More FileReaderClass tis contains objects of FileReader and
 *         BufferedReader
 */

public class FileReaderClass {
	static FileReader fileReader;
	static BufferedReader br;
	static String inputFileName;
	static String outputFileName;

	public FileReaderClass() {
		if (Debug.getDEBUG_VALUE() == 2) {
			Debug.strbuild.append("\n\n Constructor is called :: "
					+ this.getClass().getName());
		}
	}

	/**
	 * @return the fileReader
	 */
	public static FileReader getFileReader() {
		return fileReader;
	}

	/**
	 * @param fileReader
	 *            the fileReader to set
	 */
	public static void setFileReader(FileReader fileReader) {
		FileReaderClass.fileReader = fileReader;
	}

	/**
	 * @return the br
	 */
	public static BufferedReader getBr() {
		return br;
	}

	/**
	 * @param br
	 *            the br to set
	 */
	public static void setBr(BufferedReader br) {
		FileReaderClass.br = br;
	}

	/**
	 * @return the inputFileName
	 */
	public static String getInputFileName() {
		return inputFileName;
	}

	/**
	 * @param inputFileName
	 *            the inputFileName to set
	 */
	public static void setInputFileName(String inputFileName) {
		FileReaderClass.inputFileName = inputFileName;
	}

	/**
	 * @return the outputFileName
	 */
	public static String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * @param outputFileName
	 *            the outputFileName to set
	 */
	public static void setOutputFileName(String outputFileName) {
		FileReaderClass.outputFileName = outputFileName;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");

		result.append("" + NEW_LINE);

		return result.toString();
	}

}
