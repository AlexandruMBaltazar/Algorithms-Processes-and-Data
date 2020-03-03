package resourceManager;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockResourceManager extends BasicResourceManager implements ResourceManager {


    // A reentrant lock for mutual exclusion
    private Lock lock = new ReentrantLock();

    // A queue used to store all priority levels as a condition
    private Condition[] priorityQueue;

    // This boolean value will indicate weather the resource is in use or not
    private boolean resourceUsed = false;




    /**
     * Set the resource and initialise the numbers of waiting processes, and the number of users, to zero.
     *
     * @param resource the resource managed by this manager
     * @param maxUses  the maximum number of uses permitted for this manager's resource.
     */
    public LockResourceManager(Resource resource, int maxUses) {
        super(resource, maxUses);

        priorityQueue = new Condition[NO_OF_PRIORITIES];

         /*
         Creating a condition for each priority level.
         On one of these conditions according to their priority a process will await or notify.
         */
        for (int index = 0; index < NO_OF_PRIORITIES; index++) {
            priorityQueue[index] = lock.newCondition();
        }
    }

    /**
     * Request use of this manager's resource, with the specified priority.
     * If the resource is in use the requesting user will have to wait for the resource to be released.
     * @param priority the priority level at which the resource is being requested.
     * @throws ResourceError if the implementing code throws an InterruptedException error.
     */
    @Override
    public void requestResource(int priority) throws ResourceError {
        lock.lock(); // lock the critical sections
        try{

            /*
                While the resource is in use we are increasing the number of processes waiting at
                that specific priority.
                We also make the process await at the condition assign for its priority.
             */
            while(resourceUsed){
                increaseNumberWaiting(priority);
                priorityQueue[priority].await();
            }

            resourceUsed = true; // Now the resource is in use

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock(); // unlock the critical section
        }
    }

    /**
     * Release this manager's resource.  If any users are waiting for the resource a waiting user with the
     * highest priority should be woken.
     * @return the priority level of the woken process if such exists, NONE_WAITING if not.
     * @throws ResourceError if the implementing code throws an InterruptedException error.
     */
    @Override
    public int releaseResource() throws ResourceError {
        lock.lock(); // lock the critical sections
        int highestPriority = NONE_WAITING;
        try {

            /*
                We want to get the highest priority level where there is process waiting
             */
            for (int index = NO_OF_PRIORITIES; index == 0; index--) {
                if (getNumberWaiting(index) > 0) {
                    highestPriority = index;
                }
            }

            /*
                If this highest priority is not -1 then we actually have a process waiting
                Now we signal a process waiting on a condition at this priority level in the priority queue
             */
            if(highestPriority != NONE_WAITING){
                decreaseNumberWaiting(highestPriority);
                priorityQueue[highestPriority].signal();
            }

            resourceUsed = false; // Resource is not in used now

        } finally {
            lock.unlock(); // Unlock the critical section
        }

        return highestPriority ;
    }
}
