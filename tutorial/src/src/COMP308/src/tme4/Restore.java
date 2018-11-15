package tme4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//class to restore from dump file
public class Restore extends Event{
	String dumpFile; //filename of dump file
	
	/**
	 * Restore constructor
	 * @param delayTime - time to execute
	 * @param filename - filename to read in from
	 */
	public Restore(long delayTime, String filename) {
	    super(delayTime);
	    dumpFile = filename;
	}
	
	/**
	 * recover from error and continues event
	 */
	public void action() {
	 try {
	     
	     //deserialize object from file
	     FileInputStream file = new FileInputStream(dumpFile);
	     ObjectInputStream in = new ObjectInputStream(file);
	     GreenhouseControls gc = (GreenhouseControls)in.readObject();
 
	     //find error code
	     Fixable fix = getFixable(getError());
	     
	     //execute appropriate fix
	     if(fix instanceof PowerOn) {
		PowerOn p = new PowerOn();
		p.fix();//fix error
		p.log();//log fix to file
		System.out.println("power fixed");
	     }
	     if(fix instanceof FixWindow) {
		 FixWindow w = new FixWindow();
		 w.fix();//fix error
		 w.log();//log fix to file
		System.out.println("windows fixed");
	     }
		
	     gc.run();//run remaining events
	     
	     //close I/O  stream
	     in.close();
	     file.close();
	 }catch(Exception e) {
	     System.out.println(e);
	 }//end catch
	}//end action
	
	public String toString() {
	    return "Restored";
	}//end toString
 }//end restore class