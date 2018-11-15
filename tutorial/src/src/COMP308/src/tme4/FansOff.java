package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: FansOff.java
 *
 * purpose: simulates Fans off event for greenhouse control
 */
//event class to turn off fans
public class FansOff extends Event {
	/**
	 * FansOff constructor creates event to turn off fan
	 * @param delayTime - time until fan turns off
	 */
	public FansOff(long delayTime) {
	    super(delayTime);
	}
	    /**
	     * runs event - prints the event toString to console and updates state var
	     */
	public void action() {
	    GreenhouseControls.setVariable("Fan",false);
	    System.out.println(toString());
	}
	    /**
	     * @return Description of Event
	     */
	public String toString() {
	    return "Fans are OFF";
	}

}// end FansOff