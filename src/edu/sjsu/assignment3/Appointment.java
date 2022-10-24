package edu.sjsu.assignment3;

import java.time.LocalDate;

public abstract class Appointment implements Comparable<Appointment> {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Appointment(String description, LocalDate startDate, LocalDate endDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public int compareTo(Appointment appointment) {
        if (!this.getStartDate().equals(appointment.getStartDate())) {
            return this.getStartDate().compareTo(appointment.getStartDate());
        }
        if (!this.getEndDate().equals(appointment.getEndDate())) {
            return this.getEndDate().compareTo(appointment.getEndDate());
        }
        return this.getDescription().compareTo(appointment.getDescription());
    }

    // Abstract method, must be overridden
    public abstract boolean occursOn(LocalDate date);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
