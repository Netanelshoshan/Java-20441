/**
 * @author Netanel shoshan
 * 30.01.2020
 *
 * Maman 14
 */

public class Ex14 {

    /**
     * This method will return the number of substrings that start and end with the same
     * char and ALSO has one in the middle. (it's (n-2) problem).
     * Time Complexity: O(n).
     * Space Complexity O(n).
     *
     * @param s get's the string
     * @param c get's the character
     * @return returns the number of substrings that start,end and have one in the middle.
     */
    public static int subStrC(String s, char c) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                counter++;
        }

        if (counter > 2)
            return counter - 2;
        return 0;
    } // end of suvStrC

    /**
     * This method will return the number of substrings that start and end with the same
     * char and has maximum K constants.
     * <p>
     * Time complexity O(n).
     * Space complexity O(1).
     *
     * @param s the string .
     * @param c the character.
     * @param k the max Constants of char can be repeated in the string.
     * @return how many substring can be from the parameters.
     */
    public static int subStrMaxC(String s, char c, int k) {
        int total = 0; // times the char appears.
        int tss = 0; // total subs.

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                total++;
        }
        if (total < 2) // if there isn't a string that fulfill the condition.
            return 0;

        while (k >= 0) {
            if (k < total)
                tss = tss + (total - (k + 1)); // the number of substrings with max K constants.
            k--;
        }
        return tss;
    }// end of subStrMaxC

    /**
     * This method will replace the values of the indexes by ascending and descending order to the nearest 0.
     * Will replace the index values with 1 without overriding the zero,
     * When zero has been reached, will reset the "counter". and so on..
     * Time complexity : O(n)
     * Space complexity : O(1)
     *
     * @param a Gets the array to sort.
     */
    public static void zeroDistance(int[] a) {
        int i = 0, counter = 0;
        //sorting from right to left
        while (i < a.length) {
            if (a[i] != 0 && a[counter] == 0)// if counter is 0, and a[i] is '1'
                a[i] = i - counter;
            else if (a[i] == 0 && a[counter] != 0) { //if counter > 0 and a[i] is '0'
                a[counter] = i - counter;
                counter++;
                i--;
            } else if (a[i] == 0)// reset the counter.
                counter = i;
            i++;
        }

        //sorting from left to right
        i = a.length - 1;
        counter = a.length - 1;
        while (i >= 0) {
            if (a[i] != 0 && a[counter] == 0) { //if a[i] != 0 and a[counter(the previous ind)] is zero
                int tmp = counter - i;
                if (tmp < a[i])
                    a[i] = tmp;
                // here we assign the index number to counter so we could change the values later on in ascending order
            } else if (a[i] == 0)
                counter = i;
            i--;
        }
    } //end of zeroDistance method.

    /**
     * This method will evaluate if the "t" string had a transformation from the "s" string by the given rules:
     * 1. each character in "s" should appear at LEAST one time in "t".
     * 2. should be in the same order.
     * 3. if there's k times the char "A" in "s" , "A" should appear at least k times in "t".
     *
     * @param s the source string.
     * @param t the string to check.
     * @return true if all the condition are met, false otherwise.
     */
    public static boolean isTrans(String s, String t) {
        return isTrans(s, t, 0, 0);

    }

    //overload
    private static boolean isTrans(String s, String t, int i, int j) {
        //If both strings reached the end return true
        if (i == s.length() && j == t.length())
            return true;

        //If only one string has reached the end, -> return false.
        if (i == s.length() && j < t.length())
            return false;

        //If only one string has reached the end, -> return false.
        if (i < s.length() && j == t.length())
            return false;

        //If current chars do not match, return false
        if (s.charAt(i) != t.charAt(j))
            return false;

        // Try both strategies
        return isTrans(s, t, i + 1, j + 1) || isTrans(s, t, i, j + 1);
    }//end if isTrans Method

    /**
     * This method will count the number of paths the matrix to exit the matrix by the given rules:
     * 1. your steps should be determined by the 1th or 2nd digit of the curr element.
     * 2. make sure you within the matrix length.
     * 3. can't change the value of the matrix.
     *
     * @param mat the matrix to count.
     * @return the number of paths there is.
     */
    public static int countPaths(int[][] mat) {
        return countPaths(mat, 0, 0);
    }// end of countPath

    /**
     * Overloading method helper for the countPath method.
     *
     * @param mat get's the matrix.
     * @param row get's the row.
     * @param col get's the column.
     * @return the number of paths there is.
     */
    private static int countPaths(int[][] mat, int row, int col) {

        if (row < 0 || row >= mat.length || col < 0 || col >= mat[row].length)
            return 0;
        if (mat[row][col] == 0)
            return 0;
        if (row == mat.length - 1 || col == mat[row].length - 1)
            return 1;

        return countPaths(mat, row + mat[row][col] / 10, col + mat[row][col] % 10) +
                countPaths(mat, row + mat[row][col] % 10, col + mat[row][col] / 10);

    }//end of countPath overload.


}








