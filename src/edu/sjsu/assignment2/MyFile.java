package edu.sjsu.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFile {
    static boolean isPrime(int n)
    {
        int one = 1, two = 2, three = 3;
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void writePrimes(String inFileName, String outFileName) {
        File inFile = new File(inFileName);
        Scanner inScanner = null;
        PrintWriter outFile = null;
        String next;
        int toWrite = 0;

        try {
            inScanner = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.println(inFileName + " was not found.");
            return;
        }

        try {
            outFile = new PrintWriter(outFileName);
        } catch (FileNotFoundException e) {
            System.out.println(outFileName + " was not found.");
            return;
        }

        while(inScanner.hasNextLine()) {
            Scanner lineScanner = new Scanner(inScanner.nextLine());
            lineScanner.useDelimiter(",");
            while (lineScanner.hasNext()) {
                // Get the next value, store in string to be safe
                next = lineScanner.next();

                try {
                    toWrite = Integer.parseInt(next);
                } catch (NumberFormatException e) {
                    continue;
                }

                // If we're here toWrite has an integer in it, if it's prime, write it.
                if(isPrime(toWrite)) {
                    //System.out.println("is a prime");
                    outFile.println(toWrite);
                }
            }
            lineScanner.close();
        }
        inScanner.close();
        outFile.close();
    }
}
