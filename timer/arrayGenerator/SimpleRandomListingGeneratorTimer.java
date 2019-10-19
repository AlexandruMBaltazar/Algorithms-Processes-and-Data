package arrayGenerator;

import timer.Timer;

/**
 * A timer implementation for simple random listing generators that times the randomise method.
 *
 * @author Hugh Osborne
 * @version September 2018
 */

public class SimpleRandomListingGeneratorTimer extends SimpleRandomListingGenerator implements Timer {

    private SimpleRandomListingGeneratorTimer(int size) {
        super(size);
    }

    /**
     * We are testing SimpleRandomListingGenerators.
     *
     * @param size the size of the task to be timed.
     * @return a SimpleRandomListingGenerator of the required size.
     */
    @Override
    public Timer getTimer(int size) {
        return new SimpleRandomListingGeneratorTimer(size);
    }

    /**
     * We are timing the randomise() method.
     */
    @Override
    public void timedMethod() {
        randomise();
    }

    /**
     * Cease timing when the runtime exceeds 5 seconds.
     *
     * @return 5 seconds as the maximum runtime.
     */
    @Override
    public long getMaximumRuntime() {
        return 5;
    }

    /**
     * Start timing with an array size of 1.
     *
     * @return 1 as the initial array size.
     */
    @Override
    public int getMinimumTaskSize() {
        return 1;
    }

    /**
     * Cease timing when the array size passes 10^9.
     *
     * @return 10^9 as the maximum array size.
     */
    @Override
    public int getMaximumTaskSize() {
        return 1000000000;
    }

    /**
     * Run the sequence of timings specified by the methods above.
     * @param args usually ignored.
     */
    public static void main(String[] args) {
        SimpleRandomListingGeneratorTimer timer = new SimpleRandomListingGeneratorTimer(0);
        timer.timingSequence();
    }
}
