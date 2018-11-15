package tme4;
/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: April 9, 2018 
 * Version: 1.0
 * 
 * TME Assignment 4 
 * COMP 308 
 * Class: Bell.java
 *
 * purpose: simulates Bell event for greenhouse control
 */

// An example of an action() that inserts a
// new one of itself into the event list:
public class Bell extends Event {
	protected int ring; //holds how many times for bell to ring
	/**
	* Constructor 
	* @param delayTime - time in milliseconds to delay before executing event
	*/
	public Bell(long delay) {
	    super(delay);
		}
	 /**
	  * runs event - prints the event toString to console and updates state var
	  */
	public void action() {

	    System.out.println(toString());
	}

	/**
	* @return Description of Event
	*/
	public String toString() {
	    return "Bing!";
	}

}//end Bell class

