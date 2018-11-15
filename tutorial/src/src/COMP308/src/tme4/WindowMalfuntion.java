package tme4;

import java.util.HashMap;

import tme4.GreenhouseControls.ControllerException;

//window malfunction event class
public class WindowMalfunction extends Event {
	private boolean windowOk;
	private int errorCode;
	HashMap<String, Object> map;
	/**
	 * simulates window malfunction
	 * @param delayTime - time from start to execute event
	 */
	public WindowMalfunction(long delayTime, HashMap<String, Object> map) {
	    super(delayTime, map);
	}//end constructor

	/**
	 * invokes a window malfunction event
	 */
	public void action() {
	    windowOk = false; //change windowOk status to indicate error
	    errorCode = 1; //set error code 
	    try {//throw ControllerException error
		throw new ControllerException("Error - Window Malfunction");
	    } catch (ControllerException e) {
		shutdown();//shutdown system after error
	    }//end catch
	}// end action

	public String toString() {
	    return "ERROR: Window Malfunction";
	}

	@Override
	public void run() {
	    // TODO Auto-generated method stub
	    
	}
}