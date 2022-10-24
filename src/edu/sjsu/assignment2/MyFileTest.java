package edu.sjsu.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyFileTest {

    @Test
    void isPrime() {
        int isItPrime = 3;
        assertTrue(MyFile.isPrime(isItPrime));
    }

}