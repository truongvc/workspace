package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: WaterOn.java
 *
 * purpose: simulates water on event for greenhouse control
 */

public class WaterOn extends Event {
    /**
     * Constructor 
     * @param delayTime - time in milliseconds to delay before executing event
     */
    public WaterOn(long delayTime) {
	super(delayTime);
    }
    /**
     * runs event - prints the event toString to console and updates state var
     */
    public void action() {
	// Put hardware control code here.
	System.out.println(toString());
	GreenhouseControls.setVariable("Water", true);
    }
    /**
     * @return Description of Event
     */
    public String toString() {
	return "Greenhouse water is on";
    }

}