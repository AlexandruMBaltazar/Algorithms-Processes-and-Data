package processes;
/**
 * One version of the process --- assign x+1 to y.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class Process2 extends Process {
  /**
   * This implementation of {@link Process} assigns x+1 to y.
   */
  public void run() {
    y = x + 1;
  }
}
