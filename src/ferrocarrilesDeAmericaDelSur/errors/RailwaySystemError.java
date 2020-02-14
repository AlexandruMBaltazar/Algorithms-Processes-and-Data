package ferrocarrilesDeAmericaDelSur.errors;

/**
 * A general class of errors for railway systems.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class RailwaySystemError extends Exception {
	public RailwaySystemError(String message) {
		super(message);
	}
}
