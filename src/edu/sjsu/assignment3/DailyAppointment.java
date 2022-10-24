package edu.sjsu.assignment3;

import java.time.LocalDate;

public class DailyAppointment extends Appointment {
    public DailyAppointment(String description, LocalDate startDate, LocalDate endDate) {
        super(description, startDate, endDate);
    }

    @Override
    public boolean occursOn(LocalDate date) {
        return date.isAfter(this.getStartDate()) && date.isBefore(this.getEndDate()) ||
                date.isEqual(this.getStartDate()) || date.isEqual(this.getEndDate());
    }
}
