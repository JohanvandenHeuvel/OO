package exercise15;

/**
 * Taxi for the Simulation. It takes passengers from the station and keeps basic
 * historical data.
 *
 * @author pieterkoopman
 */
public class Taxi implements Runnable {

    private final int taxiId;
    private final int maxNrOfPassengers;
    private final int transportationTime;
    private final Station station;

    private int totalNrOfPassengers = 0;
    private int nrOfRides = 0;

    public Taxi(int nr, int maxNumberOfPassengers, int transportationTime, Station station) {
        this.taxiId = nr;
        this.maxNrOfPassengers = maxNumberOfPassengers;
        this.transportationTime = transportationTime;
        this.station = station;
        System.out.println("Taxi " + nr + " created");
    }

    /**
     * Try to take the maximum number of passengers from the station. If actual
     * number of passengers is less then that number is taken. When there are no
     * passengers the taxi just waits a little
     */
//    public void takePassengers() {
//        int passengersWaiting = station.getWaitingPassengers();
//        if (passengersWaiting > 0) {
//            int nrOfPassengers = Math.min(passengersWaiting, maxNrOfPassengers);
//            station.leaveStation(nrOfPassengers);
//            totalNrOfPassengers += nrOfPassengers;
//            nrOfRides++;
//            System.out.println("Taxi " + taxiId + " takes " + nrOfPassengers + " passengers");
//        } else {
//            System.out.println("There are no passengers for taxi " + taxiId);
//        }
//    }
    /**
     * Calculates the total time of this taxi by multiplying the number of rides
     * by the transportation time
     *
     * @return total time
     */
    public int getTotalTransportationTime() {
        return transportationTime * nrOfRides;
    }

    public int getTotalNrOfPassengers() {
        return totalNrOfPassengers;
    }

    @Override
    public void run() {
        while(!station.isClosed()){
//            System.out.println("Taxi " + taxiId + " is working");
            int transported = station.leaveStation(maxNrOfPassengers);
            totalNrOfPassengers += transported;
            nrOfRides++;
            System.out.println("Taxi " + taxiId + " takes " + transported + " passengers");
        }
        System.out.println("Taxi " + taxiId + " is done");
    }
}
