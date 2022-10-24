package edu.sjsu.assignment3;

import java.time.LocalDate;

public class MonthlyAppointment extends Appointment {
    public MonthlyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    @Override
    public boolean occursOn(LocalDate date) {
        boolean is_between = date.isAfter(this.getStartDate()) && date.isBefore(this.getEndDate()) ||
                date.isEqual(this.getStartDate()) || date.isEqual(this.getEndDate());
        return is_between && date.getDayOfMonth() == this.getStartDate().getDayOfMonth();
    }
}
