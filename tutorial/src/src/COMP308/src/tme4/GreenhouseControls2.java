package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: March 26, 2018
 * Version: 1.0
 * 
 * TME Assignment 3 
 * COMP 308
 * Class: GreenhouseControls.java
 *
 * purpose: controls various parts of Greenhouse. has ability to (de)serialize
 *   object to recover from errors.
 * 
 * NOTE: comments only made on code I added or updated.
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
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GreenhouseControls2 extends Controller implements Serializable,Runnable {
    // private boolean light = false;
    // private boolean water = false;
    // private boolean fans = false;
    // private String thermostat = "Day";

    // added fields
    // private boolean windowOk = true; //status of windows
    // private boolean powerOn = true; //status of power
    // private int errorCode = 0; // 0-normal 1 - windowMalfunction 2 - powerOut

    // public ArrayList<TwoTuple<String, Boolean>> statesList = new
    // ArrayList<>();
    public static HashMap<String, Object> statesList = new HashMap<String, Object>();
    public ArrayList<Thread> eventThreadsList = new ArrayList<>();
    private String eventsFile = "examples1.txt";
    private String dumpFile;
    static ExecutorService ex = Executors.newCachedThreadPool();
    
    public void restart(long delay, String eventsFile) {

	try (Scanner scan = new Scanner(new File(eventsFile));) {

	    long delayTime;
	    Event e;

	    while (scan.hasNext()) {
		Class eventClass;
		Constructor eventConst;
		String s = scan.nextLine();

		// parse out event
		String event = s.split("Event=")[1];
		event = event.split(",")[0];

		// parse out time
		String stringTime = s.split("time=")[1];
		stringTime = stringTime.split(",")[0];
		long time = Long.parseLong(stringTime);
		Thread t = new Thread();
		// parse out ring
		int rings = 0;
		if (s.contains("rings")) {
		    String r = s.split("rings=")[1];
		    rings = Integer.parseInt(r);

		    while (rings > 0) {
			eventClass = Class.forName("tme4." + event);
			eventConst = eventClass.getConstructor(long.class, HashMap.class);
			e = (Event) eventConst.newInstance(time,statesList);

//			Thread t = new Thread(e);
			t = new Thread(e);
			eventThreadsList.add(t);
			t.start();
			//ex.submit(t);
			rings--;
			time += 2000;
		    }
		} else { // end if rings

		    eventClass = Class.forName("tme4." + event);
		    eventConst = eventClass.getConstructor(long.class, HashMap.class);
		    e = (Event) eventConst.newInstance(time,statesList);
//		    Thread t = new Thread(e);
		    t = new Thread(e);
		    eventThreadsList.add(t);
		    t.start();
		    //ex.submit(t);
		    
		} // end else
		//setVariable(event);
		
	    } // end while
	  
	} catch (Exception e) {
	    System.out.println();
	    e.printStackTrace();
	}
	
	System.out.println("----------PRE- STATES------------");
	statesList.forEach((k,v) -> {
	    System.out.printf(" key: %s, value: %s\n",k,v);
	});

    }// end restart()

    public static synchronized void setVariable(String s, Object o) {
	   
	statesList.put(s,o);
//	    System.out.println(s + " state set" + o.toString());
	
    }
    public synchronized static void setVariable(String s) {

	if (s.equals("FansOn"))
	    statesList.put("Fan", true);

	if (s.equals("FansOff"))
	    statesList.put("Fan", false);

	if (s.equals("LightOn"))
	    statesList.put("Light", true);

	if (s.equals("LightOff"))
	    statesList.put("Light", false);

	if (s.equals("WaterOn"))
	    statesList.put("Water", true);

	if (s.equals("WaterOff"))
	    statesList.put("Water", true);

	if (s.equals("ThermostatNight"))
	    statesList.put("Thermostat", "Night");

	if (s.equals("ThermostatDay"))
	    statesList.put("Thermostat", "Day");

	if (s.equals("WindowMalfunction"))
	    statesList.put("WindowOk", false);

	if (s.equals("PowerOut"))
	    statesList.put("PowerOn", false);

	if (s.equals("WindowFixed"))
	    statesList.put("WindowOk", true);

	if (s.equals("PowerFixed"))
	    statesList.put("PowerOn", true);

}

    public void suspendAll() {
	for (Thread t : eventThreadsList) {
	    try {
		t.wait();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    public void resumeAll() {
	for (Thread t : eventThreadsList) {
	    t.notify();
	}
    }

    // class to restore from dump file
    public class restore {
	// filename of dump file
	//
	// /**
	// * Restore constructor
	// * @param delayTime - time to execute
	// * @param filename - filename to read in from
	// */
	// public Restore(long delayTime, String filename) {
	// super(delayTime);
	// dumpFile = filename;
	// }

	/**
	 * recover from error and continues event
	 */
	public void action() {
	    try {

		// deserialize object from file
		FileInputStream file = new FileInputStream(dumpFile);
		ObjectInputStream in = new ObjectInputStream(file);
		GreenhouseControls2 gc = (GreenhouseControls2) in.readObject();

		// find error code
		Fixable fix = getFixable(getError());

		// execute appropriate fix
		if (fix instanceof PowerOn) {
		    PowerOn p = new PowerOn();
		    p.fix();// fix error
		    p.log();// log fix to file
		    System.out.println("power fixed");
		}
		if (fix instanceof FixWindow) {
		    FixWindow w = new FixWindow();
		    w.fix();// fix error
		    w.log();// log fix to file
		    System.out.println("windows fixed");
		}

		gc.run();// run remaining events

		// close I/O stream
		in.close();
		file.close();
	    } catch (Exception e) {
		System.out.println(e);
	    } // end catch
	}// end action

	public String toString() {
	    return "Restored";
	}// end toString

    }// end restore class

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

	GreenhouseControls2 gc = this; // current object

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

	    
	    GreenhouseControls2 gc = new GreenhouseControls2();

	    if (option.equals("-f")) {
		// gc.addEvent(gc.restart(0, filename));
		gc.restart(0, filename);
		gc.run();
		 
		    
//		System.out.println("all threads shutdown: " + ex.isTerminated());
//		
//		Thread x = new Thread();
//		try {
//		    ex.submit(x);
//		    x.sleep(20000);
//		    System.out.println("after thread x");
//		} catch (InterruptedException e) {
//		    // TODO Auto-generated catch block
//		    e.printStackTrace();
//		}
//		    System.out.println("way after thread x");
//		
//		
		for(Thread t : gc.eventThreadsList){
		    try {
			t.join();
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
//		}
//		
//		try {
//		    Thread.sleep(21000);
//		} catch (InterruptedException e) {
//		    // TODO Auto-generated catch block
//		    e.printStackTrace();
		}//end for
		
	
		System.out.println("----------post STATES------------");
		statesList.forEach((k,v) -> {
		    System.out.printf(" key: %s, value: %s\n",k,v);
		});
	    }
	    ex.shutdown();
	    // runs restore operation
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
