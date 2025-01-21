/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight.booking.system;

/**
 *
 * @author ameera
 */
import java.util.ArrayList;
import java.util.Scanner;

public class manager {
 
    private ArrayList<flight> flights = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    // Method to create flights
    public void createFlights() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of flights to create:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter flight details (number, origin, destination, departure time, capacity, price):");
            int flightNumber = scanner.nextInt();
            String origin = scanner.next();
            String destination = scanner.next();
            String departureTime = scanner.next();
            int capacity = scanner.nextInt();
            double price = scanner.nextDouble();

            flights.add(new flight(flightNumber, origin, destination, departureTime, capacity, price));
        }
    }

    // Display available flights
    public void displayAvailableFlights(String origin, String destination) {
        for (flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getNumberOfSeatsLeft() > 0) {
                System.out.println(flight);
            }
        }
    }

    // Get a flight by flight number
    public flight getFlight(int flightNumber) {
        for (flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }
        return null;
    }

    // Book a seat
    public void bookSeat(int flightNumber, Passenger passenger) {
        flight flight = getFlight(flightNumber);
        if (flight != null && flight.bookASeat()) {
            double discountedPrice = passenger.applyDiscount(flight.getOriginalPrice());
            Ticket ticket = new Ticket(passenger, flight, discountedPrice);
            tickets.add(ticket);
            System.out.println("Booking successful: " + ticket);
        } else {
            System.out.println("Booking failed. Flight is full or does not exist.");
        }
    }

    // Main method to test
    public static void main(String[] args) {
        manager manager = new manager();
        manager.createFlights();
        manager.displayAvailableFlights("Toronto", "Kolkata");
        Passenger member = new Member("Julia Chow", 30, 6);
        manager.bookSeat(1030, member);
    }
}

