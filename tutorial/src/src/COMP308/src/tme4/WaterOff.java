package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: WaterOff.java
 *
 * purpose: simulates water off event for greenhouse control
 */

public class WaterOff extends Event {
    /**
     * Constructor 
     * @param delayTime - time in milliseconds to delay before executing event
     */
    public WaterOff(long delayTime) {
	super(delayTime);
    }
    /**
     * runs event - prints the event toString to console and updates state var
     */
    public void action() {
	// Put hardware control code here.
	System.out.println(toString());
	GreenhouseControls.setVariable("Water", false);
    }
    /**
     * @return Description of Event
     */
    public String toString() {
	return "Greenhouse water is off";
    }

}