package processes;

/**
 * Define a process with two shared variables.
 * This class is abstract because it does not implement
 * run.
 * <p>
 * This abstract class has two implementations, {@link Process1} and {@link Process2}.  They each make different
 * assignments to the shared variables x and y.
 * </p>
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public abstract class Process extends Thread {

	/**
	 * <tt>x</tt> and <tt>y</tt> are shared variables.
	 */
	protected static int x = 0, y=2;

	/**
	 * Get x's value.
	 * @return the value of the shared variable x.
	 */
	public static int getX() {
		return x;
	}

	/**
	 * Get y's value.
	 * @return the value of the shared variable x.
	 */
	public static int getY() {
		return y;
	}
}
