package exercise15;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * main Class: create a Simulation and execute it.
 *
 * @author pieterkoopman
 */
public class OOTaxiMain {

    /**
     * Constants for the size of the simulation
     */
    public static final int TRAIN_TRIPS = 10;
    public static final int MIN_TRAVELLERS = 60;
    public static final int MAX_TRAVELLERS = 90;
    public static final int CAPACITY_SMALL = 4;
    public static final int CAPACITY_LARGE = 7;
    public static final int TIME_SMALL = 2;
    public static final int TIME_LARGE = 3;
    public static final int NR_OF_TAXIS = 4;
    public static final int NR_OF_SMALL_TAXIS = 2;

    /**
     * main elements of the simulation
     */
    private static Taxi[] taxis;
    private static Train train;
    private static Station station;

    public static void main(String[] args) {
        station = new Station();
        taxis = new Taxi[NR_OF_TAXIS];
        for (int i = 0; i < NR_OF_TAXIS; i++) {
            taxis[i] = i < NR_OF_SMALL_TAXIS
                    ? new Taxi(i + 1, CAPACITY_SMALL, TIME_SMALL, station)
                    : new Taxi(i + 1, CAPACITY_LARGE, TIME_LARGE, station);
        }
        train = new Train(station);

        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(train);
        
        for (Taxi taxi : taxis) {
            executor.execute(taxi);
        }
        
        while(!executor.isShutdown()){
            if (station.getWaitingPassengers() == 0 && train.getNrOfTrips() == TRAIN_TRIPS) {
                System.out.println("shutting down");
                executor.shutdown();
                train.closeStation();
                showStatistics();
            }
        }
    }

    public static void showStatistics() {
        System.out.println("All persons have been transported");
        System.out.println("Total transport time in this simulation:" + getTotalTime(taxis));
        System.out.println("Total number of train travelers: " + station.getTotalNrOfPassengers());
        System.out.println("Total number of persons transported in this simulation: " + getTotalNrOfPassengers(taxis));
    }

    /**
     * Calculates the total time of the simulation by looping over all taxis
     *
     * @param taxis
     * @return total time
     */
    private static int getTotalTime(Taxi[] taxis) {
        int time = 0;
        for (Taxi taxi : taxis) {
            time += taxi.getTotalTransportationTime();
        }
        return time;
    }

    /**
     * Calculates the total number of passengers that has been transported by
     * looping over all taxis
     *
     * @param taxis
     * @return total number of passengers
     */
    private static int getTotalNrOfPassengers(Taxi[] taxis) {
        int total = 0;
        for (Taxi taxi : taxis) {
            total += taxi.getTotalNrOfPassengers();
        }
        return total;
    }

}
