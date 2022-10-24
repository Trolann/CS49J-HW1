package edu.sjsu.assignment3;

import java.util.Comparator;

public class DesComparator implements Comparator<Appointment> {

    @Override
    public int compare(Appointment o1, Appointment o2) {
        if (o1.getDescription().compareTo(o2.getDescription()) != 0) {
            return o1.getDescription().compareTo(o2.getDescription());
        }
        if (o1.getStartDate().compareTo(o2.getStartDate()) != 0) {
            return o1.getStartDate().compareTo(o2.getStartDate());
        }
        return o1.getEndDate().compareTo(o2.getEndDate());
    }
}
