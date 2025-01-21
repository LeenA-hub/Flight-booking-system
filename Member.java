/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight.booking.system;

/**
 *
 * @author ameera
 */

public class Member extends Passenger {
    private int yearsOfMembership;

    // Constructor
    public Member(String name, int age, int yearsOfMembership) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }

    // Getter and Setter
    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    // Override applyDiscount method
    @Override
    public double applyDiscount(double price) {
        if (yearsOfMembership > 5) {
            return price * 0.5;
        } else if (yearsOfMembership > 1) {
            return price * 0.9;
        } else {
            return price;
        }
    }
}


