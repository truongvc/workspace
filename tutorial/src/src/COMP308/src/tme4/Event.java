//: innerclasses/controller/Event.java
// The common methods for any control event.
// From 'Thinking in Java, 4th ed.' (c) Bruce Eckel 2005
// www.BruceEckel.com. See copyright notice in CopyRight.txt.

/***********************************************************************
 * Adapated for COMP308 Java for Programmer, 
 *		SCIS, Athabasca University
 *
 * Assignment: TME3
 * @author: Steve Leung
 * @date  : Oct. 21, 2006
 *
 * Description: Event abstract class
 *
 */

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
 * purpose: event for greenhouse control
 */

public abstract class Event implements Runnable {
    private long eventTime;
    protected final long delayTime;
    /**
     * Constructor 
     * @param delayTime - time in milliseconds to delay before executing event
     */
    public Event(long delayTime) {
	this.delayTime = delayTime;
	start();	
    }

    /**
     * sets when to start event by adding delay time to current time
     */
    public void start() { // Allows restarting
	eventTime = System.currentTimeMillis() + delayTime;
    }

    /**
     * 
     * @return true if current time is >= eventTime
     */
    public boolean ready() {
	return System.currentTimeMillis() >= eventTime;
    }

    public abstract void action();

    /**
     * runs event
     */
    public void run() {
	try {
	    Thread.sleep(delayTime);
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	action();
	
    }// end run
    
    


} /// :~
