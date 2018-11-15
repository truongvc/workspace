package tme4;

import java.util.HashMap;

import tme4.GreenhouseControls.ControllerException;

// power out event class
public class PowerOut extends Event {
	private boolean powerOn;
	private int errorCode;
	HashMap<String, Object> map;
	/**
	 * simulates power outage
	 * @param delayTime - time from start to execute event
	 */
	public PowerOut(long delayTime,HashMap<String, Object> map) {
	    super(delayTime,map);
	}//end constructor
	
	/**
	 * invokes a powerOut event
	 */
	public void action() {
	    powerOn = false; //change powerOut status to indicate error
	    errorCode = 2; //set error code 
	    try {//throw ControllerException error
		throw new ControllerException("Error - Power Outage");
	    } catch (ControllerException e) {
		shutdown();//shutdown system after error
	    }//end catch
	    System.out.println(toString());
	}//end action

	public String toString() {
	    return "Power Out";
	}

}