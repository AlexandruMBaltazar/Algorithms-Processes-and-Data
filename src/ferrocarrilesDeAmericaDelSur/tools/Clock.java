package ferrocarrilesDeAmericaDelSur.tools;

import ferrocarrilesDeAmericaDelSur.errors.SetUpError;
import ferrocarrilesDeAmericaDelSur.railways.Railway;
import ferrocarrilesDeAmericaDelSur.railways.RailwaySystem;


/**
 * Provides a clock system for railways, which will set an alarm that goes off after a certain number of ticks.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class Clock extends Thread {
    /**
     * True iff this clock's alarm has gone off.
     */
	private boolean timeOut;
    /**
     * The time interval between successive ticks of this clock.
     */
	private int tickTime;
    /**
     * The number of ticks of the clock before the alarm goes off.
     */
	private int ticks;

    /**
     * The railway system this clock belongs to.
     */
	private RailwaySystem railwaySystem;
	
	/**
	 * The parameters specify the timing for this clock.
	 * @param tickTime the time, in seconds, between successive ticks on this clock.
	 * @param ticks the number of ticks before the alarm should go off.
	 * @throws SetUpError if a negative tick time, or negative number of ticks is specified.
	 */
	
	public Clock(double tickTime, int ticks) throws SetUpError {
		if (tickTime < 0) {
			throw new SetUpError("A tick time on a clock must be a positive number");
		}
		this.tickTime = (int) (tickTime * 1000);
		if (ticks < 0) {
			throw new SetUpError("The number of ticks on the clock must be positive.");
		}
		this.ticks = ticks;
	}
	
	/**
	 * Register this clock with a railway system.
	 * @param railwaySystem the railway system this clock is to be registered with.
	 */
	public void register(RailwaySystem railwaySystem) {
		this.railwaySystem = railwaySystem;
	}
    
    /**
     * Has the alarm gone off for this clock?
     * @return true iff the alarm has gone off.
     */
    public synchronized boolean timeOut() {
		return timeOut;
	}
	
    /**
     * Run this clock.  Run for the specified number of ticks, then set the alarm off.  At each tick, check whether an
     * error has occurred in the railway system.  If so stop the clock.
     */
	public void run() {
		timeOut = false;
		try {
			for (int tick = 0; tick < ticks; tick++) {
				if (Railway.errorOccurred()) {
					railwaySystem.trace("\t\t\t\t\t\tClock: emergency stop");
					break;
				}
				railwaySystem.trace("\t\t\t\t\t\tClock: tick tock");
				sleep(tickTime);
			}
		} catch (InterruptedException interrupt) {}
		timeOut = true;
		railwaySystem.trace("\t\t\t\t\t\tClock: brrrrring!");
	}
}

    

