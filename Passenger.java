/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flight.booking.system;

/**
 *
 * @author ameera
 */
public abstract class Passenger {
 
    private String name;
    private int age;

    // Constructor
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method for discount
    public abstract double applyDiscount(double price);
}


