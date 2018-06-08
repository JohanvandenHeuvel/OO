package exercise15;

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
    
    public void enterStation(int nrOfPassengers) {
        nrOfPassengersAtStation += nrOfPassengers;
        totalNrOfPassengers += nrOfPassengers;
        System.out.println(nrOfPassengers + " passengers arrived at station");
    }
    /**
     * Ask for nrOfPassengers Passengers to leave the station
     *
     * @param nrOfPassengers
     */
    public void leaveStation(int nrOfPassengers) {
      if ( nrOfPassengers <= nrOfPassengersAtStation )
        nrOfPassengersAtStation -= nrOfPassengers;
      else
        System.out.println( "leaveStation(" + nrOfPassengers + ") there are only "
            + nrOfPassengersAtStation + " passengers at the station." );
    }

    public int getWaitingPassengers() {
        return nrOfPassengersAtStation;
    }
    
    public void close() {
        isClosed = true;
    }
    
    public boolean isClosed() {
        return isClosed;     
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }
}