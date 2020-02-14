package ferrocarrilesDeAmericaDelSur.tools;

import ferrocarrilesDeAmericaDelSur.errors.SetUpError;

import java.util.Random;


/**
 * Provides methods for slowing down railway systems.
 *
 * @author Hugh Osborne
 * @version December 2019
 */

public class Delay {
	/**
	 * Time fields specifying the minimum and maximum delay in milliseconds.
	 */
	private int minimumDelay, maximumDelay;

	/**
	 * Generates random delays between the minimum and maximum delay.
	 */
	private Random random = new Random();
	
	/**
	 * The parameters specify the timing for this delay.  All times are in seconds.
	 * @param minimumDelay minimum delay to be returned by the delay() method.
	 * @param maximumDelay maximum delay to be returned by the delay() method.
	 * @throws SetUpError if either delay is negative, or if the maximum delay is less than the minimum.
	 */
	
	public Delay(double minimumDelay,double maximumDelay) throws SetUpError {
		if (minimumDelay < 0 || maximumDelay < 0) {
			throw new SetUpError("A delay must be a positive number");
		} else if (maximumDelay <= minimumDelay) {
			throw new SetUpError("The maximum delay for a clock must be more than its minimum delay");
		}
		this.minimumDelay = (int) (minimumDelay * 1000);
		this.maximumDelay = (int) (maximumDelay * 1000);
	}
	
	/**
	 * The parameter specifies the timing for this delay.  All times are in seconds.
	 * @param maximumDelay maximum delay to be returned by the delay() method.
	 * The minimum delay is set to zero.
	 * @throws SetUpError if the maximum delay is negative.
	 */
	
	public Delay(double maximumDelay) throws SetUpError {
		this(0.0,maximumDelay);
	}
	
	/**
	 * Calling thread sleeps for a random time specified by the delay parameters
	 **/
	public void delay() {
		try {
			Thread.sleep(minimumDelay + random.nextInt(maximumDelay-minimumDelay));
		} catch (InterruptedException ie) {}
	}

}
