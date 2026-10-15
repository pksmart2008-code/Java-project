import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Fightarrival {

    // CO4 - Class, objects and encapsulation
    static class Flight {
        private String flightNumber;
        private String airline;
        private String destination;
        private String time;
        private String status;

        // CO4 - Constructor
        Flight(String number, String airline, String destination,
               String time, String status) {
            this.flightNumber = number;
            this.airline = airline;
            this.destination = destination;
            this.time = time;
            this.status = status;
        }

        // CO4 - Getter methods
        String getFlightNumber() {
            return flightNumber;
        }

        String getDestination() {
            return destination;
        }

        String getStatus() {
            return status;
        }

        // CO1 - Displaying output
        void displayFlight() {
            System.out.println("----------------------------");
            System.out.println("Flight Number: " + flightNumber);
            System.out.println("Airline: " + airline);
            System.out.println("Destination: " + destination);
            System.out.println("Time: " + time);
            System.out.println("Status: " + status);
        }
    }

    // CO3 - Methods and CO2 - Conditions and loops
    static void showArrivals(ArrayList<Flight> flights) {
        System.out.println("\n===== ARRIVALS =====");

        for (Flight f : flights) {
            if (f.getStatus().equalsIgnoreCase("Arrived") ||
                f.getStatus().equalsIgnoreCase("Delayed")) {
                f.displayFlight();
            }
        }
    }

    // CO3 - Methods and CO2 - Conditions and loops
    static void showDepartures(ArrayList<Flight> flights) {
        System.out.println("\n===== DEPARTURES =====");

        for (Flight f : flights) {
            if (f.getStatus().equalsIgnoreCase("Boarding") ||
                f.getStatus().equalsIgnoreCase("Scheduled")) {
                f.displayFlight();
            }
        }
    }

    // CO3 - Method and searching
    // CO5 - String comparison
    static void searchFlight(ArrayList<Flight> flights, String number) {
        boolean found = false;

        for (Flight f : flights) {
            if (f.getFlightNumber().equalsIgnoreCase(number.trim())) {
                System.out.println("\nFlight Found!");
                f.displayFlight();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Flight not found!");
        }
    }

    // CO3 - Arrays and loops
    static void showDestinations(String[] destinations) {
        System.out.println("\n===== DESTINATIONS =====");

        for (String city : destinations) {
            System.out.println(city);
        }
    }

    // CO5 - Sorting using a library method and lambda expression
    static void sortFlights(ArrayList<Flight> flights) {
        flights.sort((a, b) ->
            a.getFlightNumber().compareToIgnoreCase(
                b.getFlightNumber()));

        System.out.println("\nFlights sorted by flight number:");

        for (Flight f : flights) {
            f.displayFlight();
        }
    }

    // CO5 - File handling and exception handling
    static void saveFlights(ArrayList<Flight> flights) {
        try {
            FileWriter writer = new FileWriter("flights.txt");

            for (Flight f : flights) {
                writer.write(
                    f.getFlightNumber() + " | " +
                    f.getDestination() + " | " +
                    f.getStatus() + "\n"
                );
            }

            writer.close();
            System.out.println("Flight details saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving flight details!");
        }
    }

    // CO6 - Collections, lambda expression and Streams
    static void showStatistics(ArrayList<Flight> flights) {
        long arrived = flights.stream()
            .filter(f -> f.getStatus().equalsIgnoreCase("Arrived"))
            .count();

        long delayed = flights.stream()
            .filter(f -> f.getStatus().equalsIgnoreCase("Delayed"))
            .count();

        System.out.println("\n===== FLIGHT STATISTICS =====");
        System.out.println("Total Flights: " + flights.size());
        System.out.println("Arrived Flights: " + arrived);
        System.out.println("Delayed Flights: " + delayed);
    }

    public static void main(String[] args) {

        // CO1 - Variables and input
        Scanner sc = new Scanner(System.in);

        // CO6 - Collections Framework using ArrayList
        ArrayList<Flight> flights = new ArrayList<>();

        // CO4 - Creating Flight objects using the constructor
        flights.add(new Flight("AI101", "Air India",
            "Hyderabad", "08:30 AM", "Arrived"));
        flights.add(new Flight("6E202", "IndiGo",
            "Mumbai", "09:15 AM", "Boarding"));
        flights.add(new Flight("AI2303", "Air India",
            "Bangalore", "10:00 AM", "Scheduled"));
        flights.add(new Flight("AI404", "Air India",
            "Hyderabad", "11:30 AM", "Delayed"));
        flights.add(new Flight("6E505", "IndiGo",
            "Kolkata", "01:00 PM", "Scheduled"));
        flights.add(new Flight("AK69", "Air Asia",
            "Hyderabad", "11:00 PM", "Scheduled"));
        flights.add(new Flight("SQ423", "Singapore Air",
            "Singapore", "11:00 PM", "Scheduled"));
        flights.add(new Flight("BA287", "British Airways",
            "Melbourne", "11:30 PM", "Scheduled"));
        flights.add(new Flight("EY359", "Qatar Airways",
            "Abu Dhabi", "09:50 PM", "Rescheduled"));
        flights.add(new Flight("6E6302", "IndiGo",
            "Hyderabad", "02:00 AM", "Delayed"));
        flights.add(new Flight("SG2160", "SpiceJet",
            "Jammu", "09:30 AM", "Ontime"));
        flights.add(new Flight("IC3303", "Fly91",
            "Vijayawada", "10:15 AM", "Arrived"));
        flights.add(new Flight("EK527", "Emirates",
            "Dubai", "10:15 AM", "Scheduled"));
        flights.add(new Flight("IX2745", "Air India Express",
            "Goa", "10:40 AM", "Departed"));
        flights.add(new Flight("XY325", "Flynas",
            "Riyadh", "12:35 AM", "Arrived"));
        flights.add(new Flight("6E2171", "IndiGo",
            "Hyderabad", "07:40 AM", "Arrived"));

        // CO3 - Array of destinations
        String[] destinations = {
            "Hyderabad", "Mumbai", "Bangalore", "Kolkata",
            "Singapore", "Melbourne", "Abu Dhabi", "Jammu",
            "Vijayawada", "Dubai", "Goa", "Riyadh"
        };

        int choice = 0;

        // CO2 - Loop and conditional statements
        do {
            System.out.println("\n==============================");
            System.out.println("     FLIGHT TRACKER SYSTEM");
            System.out.println("==============================");
            System.out.println("1. View Arrivals");
            System.out.println("2. View Departures");
            System.out.println("3. Search Flight");
            System.out.println("4. View Destinations");
            System.out.println("5. Sort Flights");
            System.out.println("6. Save Flight Details");
            System.out.println("7. Flight Statistics");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            // CO4 - Exception handling for invalid input
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
                continue;
            }

            // CO2 - Decision making using if-else
            if (choice == 1) {
                showArrivals(flights);

            } else if (choice == 2) {
                showDepartures(flights);

            } else if (choice == 3) {
                System.out.print("Enter flight number: ");
                String number = sc.nextLine();
                searchFlight(flights, number);

            } else if (choice == 4) {
                showDestinations(destinations);

            } else if (choice == 5) {
                sortFlights(flights);

            } else if (choice == 6) {
                saveFlights(flights);

            } else if (choice == 7) {
                showStatistics(flights);

            } else if (choice == 8) {
                System.out.println("Thank you for using Flight Tracker!");

            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
