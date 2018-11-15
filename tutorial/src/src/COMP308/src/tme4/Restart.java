package tme4;

import java.io.File;
import java.util.Scanner;

import tme4.GreenhouseControls.Terminate;

public class Restart extends Event {
	private String eventsFile;

	public Restart(long delayTime, String filename) {
	    super(delayTime);
	    eventsFile = filename;
	}

	public void action() {
	    try (Scanner scan = new Scanner(new File(eventsFile));) {

		while (scan.hasNext()) {
		    String s = scan.nextLine();

		    // parse out event
		    String event = s.split("Event=")[1];
		    event = event.split(",")[0];

		    // parse out time
		    String stringTime = s.split("time=")[1];
		    stringTime = stringTime.split(",")[0];
		    long time = Long.parseLong(stringTime);

		    // parse out ring
		    int rings = 0;
		    if (s.contains("rings")) {
			String r = s.split("rings=")[1];
			rings = Integer.parseInt(r);
		    } // end if rings

		    // run event that is read in
		    if (event.equals("FansOn"))
			addEvent(new FansOn(time));
		    if (event.equals("FansOff"))
			addEvent(new FansOff(time));
		    if (event.equals("LightOn"))
			addEvent(new LightOn(time));
		    if (event.equals("LightOff"))
			addEvent(new LightOff(time));
		    if (event.equals("WaterOn"))
			addEvent(new WaterOn(time));
		    if (event.equals("WaterOff"))
			addEvent(new WaterOff(time));
		    if (event.equals("ThermostatNight"))
			addEvent(new ThermostatNight(time));
		    if (event.equals("ThermostatDay"))
			addEvent(new ThermostatDay(time));
		    if (event.equals("Terminate"))
			addEvent(new Terminate(time));

		    if (event.equals("Bell")) {
			Bell b = new Bell(rings);
			for (int i = 0; i < b.ring; i++) {
			    addEvent(b);
			} // end for b
		    } // end if bell

		    if (event.equals("WindowMalfunction"))
			addEvent(new WindowMalfunction(time));
		    if (event.equals("PowerOut"))
			addEvent(new PowerOut(time));

		} // end while
	    } catch (Exception e) {
		System.out.println(e);
	    }
	}// end action

	public String toString() {
	    return "Restarting system";
	}

	@Override
	public void run() {
	    // TODO Auto-generated method stub
	    
	}
  }// end restart