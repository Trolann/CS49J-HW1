package edu.sjsu.assignment1;

import java.util.Scanner;

public class AssignmentOneMain {
    class Sample implements Comparable<Sample> {
        private int privateInt;

        @Override
        public int compareTo(Sample s) {
            if (s.getInt() != privateInt)
        }
        public Sample(int first){
            privateInt = first;
        }
        public void sayHello(){
            System.out.println("Hello");
        }
        public void getInt(){
            System.out.printf(Integer.toString(privateInt));
        }

    }
    public static void main(String[] args) {
            Sample trevor = new Sample() {
                @Override
                public void sayHello() {
                    System.out.println("Howzit?");
                }
        }


    }
}
