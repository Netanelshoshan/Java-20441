public class a2018ver87 {
    public static int howManySorted(int n, int max) {
        return howManySorted(n, max, 0, 1, 0);
    }

    private static int howManySorted(int n, int max, int ptr, int curr, int counter) {
        if (ptr == max && ptr == n)
            return 0;

        if (ptr < max && ptr < n) {
            if (curr < max)
                return howManySorted(n, max, ptr, curr + 1, counter + 1);
            else if (curr == max) {
                curr = ptr + 1;
                return howManySorted(n, max, ptr + 1, curr, counter + 1);
            }
        }

        return counter;
    }


    private static int f(int[] a, int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++)
            res += a[i];
        return res;
    }

    public static boolean what(int[] a, int num) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (f(a, i, j) == num)
                    return true;
            }
        }
        return false;
    }


    public static boolean eff(int[] a, int num) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        if (sum == num)
            return true;

        for (int i = 0; i < a.length; i++) {
            sum -= a[i];
            if (sum == num)
                return true;

        }
        return false;
    }

    public static int cheapestRoute(int[] stations) {
        return cheapestRoute(stations, 0, stations[0]);
    }

    private static int cheapestRoute(int[] s, int i, int sum) {
        if (i == s.length - 1)
            return sum;
        if (i == s.length - 2)
            return cheapestRoute(s, i + 1, sum + s[i + 1]);
        int p1 = cheapestRoute(s, i + 1, sum + s[i + 1]);
        int p2 = cheapestRoute(s, i + 2, sum + s[i + 2]);

        return Math.min(p1, p2);
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

    public static void main(String[] args) {
        // System.out.println(howManySorted(3, 2));

        int[] route = {2, 8, 3, 4, 7, 1, 3, 2};
        System.out.println(cheapestRoute(route));
        int[] what = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //System.out.println(eff(what,55));
    }
    /*
       ROOT=300 P1=180 Q1=200
       125
       180
     */


}
