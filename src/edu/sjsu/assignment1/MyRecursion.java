package edu.sjsu.assignment1;

public class MyRecursion {
    public static int _indexOf(String _theWholeString, String _theSubString, int index) {
        // Base case
        if (_theWholeString.substring(index).startsWith(_theSubString)) {
            return index;
        }

        // Recur at the next index
        return _indexOf(_theWholeString, _theSubString, index + 1);
    }
    public static int indexOf(String theWholeString, String theSubString) {
        // Base case
        if (theWholeString.startsWith(theSubString)) {
            return 0;
        }

        // Don't waste time
        if (!theWholeString.contains(theSubString)) {
            return -1;
        }

        // Recur into substring
        return _indexOf(theWholeString, theSubString, 1);
    }
}
