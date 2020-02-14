package ferrocarrilesDeAmericaDelSur.errors;

/**
 * An error has occured that suggests a programming error.
 * E.g. A train is attempting to travel directly from one track segment to a non-neighbouring segment.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class ProgrammingError extends RailwaySystemError {
	public ProgrammingError(String message) {
		super("[Programming error] " + message);
	}
}
	