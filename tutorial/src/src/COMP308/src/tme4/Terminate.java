package tme4;

/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: Terminate.java
 *
 * purpose: simulates terminate event for greenhouse control
 */

public class Terminate extends Event {

    /**
     * Constructor 
     * @param delayTime - time in milliseconds to delay before executing event
     */
    public Terminate(long delayTime) {
	super(delayTime);
    }

    /**
     * runs event - in this case prints the event toString to console
     */
    public void action() {
	System.out.println(toString());
	// System.out.println("I Should terminate but didn't yet fix me?");
	// System.exit(0);
    }

    /**
     * @return Description of Event
     */
    public String toString() {
	return "Terminating";
    }

}// end Terminate class