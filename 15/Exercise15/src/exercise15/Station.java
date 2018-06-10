package exercise15;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that holds the number of persons arriving by train at the station and
 * is waiting for a taxi.
 *
 * @author pieterkoopman
 */
public class Station {

    private int nrOfPassengersAtStation = 0;
    private int totalNrOfPassengers = 0;
    private boolean isClosed = false;
    private boolean trainDone = false;

    private Lock myLock = new ReentrantLock();
    private Condition waitingPassengers = myLock.newCondition();

    public void enterStation(int nrOfPassengers) {
        myLock.lock();
        try {
            nrOfPassengersAtStation += nrOfPassengers;
            totalNrOfPassengers += nrOfPassengers;
            System.out.println(nrOfPassengers + " passengers arrived at station");
            waitingPassengers.signalAll();
        } finally {
            myLock.unlock();
        }

    }

    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param maxNrOfPassengers
     */
    public int leaveStation(int maxNrOfPassengers) {
        myLock.lock();
        try {
            int nrOfPassengers = 0;
            while (nrOfPassengersAtStation == 0 && !trainDone) {
                waitingPassengers.await();
            }
            nrOfPassengers = Math.min(nrOfPassengersAtStation, maxNrOfPassengers);
            nrOfPassengersAtStation -= nrOfPassengers;

            if(nrOfPassengersAtStation == 0 && trainDone){
                waitingPassengers.signalAll();
            }
            return nrOfPassengers;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            myLock.unlock();
        }
    }

    public int getWaitingPassengers() {
        return nrOfPassengersAtStation;
    }

    public void close() {
        isClosed = true;
    }
    
    public void trainDone() {
        trainDone = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }
}
