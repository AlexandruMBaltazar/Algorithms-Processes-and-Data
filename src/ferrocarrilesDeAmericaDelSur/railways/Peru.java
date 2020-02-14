package ferrocarrilesDeAmericaDelSur.railways;

import ferrocarrilesDeAmericaDelSur.errors.RailwaySystemError;
import ferrocarrilesDeAmericaDelSur.errors.SetUpError;
import ferrocarrilesDeAmericaDelSur.tools.Clock;
import ferrocarrilesDeAmericaDelSur.tools.Delay;

/**
 * An implementation of a railway.  The runTrain method, should, in collaboration with Bolivia's runTrain(), guarantee
 * safe joint operation of the railways.
 *
 * @author Hugh Osborne
 * @version December 2019
 */
public class Peru extends Railway {
	/**
	 * Change the parameters of the Delay constructor in the call of the superconstructor to
	 * change the behaviour of this railway.
	 * @throws SetUpError if there is an error in setting up the delay.
	 */
	public Peru() throws SetUpError {
		super("Peru",new Delay(0.1,0.3));
	}

    /**
     * Run the train on the railway.
	 * This method currently does not provide any synchronisation to avoid two trains being in the pass at the same time.
     */
    public void runTrain() throws RailwaySystemError {

        Clock clock = getRailwaySystem().getClock();
        Railway bolivia = this.getRailwaySystem().getNextRailway();

        while (!clock.timeOut()) {

            this.choochoo(); //Peru train travel round the safe part of the railway (outside the pass).

            /*
            As soon as the train reaches the pass entrance the engine driver
            puts a stone in his own basket. This means that the Peru train
            wants to cross.
             */
            this.getBasket().putStone();

            /*
            The engine driver check's Bolivia's private basket
            to see if they want to cross as well.
             */
            while (bolivia.getBasket().hasStone()) {

                /*
                The shared basket symbolize the priority.
                If there is no stone in the shared basket then  Bolivia
                train has priority
                 */
                if (!getSharedBasket().hasStone()) {

                    this.getBasket().takeStone();

                    /*
                    Now the train driver will sleep and he will keep checking
                    if he has priority
                     */
                    while (!getSharedBasket().hasStone()) {
                        this.siesta();
                    }

                    this.getBasket().putStone();
                }

            }


            crossPass(); //Peru train is crossing the pass

            this.getBasket().takeStone();

            /*
            The shared basket is emptied giving priority
            to Bolivia's train
             */
            if(getSharedBasket().hasStone()){
                getSharedBasket().takeStone();
            }

        }



    }
}