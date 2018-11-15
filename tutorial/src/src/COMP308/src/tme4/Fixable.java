/**
 * @author: Victor Truong 
 * Student ID: 2713060 
 * Date: March 26, 2018
 * Version: 1.0
 * 
 * TME Assignment 3 
 * COMP 308
 * Class: Fixable.java
 *
 * Purpose: interface for fixable errors 
 * 
 */
package tme4;

public interface Fixable {

    //turns power on, fix windows and zeros out error codes
    
    void fix();
    
    //logs to a text file in the current directory called fix.log
    
    //prints to the console, and id the time and nature of the fix
 
    void log();
    
}
