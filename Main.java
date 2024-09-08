import java.util.*;

import CheapestFlightsWithKStops787.CheapestFlightsWithKStops;

public class Main {
        public static void main(String[] args) {
                var flights = new CheapestFlightsWithKStops();
                System.out.println(flights.findCheapestPrice(4,
                                new int[][] { { 0, 1, 1 }, { 0, 2, 3 }, { 1, 2, 1 }, { 2, 3, 1 }, },
                                0, 3, 1));

        }
}
