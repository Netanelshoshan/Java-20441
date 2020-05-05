
public class efficency {
    // O(n)
    // O(1)
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    public static boolean findX(int[] arr, int x) {
        /*
        ///Linear complexity
        if (arr.length == 1)
            return false;

        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] + tmp == x)
                return true;
            else {
                tmp = arr[i];
            }
         */
        // log2n
        int low = 0, high = arr.length - 1, m, sum;
        while (low <= high) {
            m = (low + high) / 2;
            sum = arr[m] + arr[m + 1];

            if (sum == x)
                return true;

            if (sum < x)
                low = m + 1;
            else
                high = m - 1;
        }
        return false;
    }


    private static int f(int[] a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    public static boolean what(int[] a, int num) {
        int high = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            if (f(a, i, high) == num)
                return true;
            else
                i++;
        }
        return false;


    }
    

    public static int meetingPoing(int[] a, int[] b) {
        int res = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static int findSingle(int[] a) {
        int num = a[0];
        int counter = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == num) {
                counter++;
            }
            if (a[i] != num && counter == 2) {
                num = a[i];
                counter = 1;
            }
            if (a[i] != num) {
                break;
            }
        }
        return num;
    }

    public static void sortMod(int[] a, int k) {
        int first = 0;
        int tmp;
        for (int mod = 0; mod < k; mod++) {
            for (int index = 0; index < a.length; index++)
                if (a[index] % k == mod) {
                    tmp = a[first];
                    a[index] = tmp;
                    first++;
                }
        }
    }

    public static int howManyNegNums(int[][] arr) {
        int col = 0;
        int counter = 0;
        for (int row = 0; row < arr.length; row++) {
            if (arr[row][col] < 0)
                counter++;
            if (row == arr.length - 1) {
                if (col == arr[row].length - 1) // if we've reached the end of the cols, get out.
                    break;
                else { // else
                    col++; // move to the second col
                    row = -1;// reset the row counter
                }
            }
        }
        return counter;
    }

    /**
     * נארמ ששורה של N מספרים שלמים מייצגת גבהים של נק ברכס, שיש בהם פסגות ועמקים.
     * השיטה מקבל מערך ובו המספרים המייצגים את הגבהים הרלו, השיטה צריכה להחזיר את הנפילה המקסימלית
     * בין שני מספרים ( לא בהכרח עוקבים) כל שהמספר הגבוה נמצא לפני המספר הנמוך במערך
     */
    public static int maximalDrop(int[] a) {
        if (a.length < 2)
            return 0;
        int i = 1; // search index
        int max = 0; // max index
        int min = 0; //min index
        int maxFall = 0; //maximum fall found
        while (i < a.length) {// keep searching until array ends.
            if (a[i] > a[max]) {// if new max value found
                max = i;
                min = i; // replace both indexes
            } else if (a[i] < a[min]) // else if new min value found
                min = i;
            if (a[max] - a[min] > maxFall)
                maxFall = a[max] - a[min];
            i++;
        }
        return maxFall;
    }

    public static int findTriplet(int[] arr) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {     // n lies between min1 and min2
                min2 = n;
            }
            if (n >= max1) {            // n is greater than max1, max2 and max3
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {     // n lies between max1 and max2
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {     // n lies between max2 and max3
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    public static int findSmallest(int[] arr) {
        if (arr.length == 0 || arr[0] > 1)
            return 1;
        int i, sum = arr[0];
        for (i = 1; i < arr.length; i++) {
            if (arr[i] - sum > 1)
                return sum + 1;
            sum += arr[i];
        }
        return sum + 1;
    }

    public static int meetingPoint(int[] a, int[] b) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i])
                return i;
        }
        return -1;
    }

    public static int countTriplets(int[] arr, int num) {
        if (arr.length < 3)
            return 0;
        int counter = 0;

        for (int i = 0; i <= arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            while (j <= k) {
                if (arr[i] + arr[j] + arr[k] < num) {
                    counter++;
                    j++;
                }
                if (arr[i] + arr[j] + arr[k] >= num) {
                    k--;
                }
            }
        }
        return counter;
    }

    public static int shortestRoad(int a1[], int a2[]) {
        int min = 0, road1Sum = 0, road2Sum = 0, sumInRevR1 = 0, sumInRevR2 = 0;

        //sums arrays.
        for (int i = 0; i < a1.length; i++) {
            road1Sum += a1[i];//55
            road2Sum += a2[i];//54
        }

        for (int i = a1.length - 1; i >= 0; i--) {
            sumInRevR1 += a1[i];
            sumInRevR2 += a2[i];

            if ((road2Sum - sumInRevR2) + sumInRevR1 < road2Sum) {
                if (min == 0)
                    min = (road2Sum - sumInRevR2) + sumInRevR1;
                else if ((road2Sum - sumInRevR2) + sumInRevR1 < min)
                    min = (road2Sum - sumInRevR2) + sumInRevR1;
            } else if ((road1Sum - sumInRevR1) + sumInRevR2 < road1Sum) {
                if (min == 0)
                    min = (road1Sum - sumInRevR1) + sumInRevR2;
                else if ((road1Sum - sumInRevR1) + sumInRevR2 < min)
                    min = (road1Sum - sumInRevR1) + sumInRevR2;
            }
        }
        // I used Math.min for a case where I won't need to move to the other road.
        return Math.min(road1Sum, Math.min(road2Sum, min));
    }

    public static int missingValue(int[] arr) {
        int gap = 0, prev = 0;
        int missing = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            gap = Math.abs(arr[i] - arr[i + 1]);
            if (gap != prev && prev != 0) {
                missing = arr[i] + prev;
                break;
            }
            prev = gap;
        }
        return missing;
    }

    public static int halfSum(int[] a) {
        int totSum = 0;
        for (int i = 0; i < a.length; i++) {
            totSum += a[i];
        }
        int halfSum = 0;
        for (int i = 0; i < a.length; i++) {
            halfSum += a[i];
            if (halfSum * 2 == totSum)
                return i;
            if (halfSum * 2 > totSum)
                return -1;
        }
        return -1;
    }

    public static void zeroDistance(int[] a) {
        int closest = -1; // closest == -1 means no zero was found yet
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
                closest = 0;
            else {
                closest++;
                a[i] = closest;
            }
        }//end of

        // Sorting the values by ascending order, From the end.
        // If zero been reached, reset the counter to zero and start again..
        closest = -1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == 0)
                closest = 0;
                // if zero has been found and a[i] is bigger then (++"the current closest"), assign the closest.
            else if (closest != -1 && a[i] > ++closest)
                a[i] = closest;
        }//end of the sorting for
    } //end of zeroDistance method.

    public static int subStrMaxC(String s, char c, int k) {
        int total = 0; // times the char appears.
        int tss = 0; // total subs.

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                total++;
        }
        if (total < 2) // if there isn't a string that fulfill the condition.
            return 0;

        for (int i = k; i >= 0; i--) {
            if (i < total)
                tss = tss + (total - (i + 1)); // the number of substrings with max K constants.
        }
        return tss;
    }// end of subStrMaxC

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


    public static void smallestSub(int[] a, int k) {
        int l = 0, r = 1, sum = a[0], count = 1, min = a.length;
        while (l <= r) {
            if (sum <= k) {
                if (r == a.length)
                    break;
                sum += a[r];
                r++;
                count++;
            } else {
                min = Math.min(min, count);
                sum -= a[l];
                l++;
                count--;
            }
        }

        System.out.println(l == 0 && r == a.length ? min + 1 : min);
    }

    public static void replace(int[] a) {
        int len = a.length - 1;
        int maxOfNumsToTheRight = 0;

        if (len == -1)
            a[0] = 0;

        maxOfNumsToTheRight = Math.max(a[len - 1], a[len]);
        a[len - 1] = a[len];
        a[len] = 0;

        for (int i = len - 2; i >= 0; i--) {
            int tmp = a[i];
            a[i] = maxOfNumsToTheRight;
            maxOfNumsToTheRight = Math.max(maxOfNumsToTheRight, tmp);
        }

        for (int i = 0; i < a.length; i++)
            System.out.println("a " + i + " " + a[i]);

    }

    public static void printPairs(int[] a, int k) {
        int l = 0;
        int r = 1;

        while (r < a.length) {
            if (a[r] - a[l] > k)
                l++;
            else if (a[r] - a[l] < k)
                r++;
            else {
                System.out.println("Pair Found: (" + a[l] + "," + a[r] + ")");
                l++;
                r++;
            }
            if (r == 1)
                r++;
        }
    }

    public static boolean findXnew(int[] a, int x) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean found = a[i] + a[i + 1] == x;
            if (found)
                return true;
        }
        return false;
    }

    public static int test(int[] a) {
        int i = 0, p1 = 0, p2 = 1, cnt = 0;

        while (i < a.length && p2 < a.length) {
            if (a[p2] - a[p1] >= 1) {
                cnt++;
                p2++;
                p1++;
            } else if (a[p2] - a[p1] == 0) {
                i++;
                p1 = i;
                p2 = p1 + 1;
            } else {
                if (p2 == a.length) {
                    i++;
                    p1++;
                    p2 = p1 + 1;

                }
            }
        }
        return cnt;
    }


    public static void main(String[] args) {

        int[] fs = {1, 2, 4, 4, 5};
        System.out.println(test(fs));

        //int[] x = {1, 2, 5, 3, 6, 10, 9};
        //System.out.println(findXnew(x, 5));
        /*
        int[] missingVal = {7, 10, 13, 16, 22, 25};
        System.out.println(missingValue(missingVal));


        int[] road1 = {5, 4, 5, 8, 12, 9, 9, 3};
        int[] road2 = {7, 3, 3, 12, 10, 2, 10, 7};
        System.out.println(shortestRoad(road1, road2));

        int[] triplets = {1, 3, 4, 5, 7};
        System.out.println(countTriplets(triplets, 12));


        int[] mp1 ={19,19,16,15,15,15,15,13,5};
        int[] mp2 ={0,12,13,14,14,15,15,19,25,30,35};
        System.out.println(meetingPoint(mp1,mp2));


        int[] smallest = {1, 1, 1, 1};
        System.out.println(findSmallest(smallest));

        //findTriplets
        int[] maxProduct={-4,1,-8,9,6};
        System.out.println(findTriplet(maxProduct));

        //maximalDrop
        int[] maxFall = {5, 21, 3, 22, 12, 7, 27, 6, 4}; // should return 23 (27-4)
        int[] maxFall1 = {5, 21, 3, 22, 12, 7, 26, 14}; // should return 18 (21-3)
        int[] maxFall2 = {5, 15, 3, 22, 12, 7, 27, 14}; // should return 15 (22-7)
        System.out.println(maximalDrop(maxFall));
        System.out.println(maximalDrop(maxFall1));
        System.out.println(maximalDrop(maxFall2));


        //howManyNegNumbers
        int[][] arr = {
                {-99, -72, -64, -55, -28, -10, -5},
                {-72, -53, -46, -38, 11, 13, 22},
                {-63, -48, -27, -12, 14, 16, 23},
                {-44, -29, -10, 0, 18, 20, 28},
                {0, 12, 14, 20, 28, 30, 35}
        };

        System.out.println(howManyNegNums(arr)); // should return 18

        //findSingle
        int[] single = {6, 6, 18, 18, -4, -4, 12, 9, 9};
        int[] single1 = {8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4};
        int[] single2 = {5};
        System.out.println(findSingle(single2));

/*
        // find max
        int[] a = new int[7];
        a[0] = 65;
        a[1] = 70;
        a[2] = -5;
        a[3] = 3;
        a[4] = 48;
        a[5] = 49;
        a[6] = 52;
        System.out.print(findMax(a));
        System.out.println();

        //findX
        int[] b = new int[7];
        b[0] = 1;
        b[1] = 2;
        b[2] = 5;
        b[3] = 3;
        b[4] = 6;
        b[5] = 10;
        b[6] = 9;

        System.out.println(findX(b, 5));


 */


    }


}
