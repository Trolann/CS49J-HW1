package edu.sjsu.assignment1;

import javax.sound.midi.SysexMessage;

public class Card {
    private final String unknownValue = "Unknown";
    private String description = unknownValue; // If the given string is in the wrong format, this will be unchanged

    public Card(String cardShorthand) {
        boolean badInput = false;

        int numberOfCharacters = cardShorthand.length();
        if((numberOfCharacters == 3 && cardShorthand.charAt(0) != '1')
        || numberOfCharacters == 2 && cardShorthand.charAt(0) == '0') {
            badInput = true;
        }

        if(numberOfCharacters > 1 && !badInput) {
            // Determine the suit
            String cardSuit = switch (cardShorthand.charAt(numberOfCharacters - 1)) {
                case 'D' -> "Diamonds";
                case 'H' -> "Hearts";
                case 'S' -> "Spades";
                case 'C' -> "Clubs";
                default -> unknownValue;
            };

            // Determine the rank
            String cardRank = switch (cardShorthand.charAt(numberOfCharacters - 2)) {
                case '0' -> "Ten";
                case '1' -> "One";
                case '2' -> "Two";
                case '3' -> "Three";
                case '4' -> "Four";
                case '5' -> "Five";
                case '6' -> "Six";
                case '7' -> "Seven";
                case '8' -> "Eight";
                case '9' -> "Nine";
                case 'A' -> "Ace";
                case 'J' -> "Jack";
                case 'Q' -> "Queen";
                case 'K' -> "King";
                default -> unknownValue;
            };

            // Update description
            if (!cardRank.equals(unknownValue) && !cardSuit.equals(unknownValue)) { // If neither is unknown, the input was good.
                this.description = cardRank + " of " + cardSuit;
            }
        }
    }

    // Simple getter
    public String getDescription() {
        return this.description;
    }
}
