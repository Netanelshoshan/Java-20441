public class recusive_questions {

    public static void printPath(int[][] mat) {
        System.out.print("(" + 0 + "," + 0 + ")" + "\t");
        printPath(mat, 0, 0);
        System.out.println();

    }

    private static void printPath(int[][] mat, int row, int col) {
        if (printPath(mat, row + 1, col, mat[row][col]))
            printPath(mat, row + 1, col);
        else if (printPath(mat, row, col + 1, mat[row][col]))
            printPath(mat, row, col + 1);
        else if (printPath(mat, row - 1, col, mat[row][col]))
            printPath(mat, row - 1, col);
        else if (printPath(mat, row, col - 1, mat[row][col]))
            printPath(mat, row, col - 1);

    }

    private static boolean printPath(int[][] mat, int row, int col, int prev) {
        if (row >= 0 && row < mat.length &&
                col >= 0 && col < mat[row].length &&
                mat[row][col] > prev) {
            System.out.print("(" + row + "," + col + ")" + "\t");
            return true;
        }
        return false;
    }


    public static int minPath(char[][] minChess, int i, int j) {
        int min = minChess.length * minChess.length; //min track.
        return minPath(minChess, i, j, 0, 0);
    }

    private static int minPath(char[][] minChess, int i, int j, int min, int counter) {
        if (i < 0 || i >= minChess.length || j < 0 || j >= minChess.length || minChess[i][j] == 'H')
            return 0;

        if (minChess[i][j] == 'K') {
            return Math.min(counter, min);
        }

        char temp = minChess[i][j];
        minChess[i][j] = 'H';

        int s1 = minPath(minChess, i + 2, j + 1, min, counter + 1);
        int s2 = minPath(minChess, i + 2, j - 1, min, counter + 1);
        int s3 = minPath(minChess, i + 1, j + 2, min, counter + 1);
        int s4 = minPath(minChess, i + 1, j - 2, min, counter + 1);
        int s5 = minPath(minChess, i - 2, j + 1, min, counter + 1);
        int s6 = minPath(minChess, i - 2, j - 1, min, counter + 1);
        int s7 = minPath(minChess, i - 1, j + 2, min, counter + 1);
        int s8 = minPath(minChess, i - 1, j - 2, min, counter + 1);

        minChess[i][j] = temp;


        return min(s1, min(s2, min(s3, min(s4, min(s5, min(s6, min(s7, s8)))))));
    }

    private static int min(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
    }

    public static int howManySorted(int n, int max) {
        return howManySorted(n, max, 0, 1, 0);
    }

    private static int howManySorted(int n, int max, int curr, int pointer, int counter) {
        if (curr == max && curr == n)
            return 0;

        if (curr < max && curr < n) {
            if (pointer < max)
                return howManySorted(n, max, curr, pointer + 1, counter + 1);
            else if (pointer == max) {
                pointer = curr + 1;
                return howManySorted(n, max, curr + 1, pointer, counter + 1);
            }
        }

        return counter;
    }


    public static int howManyPaths(int[][] mat) {
        return howManyPaths(mat, 0, 0);
    }

    private static int howManyPaths(int[][] mat, int row, int col) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[row].length
                || mat[row][col] == -1)
            return 0; // matrix boundaries and step check.

        if (row == mat.length - 1 && col == mat[row].length)
            return 1; // end of matrix.

        int k = mat[row][col]; // assigning k the current value.

        mat[row][col] = -1; //changing k to be the value, below zero so we wont step in
        // the same spot again.
        int ops = howManyPaths(mat, row + k, col) +
                howManyPaths(mat, row - k, col) +
                howManyPaths(mat, row, col + k) +
                howManyPaths(mat, row, col - k);
        mat[row][col] = k;
        return ops;
    }

    public static int longestPath(int[][] mat, int x, int y) {
        return longestPath(mat, x, y, 0, 0, 1);
    }

    private static int longestPath(int[][] mat, int x, int y, int i, int j, int counter) {
        //bad case
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[i].length || mat[i][j] == 0 || mat[i][j] == 2)
            return 0;
        // goal reached.
        if (i == x && j == y)
            return counter;

        int tmp = mat[i][j]; // temp var to hold the path before the change.
        mat[i][j] = 2; //the path

        int up = longestPath(mat, x, y, i + 1, j, counter + 1);
        int down = longestPath(mat, x, y, i - 1, j, counter + 1);
        int right = longestPath(mat, x, y, i, j + 1, counter + 1);
        int left = longestPath(mat, x, y, i, j - 1, counter + 1);

        mat[i][j] = tmp;

        return max(up, down, right, left);
    }

    private static int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }

    public static int prince(int[][] drm, int i, int j) {
        return prince(drm, i, j, drm.length, 1, drm[i][j]);
    }

    private static int prince(int[][] drm, int i, int j, int len, int steps, int prev) {
        if (i < 0 || i >= len || j < 0 || j >= len ||
                drm[i][j] == -2)
            return len * len;
        if (drm[i][j] == -1)
            return steps;
        if (prev - drm[i][j] > 2 || prev - drm[i][j] < -1)
            return len * len;

        int up, down, right, left, temp;
        temp = drm[i][j];
        drm[i][j] = -2;

        up = prince(drm, i + 1, j, len, steps + 1, temp);
        down = prince(drm, i - 1, j, len, steps + 1, temp);
        right = prince(drm, i, j + 1, len, steps + 1, temp);
        left = prince(drm, i, j - 1, len, steps + 1, temp);

        drm[i][j] = temp;
        temp = findMin(up, down, right, left);

        if (temp == len * len)
            return -1;
        return temp;

    }

    private static int findMin(int a, int b, int c, int d) {
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        if (d < min)
            min = d;
        return min;
    }

    public static int cheapestRoute(int[] stations) {
        return cheapestRoute(stations, 0, 0);
    }

    private static int cheapestRoute(int[] stations, int i, int sum) {
        if (i >= stations.length)
            return sum;
        if (i == stations.length - 2)
            return Math.min(cheapestRoute(stations, i + 1, sum + stations[i]), cheapestRoute(stations, i + 2, sum + stations[i]));
        if (i == stations.length - 1)
            return cheapestRoute(stations, i + 1, sum + stations[i]);

        return Math.min(cheapestRoute(stations, i + 1, sum + stations[i]), cheapestRoute(stations, i + 2, sum + stations[i]));
    }

    public static int edit(String str1, String str2) {
        return edit(str1, str2, 0, 0);
    }

    private static int edit(String str1, String str2, int i1, int i2) {
        if (str1.length() == i1 && str2.length() == i2)
            return 0; // end of the string

        if (i1 == str1.length()) // if only str1 reached his end -> add to str2
            return 1 + edit(str1, str2, i1, i2 + 1);

        if (i2 == str2.length()) //if only str2 reached his end -> add to str1
            return 1 + edit(str1, str2, i1 + 1, i2);

        if (str1.charAt(i1) == str2.charAt(i2)) // same char, no need to count
            return edit(str1, str2, i1 + 1, i2 + 1);

        return Math.min(// choosing the minimal.
                edit(str1, str2, i1 + 1, i2) + 1, edit(str1, str2, i1, i2 + 1) + 1);
    }

    public static boolean samePattern(String s1, String s2) {
        if (s1.length() == 0) {
            return s2.length() == 0 || s2.equals('*');
        } else if (s2.length() == 0)
            return false;

        if (s1.charAt(0) == s2.charAt(0))
            return samePattern(s1.substring(1), s2.substring(1));
        if (s2.charAt(0) == '*')
            return samePattern(s1.substring(1), s2) || samePattern(s1, s2.substring(1));

        else return false;
    }

    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();

        boolean first_match =
                (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*')
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        else
            return first_match && isMatch(text.substring(1), pattern.substring(1));


    }

    public static int cntTrueReg(boolean[][] mat) {
        return cntTrueReg(mat, 0, 0, 0);
    }

    private static int cntTrueReg(boolean[][] mat, int row, int col, int counter) {

        //if we've reached the end of the columns, reset the columns and increment the row by 1.
        if (col == mat[0].length)
            return cntTrueReg(mat, row + 1, 0, counter);

        // if we've reached the end of the rows (that's my exit point
        if (row == mat.length)
            return counter;

        // if we've reached a cell with the true value,
        //call advance and move one col to the right. increment the counter by 1.
        if (mat[row][col]) {
            advance(mat, row, col);
            return cntTrueReg(mat, row, col + 1, counter + 1);
        }
        // otherwise , move on to the next column.
        return cntTrueReg(mat, row, col + 1, counter);
    }

    private static void advance(boolean[][] mat, int row, int col) {
        if (row >= mat.length || col >= mat[0].length || !mat[row][col])
            return; //return nothing because this method is <void>.
        mat[row][col] = false; //marking steps.
        // always move forward.
        advance(mat, row, col + 1);
        advance(mat, row + 1, col);
    }

    public static boolean isSum(int[] a, int num) {
        return isSum(a, num, 0, 2, a.length - 1);
    }

    private static boolean isSum(int[] a, int num, int i, int j, int k) {
        if (num == 0)
            return true;
        if (a[i] + a[j] + a[k] == num)
            return true;
        if (a[i] + a[j] == num || a[i] + a[k] == num)
            return true;
        if (a[i] == num || a[j] == num || a[k] == num)
            return true;
        if (i == k - 1)
            return false;
        if (j == k - 1)
            return isSum(a, num, i + 1, j, k);
        return isSum(a, num, i, j + 1, k);
    }

    public static int longestPalindrome(int[] arr) {
        return longestPalindrome(arr, 0, arr.length - 1, 0);
    }

    private static int longestPalindrome(int[] a, int i, int j, int counter) {
        if (i == j && j == a.length - 1)
            return longestPalindrome(a, 0, j - 1, counter);
        if (i > j && j != a.length - 1) {
            if (counter == 0)
                return 1;
            else return counter;
        }

        if (a[i] == a[j])
            return longestPalindrome(a, i + 1, j - 1, counter + 2);
        return longestPalindrome(a, i + 1, j, counter);
    }


    public static boolean splitEqualMult(int[] a) {
        return splitEqualMult(a, 0, 1, 1);
    }

    public static boolean splitEqualMult(int[] a, int i, int sum1, int sum2) {
        if (i == a.length) {
            if (sum1 == sum2)
                return true;
            return false;
        }
        if (splitEqualMult(a, i + 1, sum1 * a[i], sum2) == false)
            if (splitEqualMult(a, i + 1, sum1, sum2 * a[i]) == false)
                return false;
        return true;
    }

    public static int count2016(int sum) {
        return count2016(1, 2, 0, 0, sum);
    }

    private static int count2016(int i, int j, int s, int cnt, int sum) {
        if (j == sum) {
            return count2016(i + 1, i + 2, 0, cnt + 1, sum);
        }
        if (i < sum) {
            if (s == 0) {
                if (i + j < sum) {
                    s = i + j;
                    return count2016(i, j + 1, s, cnt, sum);
                } else if (i + j == sum) {
                    return count2016(i, j + 1, 0, cnt + 1, sum);
                }
            }
            if (s > 0) {
                if (s + j < sum) {
                    s += j;
                    return count2016(i, j + 1, s, cnt, sum);
                }
                if (s + j == sum)
                    return count2016(i, j + 1, 0, cnt + 1, sum);
                if (s + j > sum) {
                    s -= (j - 1);
                    return count2016(i, j, s, cnt, sum);
                }
            }
        }
        return cnt + 1;
    }

    public static int subStrC(String s, char c) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                cnt++;
        }
        if (cnt < 2)
            return 0;
        return cnt - 2;
    }

    public static int subStrMaxC(String s, char c, int k) {
        int cnt = 0;
        int tss = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                cnt++;
        }
        if (cnt < 2)
            return 0;
        for (int i = k; i >= 0; i--) {
            if (i < cnt)
                tss += cnt - (i + 1);
        }
        return tss;
    }


    public static void main(String[] args) {

        int[] cheap = {2, 8, 3, 4, 7, 1, 3, 2};
        System.out.println(cheapestRoute(cheap));


//        System.out.println(splitEqualMult(x));


        char[][] chess = {
                {'0', '0', 'K', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'H', '0', '0', '0'},
        };
        //minPath(chess, 3, 0);


        /*

        System.out.println(count2016(7));
        int[] x = {2, 15, 3, 4, 2, 5};
        int[] y = {2, 4, 6, 2, 3, 4};
        int sum = 0;

        int[] lonestPali = {1, 3, 2, 3, 10, 10, 3, 2, 4};
        System.out.println(longestPalindrome(lonestPali));

        System.out.println(howManySorted(2, 3));


        int[] isSum = {5, 4, 2, 1, 3};
        System.out.println(isSum(isSum, 17));


        boolean[][] cnt = {
                {false, false, false, false, true},
                {false, true, true, true, false},
                {false, false, true, true, false},
                {true, false, false, false, false},
                {true, true, false, false, false}
        };

        System.out.println(cntTrueReg(cnt));




        int[][] hmp = {
                {1, 3, 1, 6},
                {2, 8, 1, 2},
                {6, 2, 7, 5},
                {2, 4, 1, 3}
        };
        System.out.println(howManyPaths1(hmp));


        String st1 = "TheExamIsEasy";
        String st2 = "The*IsHard";

        System.out.println(samePattern(st1, st2));





        int[] a = {19, 19, 16, 15, 15, 15, 15, 13, 5};
        int[] b = {0, 12, 13, 14, 14, 15, 15, 19, 25, 30, 35};
        //System.out.println(meetingPoing(a, b));

        int[][] longest = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1},
                {1, 1, 1, 1, 0, 1, 1}
        };
        System.out.println(longestPath(longest, 2, 5));

         */


    }
}