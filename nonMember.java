/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight.booking.system;

/**
 *
 * @author ameera
 */
public class nonMember extends Passenger {

    // Constructor
    public nonMember(String name, int age) {
        super(name, age);
    }

    // Override applyDiscount method
    @Override
    public double applyDiscount(double price) {
        if (getAge() > 65) {
            return price * 0.9;
        } else {
            return price;
        }
    }
}


