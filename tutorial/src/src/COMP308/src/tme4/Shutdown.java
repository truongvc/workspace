package tme4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import tme3.GreenhouseControls;

public class Shutdown extends Event{
    
    private int errorCode;
    public Shutdown(long delayTime) { super(delayTime); }
    public void shutdown() {
	 
 	//GreenhouseControls gc = this; //current object

 	try {
 	    // write error log
 	    File file = new File("src\\tme3\\error.log");
 	    file.createNewFile();
 	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
 	    BufferedWriter writer = new BufferedWriter(fw);
 	    Calendar cal = Calendar.getInstance();
 	  
 	    //write error info to error file
 	    writer.write("error time: " + cal.getTime());
 	    writer.newLine();

 	    System.out.println("error time: " + cal.getTime());
 	    if (errorCode == 1) {
 		System.out.println("error reason: Window Malfunction");
 		writer.write("error reason: Window Malfunction");
 		writer.newLine();
 	    }
 	    if (errorCode == 2) {
 		System.out.println("error reason: Power Outage");
 		writer.write("error reason: Power Outage");
 		writer.newLine();
 	    }
 	    
 	    //close writers
 	    writer.close();
 	    fw.close();
 	    
 	    // write gc object to dump file
 	    FileOutputStream dumpFile = new FileOutputStream(
 		    new File("src\\tme3\\dump.out"));
 	    ObjectOutputStream o = new ObjectOutputStream(dumpFile);
// 	    o.writeObject(gc);

 	    o.close();//close outputStream
 	    dumpFile.close();//close file

 	    // exit system
 	    System.out.println("Shutting Down");
 	    System.exit(-1);
 	    
 	} catch (Exception e) {
 	    System.out.println(e.getStackTrace());
 	}
     }// end shutDown
    @Override
    public void run() {
	// TODO Auto-generated method stub
	
    }
    @Override
    public void action() {
	// TODO Auto-generated method stub
	
    }
}
