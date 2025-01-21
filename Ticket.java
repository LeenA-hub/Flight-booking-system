/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight.booking.system;

/**
 *
 * @author ameera
 */
public class Ticket {
    private Passenger passenger;
    private flight flight;
    private double price;
    private static int number = 0;
    private int ticketNumber;
   
    private static int ticketCounter = 1;

    public Ticket(Passenger passenger, flight flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.number = ticketCounter++;
    }

    // Getters and Setters
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public flight getFlight() {
        return flight;
    }

    public void setFlight(flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    // Override toString method
    @Override
    public String toString() {
        return passenger.getName() + ", " + flight.toString() + ", ticket price: $" + price;
    }
}


