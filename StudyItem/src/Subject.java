/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lab_services_student
 */
public class Subject {
    private String name;
    private int hours;
    private String status; // "Completed" or "In Progress"

    // Constructor
    public Subject(String name, int hours) {
        this.name = name;
        this.hours = hours;
        this.status = "In Progress"; // default status
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getHours() {
        return hours;
    }

    public String getStatus() {
        return status;
    }

    // Setter method
    public void setStatus(String status) {
        this.status = status;
    }
}


