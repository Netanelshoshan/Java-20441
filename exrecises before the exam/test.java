public class test {

    public static int shortestRoad(int a1[], int a2[]) {
        int min = 0; // min value.
        int road1Sum = 0, road2Sum = 0; // sum of the roads.
        int sumInRevR1 = 0;
        int sumInRevR2 = 0;

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

    public static void main(String[] args) {
        int[] road1 = {5, 4, 5, 8, 12, 9, 9, 3};
        int[] road2 = {7, 3, 3, 12, 10, 2, 10, 7};
        System.out.println(shortestRoad(road1, road2));
    }
}

/*
if (road1[j] + road1[j - 1] < road2[j] + road2[j - 1] && k < 1) {
                min = (road2Sum - road2[j] - road2[j - 1]) + (road1[j] + road1[j - 1]);
                k++;
            }
 */