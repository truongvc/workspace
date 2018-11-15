package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: FansOn.java
 *
 * purpose: simulates Fans ON event for greenhouse control
 */
//event class to turn on fans 
public class FansOn extends Event {
	
	/**
	 * FansOn constructor creates event to turn on fan
	 * @param delayTime - time until fan turns on
	 */
	public FansOn(long delayTime) {
	    super(delayTime);
	}

	/**
	 * runs event - prints the event toString to console and updates state var
	 */
	public void action() {
	    System.out.println(toString());
	    GreenhouseControls.setVariable("Fan",true);
	}
	 /**
	  * @return Description of Event
	  */
	public String toString() {
	    return "Fans are ON";
	}
}// end FansOn
