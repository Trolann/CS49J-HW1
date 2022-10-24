package edu.sjsu.assignment1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;



class MyTimeTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void normal_inputs() {
        MyTime.printTimeDifference("0100", "0300");
        assertEquals("2 hour(s) 0 minute(s)", outputStreamCaptor.toString().trim());
    }

    @Test
    void first_time_later() {
        MyTime.printTimeDifference("0400", "0300");
        assertEquals("23 hour(s) 0 minute(s)", outputStreamCaptor.toString().trim());
    }
    @Test
    void inputs_with_whitespace() {
        MyTime.printTimeDifference(" 0 1 0 0 ", " 0 3 0 0 ");
        assertEquals("2 hour(s) 0 minute(s)", outputStreamCaptor.toString().trim());
    }
    @Test
    void inputs_with_text() {
        MyTime.printTimeDifference("0100hrs", "0300hrs");
        assertEquals("2 hour(s) 0 minute(s)", outputStreamCaptor.toString().trim());
    }
    @Test
    void zeros_for_inputs() {
        MyTime.printTimeDifference("0100", "0100");
        assertEquals("0 hour(s) 0 minute(s)", outputStreamCaptor.toString().trim());
    }
    @Test
    void just_strings() {
        MyTime.printTimeDifference("Zero one hundred", "zero dark thirty");
        assertEquals("Invalid input for Zero one hundred or zero dark thirty", outputStreamCaptor.toString().trim());
    }

    @Test
    void large_numbers() {
        MyTime.printTimeDifference("525,600", "281-330-8004");
        assertEquals("Invalid input for 525,600 or 281-330-8004", outputStreamCaptor.toString().trim());
    }
    @Test
    void negative_numbers_good() {
        MyTime.printTimeDifference("-1500", "1600");
        assertEquals("25 hour(s) 0 minute(s)", outputStreamCaptor.toString().trim());
    }
    @Test
    void negative_numbers_bad() {
        MyTime.printTimeDifference("-1500", "-1600");
        assertEquals("Invalid input for -1500 or -1600", outputStreamCaptor.toString().trim());
    }
    @Test
    void last_two_over_sixty() {
        MyTime.printTimeDifference("-1500", "-1699");
        assertEquals("Invalid input for -1500 or -1699", outputStreamCaptor.toString().trim());
    }
    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
}