package edu.sjsu.assignment1;

public class MyTime {
    public static void printTimeDifference(String time1, String time2) {
        // A valid in put is a 4 integer string where the integer is < 2400 (0000 - 2359)
        boolean time1Negative = time1.startsWith("-");

        int time1AsANumber = 2400;
        int time2AsANumber = 2400;

        time1AsANumber = Integer.parseInt(time1.replaceAll("[^0-9]",""));
        int time1Length = time1.replaceAll("[^0-9]","").length();
        time2AsANumber = Integer.parseInt(time2.replaceAll("[^0-9]",""));
        int time2Length = time2.replaceAll("[^0-9]","").length();

        if (time1AsANumber > 2359 || time2AsANumber > 2359
                || time2.startsWith("-")
                || time1AsANumber % 100 > 59 || time2AsANumber % 100 > 59
                || time1Length > 4 || time2Length > 4
                || time1Length < 3 || time2Length < 3) {
            System.out.println("Invalid input for " + time1 + " or " + time2);
            return;
        }

        int time1_minutes = ((time1AsANumber / 100) * 60) + (time1AsANumber % 100);
        int time2_minutes = ((time2AsANumber / 100) * 60) + (time2AsANumber % 100);


        if (time1_minutes > time2_minutes || time1Negative) {
            time2_minutes += (60 * 24); // Add a day to this time
        }

        int delta_minutes = time2_minutes - time1_minutes;
        String return_hours = Integer.toString(delta_minutes / 60);
        String return_minutes = Integer.toString(delta_minutes  % 60);
        String output = return_hours + " hour(s) " + return_minutes + " minute(s)";
        System.out.println(output);
    }
}
