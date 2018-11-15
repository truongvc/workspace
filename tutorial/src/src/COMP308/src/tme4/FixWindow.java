package tme4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public class FixWindow implements Fixable {
	private boolean windowOk;
	private int errorCode;

	/**
	 * sets the windowOk variable to true to indicate error is fixed
	 */
	public void fix() {
	    windowOk = true;
	}//end fix
	
	/**
	 * log nature and time of fix
	 */
	public void log() {
	    try {
		// write error log
		//create file
		File file = new File("src\\tme3\\fix.log");
		if (!file.exists()) {
		    file.createNewFile();
		}
		//create writer
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter writer = new BufferedWriter(fw);

		//get new instance of Calendar
		Calendar cal = Calendar.getInstance();
		
		//write fix info to file
		writer.write("Window Fixed");
		writer.newLine();

		writer.write("Fix time: " + cal.getTime());
		writer.newLine();

		System.out.println("Fix time: " + cal.getTime());
		errorCode = 0; //reset error code
		
		//close writers
		writer.close();
		fw.close();
	    } catch (Exception e) {
		System.out.println(e);
	    } // end catch

	}// end log

   }// end FixWindow class