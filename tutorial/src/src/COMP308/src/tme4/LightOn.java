package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: LightOn.java
 *
 * purpose: simulates Light on event for greenhouse control
 */

public class LightOn extends Event {
    /**
     * Constructor 
     * @param delayTime - time in milliseconds to delay before executing event
     */
    public LightOn(long delayTime) {
	super(delayTime);
    }
    /**
     * runs event - prints the event toString to console and updates state var
     */
    public void action() {
	GreenhouseControls.setVariable("Light", true);
	System.out.println(toString());
    }
    /**
     * @return Description of Event
     */
    public String toString() {
	return "Light is on";
    }

}