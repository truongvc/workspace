package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018
 * Version: 2.0
 * 
 * TME Assignment 4 
 * COMP 308
 * Class: GreenhouseControls.java
 *
 * purpose: controls various parts of Greenhouse with concurrency
 *   
 * NOTE: This version does NOT restore or shutdown properly
 * 	comments only made on code I added or updated.
 */
//: innerclasses/GreenhouseControls.java

// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct 21, 2005
 *
 */

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;


public class GreenhouseControls extends Controller implements Serializable,Runnable {

    public static HashMap<String, Object> statesList = new HashMap<String, Object>();
    public ArrayList<Thread> eventThreadsList = new ArrayList<>();
    private String eventsFile = "examples1.txt";
    private String dumpFile;
    
    /**
     * Starts events for Greenhouse passed in through events file
     * @param delay - delay before starting events
     * @param eventsFile - file to read events from
     */
    public void restart(long delay, String eventsFile) {
	System.out.println("Restarting System");
	try  {
	    //open file
	    Scanner scan = new Scanner(new File(eventsFile));
	    Event e; //event to create
	    Thread t;//thread for event
	    
	    while (scan.hasNext()) {//while there are events
		Class eventClass; //stores the class
		Constructor eventConst; //stores the constructor for eventClass class
		String s = scan.nextLine();//stores line in file

		// parse out event
		String event = s.split("Event=")[1];
		event = event.split(",")[0];

		// parse out time
		String stringTime = s.split("time=")[1];
		stringTime = stringTime.split(",")[0];
		long time = Long.parseLong(stringTime);
		
		// parse out ring
		int rings = 0;
		if (s.contains("rings")) {
		    String r = s.split("rings=")[1];
		    rings = Integer.parseInt(r);

		    //add ring events based on number of rings
		    while (rings > 0) {
			//use reflect to find out class and constructor
			eventClass = Class.forName("tme4." + event); 
			eventConst = eventClass.getConstructor(long.class);
			//create instance of current event type
			e = (Event) eventConst.newInstance(time);
			//create new thread for event
			t = new Thread(e);
			//add event thread to list
			eventThreadsList.add(t);
			//start thread
			t.start();
			//update ring count
			rings--;
			//update time for next ring event
			time += 2000;
		    }
		} else { // end if rings 
		    //for all other events
		  //use reflect to find out class and constructor
		    eventClass = Class.forName("tme4." + event);
		    eventConst = eventClass.getConstructor(long.class);
		  //create instance of current event type
		    e = (Event) eventConst.newInstance(time);
		  //create new thread for event
		    t = new Thread(e);
		  //add event thread to list
		    eventThreadsList.add(t);
		  //start thread
		    t.start();		    
		} // end else	
	    } // end while
	  scan.close();
	} catch (Exception e) {
	    e.printStackTrace();
	}//end try catch
	
//	for debug
//	System.out.println("----------PRE- STATES------------");
//	statesList.forEach((k,v) -> {
//	    System.out.printf(" key: %s, value: %s\n",k,v);
//	});

    }// end restart()

    /**
     * updates hashMap 'statesList' with state of event 
     * @param s - key - event to update
     * @param o - value - state of event
     */
    public static synchronized void setVariable(String s, Object o) {	
	statesList.put(s,o);//put k,v pair to map
    }
    
//does not work    
    /**
     * suspends all threads by telling each event in ArrayList 
     * 'eventsThreadList' to wait
     */
    public void suspendAll() {
	for (Thread t : eventThreadsList) {
	    try {
		synchronized(t) {	
		t.wait();
		}
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	System.out.println("Threads suspended");
    }

    /**
     * resumes all threads by telling each event in ArrayList 
     * 'eventsThreadList' to notify
     */
    public void resumeAll() {
//	for (Thread t : eventThreadsList) {
//	    synchronized(t) {
//	    t.notify();
//	    }
//	}
	
	notifyAll();
	System.out.println("Threads resumed");
    }

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
    
    /**
     * gets error code from GreenhouseController
     * 
     * @return 0 for normal, 1 for windowMalfunction, 2 for powerOut
     */
    public int getError() {
	int lastErrorCode = 0;// new error code variable

	// open error log and parse out error code
	try (Scanner scan = new Scanner(new File("src\\tme3\\error.log"));) {

	    while (scan.hasNext()) {
		String s = scan.nextLine();
		if (s.contains("error reason: ")) {
		    String code = s.split("reason: ")[1];
		    if (code.equals("Window Malfunction"))
			lastErrorCode = 1;
		    if (code.equals("Power Outage"))
			lastErrorCode = 2;
		} // end if(contains)
	    } // end while
	} catch (Exception e) {
	    System.out.println(e);
	}
	// System.out.println(lastErrorCode);
	return lastErrorCode;
    }// end getError

    /**
     * returns the appropriate Fixable object to correct the error and reset the
     * error code to zero
     * 
     * @param errorCode - Error code to fix
     * @return type of fix required
     */
    public Fixable getFixable(int errorCode) {
	if (errorCode == 1) {
	    return new FixWindow();
	} else {
	    return new PowerOn();
	}
    }// end getFixable

    /**
     * Emergency shutdown procedure logs nature and time of error, serializes
     * object and exits system.
     */
    public void shutdown() {

	GreenhouseControls gc = this; // current object

	try {
	    // write error log
	    File file = new File("src\\tme3\\error.log");
	    file.createNewFile();
	    FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter writer = new BufferedWriter(fw);
	    Calendar cal = Calendar.getInstance();

	    // write error info to error file
	    writer.write("error time: " + cal.getTime());
	    writer.newLine();

	    System.out.println("error time: " + cal.getTime());
	    // if (errorCode == 1) {
	    // System.out.println("error reason: Window Malfunction");
	    // writer.write("error reason: Window Malfunction");
	    // writer.newLine();
	    // }
	    // if (errorCode == 2) {
	    // System.out.println("error reason: Power Outage");
	    // writer.write("error reason: Power Outage");
	    // writer.newLine();
	    // }

	    // close writers
	    writer.close();
	    fw.close();

	    // write gc object to dump file
	    FileOutputStream dumpFile = new FileOutputStream(new File("src\\tme3\\dump.out"));
	    ObjectOutputStream o = new ObjectOutputStream(dumpFile);
	    o.writeObject(gc);

	    o.close();// close outputStream
	    dumpFile.close();// close file

	    // exit system
	    System.out.println("Shutting Down");
	    System.exit(-1);

	} catch (Exception e) {
	    System.out.println(e.getStackTrace());
	}
    }// end shutDown

    public static void printUsage() {
	System.out.println("Correct format: ");
	System.out.println("  java GreenhouseControls -f <filename>, or");
	System.out.println("  java GreenhouseControls -d dump.out");
    }// end printUsage

    // ---------------------------------------------------------
    public static void main(String[] args) {
	try {
	    String option = args[0];
	    String filename = args[1];

	    if (!(option.equals("-f")) && !(option.equals("-d"))) {
		System.out.println("Invalid option");
		printUsage();
	    }
	    
	    GreenhouseControls gc = new GreenhouseControls();

	    if (option.equals("-f")) {
		gc.restart(0, filename);
		gc.run();
		
//		gc.suspendAll();
//		gc.resumeAll();
		
		for(Thread t : gc.eventThreadsList){
		    try {
			t.join();
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}//end for
		
		
//for Testing
		System.out.println("\nExpected event states:");
		System.out.println("water: false");
		System.out.println("thermostat: day");
		System.out.println("fan: false");
		System.out.println("light: false");
		System.out.println();
		System.out.println("----------actual states after events have run------------");
		statesList.forEach((k,v) -> {
		    System.out.printf(" key: %s, value: %s\n",k,v);
		});
		
	    }//end if(-f)
	
	    // runs restore operation - this version does not do this
	    // if (option.equals("-d")) {
	    // Restore r = gc.new Restore(0, filename);
	    // r.action();
	    // }

	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Invalid number of parameters");
	    printUsage();
	}//end catch
    }//end main

} /// :~
