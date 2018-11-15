package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: LightOff.java
 *
 * purpose: simulates light off event for greenhouse control
 */

public class LightOff extends Event {
    /**
     * Constructor 
     * @param delayTime - time in milliseconds to delay before executing event
     */
    public LightOff(long delayTime) {
	super(delayTime);
    }
    /**
     * runs event - prints the event toString to console and updates state var
     */
    public void action() {
	// Put hardware control code here to
	// physically turn off the light.

	System.out.println(toString());
	GreenhouseControls.setVariable("Light", false);
    }
    /**
     * @return Description of Event
     */
    public String toString() {
	return "Light is off";
    }

}