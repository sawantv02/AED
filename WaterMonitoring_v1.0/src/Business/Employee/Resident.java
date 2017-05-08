/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.Employee.Employee;

/**
 *
 * @author vishakha
 */
public class Resident extends Employee {
  
    private String name;
    private int id;
    private String phoneNumber;
    private static int count = 1;
    private String email;
    private String floor;
    private int apartment;

    public Resident() {
        id = count;
        count++;        
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
  
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    
    @Override
    public String toString() {
        return String.valueOf(getApartment());
    }
    
}
