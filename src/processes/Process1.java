package processes;
/**
 * One version of the process --- assign y+1 to x.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class Process1 extends Process {
  /**
   * This implementation of {@link Process} assignes y+1 to x.
   */
  public void run() {
    x = y + 1;
  }
}
