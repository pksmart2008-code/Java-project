import java.util.Scanner;

public class Fightarrival {

    static class Flight { 
        String flightNumber;                             // CO1
        String airline;
        String destination;
        String time;
        String status;

    
        Flight(String flightNumber, String airline, String destination,
               String time, String status) {
            this.flightNumber = flightNumber;
            this.airline = airline;
            this.destination = destination;
            this.time = time;
            this.status = status;
        }

        
        void displayFlight() {
            System.out.println("----------------------------------");
            System.out.println("Flight Number : " + flightNumber);
            System.out.println("Airline       : " + airline);
            System.out.println("Destination   : " + destination);
            System.out.println("Time          : " + time);
            System.out.println("Status        : " + status);
        }
    }

    static void showArrivals(Flight[] flights) {
        System.out.println("\n===== ARRIVALS =====");

        for (Flight f : flights) {
            if (f.status.equalsIgnoreCase("Arrived") ||
                f.status.equalsIgnoreCase("Delayed")) {
                f.displayFlight();
            }
        }
    }

    static void showDepartures(Flight[] flights) {
        System.out.println("\n===== DEPARTURES =====");

        for (Flight f : flights) {
            if (f.status.equalsIgnoreCase("Boarding") ||
                f.status.equalsIgnoreCase("Scheduled")) {
                f.displayFlight();
            }
        }
    }

    static void searchFlight(Flight[] flights, String number) {
        boolean found = false;

        for (Flight f : flights) {
            if (f.flightNumber.equalsIgnoreCase(number)) {
                System.out.println("\n===== FLIGHT FOUND =====");
                f.displayFlight();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Flight not found!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

                                               // co 3 
        Flight[] flights = {              
            new Flight("AI101", "Air India", "Hyderabad", "08:30 AM", "Arrived"),
            new Flight("6E202", "IndiGo", "Mumbai", "09:15 AM", "Boarding"),
            new Flight("AI2303", "Air India  ", "Bangalore", "10:00 AM", "Scheduled"),
            new Flight("AI404", "Air India", "Hyderabad", "11:30 AM", "Delayed"),
            new Flight("6E505", "IndiGo", "Kolkata", "01:00 PM", "Scheduled"),
            new Flight("AK69", "AIR ASIA", "Hyderabad", "11:00 PM", "Scheduled"),
            new Flight("SQ423", "SINGAPORE AIR ", "Singapore", "11:00 PM", "Scheduled"),
            new Flight("BA287", "British Airways", "Melbourne", "11:30 PM", "Scheduled"),
            new Flight("EY359", "Quatar Airways", "Abu Dhabi", "9:50 PM", "Rescheduled"),
            new Flight("6E6302", "Indigo", "Hyderabad", " 2:00 AM", "Delayed"),
            new Flight("SG2160", "Spice Jet", "Jammu", " 9:30 AM", "Ontime"),
            new Flight("IC3303", "Fly 91", "Vijayawada", " 10:15 AM", "Arrived"),
            new Flight("ek527", "Emirates", "Dubai", " 10:15am ", "Scheduled "),
            new Flight("IX2745", "Air India Express", "Goa", " 10:40 AM", "Departed"),
            new Flight("XY325", "Flynas", "Riyadh", " 12:35 am", "Arrived"),
            new Flight("6E2171", "Indigo", "Hyderabad", " 7:40 am", "Arrived"),




        };

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("     FLIGHT TRACKER SYSTEM");
            System.out.println("================================");
            System.out.println("1. View Arrivals");
            System.out.println("2. View Departures");
            System.out.println("3. Search Flight");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {                       //co 2 
                showArrivals(flights);

            } else if (choice == 2) {
                showDepartures(flights);

            } else if (choice == 3) {
                System.out.print("Enter Flight Number: ");
                String number = sc.nextLine();

                searchFlight(flights, number);

            } else if (choice == 4) {
                System.out.println("Thank you for using Flight Tracker!");

            } else {
                System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}
