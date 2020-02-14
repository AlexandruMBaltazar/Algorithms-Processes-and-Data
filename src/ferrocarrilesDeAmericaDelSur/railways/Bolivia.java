package ferrocarrilesDeAmericaDelSur.railways;

import ferrocarrilesDeAmericaDelSur.errors.RailwaySystemError;
import ferrocarrilesDeAmericaDelSur.errors.SetUpError;
import ferrocarrilesDeAmericaDelSur.tools.Clock;
import ferrocarrilesDeAmericaDelSur.tools.Delay;

import java.awt.font.TextHitInfo;

/**
 * An implementation of a railway.  The runTrain method, should, in collaboration with Peru's runTrain(), guarantee
 * safe joint operation of the railways.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class Bolivia extends Railway {
	/**
     * Change the parameters of the Delay constructor in the call of the superconstructor to
	 * change the behaviour of this railway.
	 * @throws SetUpError if there is an error in setting up the delay.
	 */
	public Bolivia() throws SetUpError {
		super("Bolivia",new Delay(0.1,0.3));
	}

    /**
     * Run the train on the railway.
     * This method currently does not provide any synchronisation to avoid two trains being in the pass at the same time.
     */
    public void runTrain() throws RailwaySystemError {
		Clock clock = getRailwaySystem().getClock();
		Railway peru = this.getRailwaySystem().getNextRailway();

		while (!clock.timeOut()) {

			this.choochoo(); //Bolivia train travel round the safe part of the railway (outside the pass).

			 /*
            As soon as the train reaches the pass entrance the engine driver
            puts a stone in his own basket. This means that the Bolivia train
            wants to cross.
             */
			this.getBasket().putStone();

			/*
            The engine driver check's Peru's private basket
            to see if they want to cross as well.
             */
			while (peru.getBasket().hasStone()) {

				 /*
                The shared basket symbolize the priority.
                If there is a stone in the shared basket then Peru
                train has priority
                 */
				if (getSharedBasket().hasStone()) {
					this.getBasket().takeStone();

					 /*
                    Now the train driver will sleep and he will keep checking
                    if he has priority
                     */
					while (getSharedBasket().hasStone()) {
						this.siesta();
					}

					this.getBasket().putStone();
				}
			}

			crossPass();
			this.getBasket().takeStone();

			 /*
            The shared basket is empty and a stone is put
            giving priority to Peru's train
             */
			getSharedBasket().putStone();

		}
    }
}