public class b2018 {
    public static int prince(int[][] drm, int i, int j) {
        return prince(drm, i, j, drm[i][j], 1);
    }

    private static int prince(int[][] drm, int i, int j, int prev, int counter) {
        if (i < 0 || j < 0 || i >= drm.length || j >= drm[i].length || drm[i][j] == -2)
            return 0;

        if (drm[i][j] == -1)
            return counter;

        if (prev - drm[i][j] > 2 || prev - drm[i][j] < -1)
            return 0;

        int tmp, up, down, left, right;
        tmp = drm[i][j];
        drm[i][j] = -2;
        down = prince(drm, i + 1, j, tmp, counter + 1);
        right = prince(drm, i, j + 1, tmp, counter + 1);
        up = prince(drm, i - 1, j, tmp, counter + 1);
        left = prince(drm, i, j - 1, tmp, counter + 1);

        drm[i][j] = tmp;

        tmp = findMin(up, down, left, right);

        if (tmp == 0)
            return -1;

        return counter;
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

    public static int findSingle(int[] a) {
        int gap;
        for (int i = 1; i < a.length - 1; i++) {
            boolean prev = a[i] == a[i - 1];
            if (a[i] < 0 && !prev) {
                gap = Math.abs(a[i] - a[i + 1]);
                if (gap > 0)
                    return a[i];
            }
            if (a[i] > 0 && !prev) {
                gap = Math.abs(a[i] - a[i + 1]);
                if (gap != 0)
                    return a[i];

            }
            if (a[i] == 0 && !prev) {
                gap = Math.abs(a[i] - a[i + 1]);
                if (gap != 0)
                    return a[i];

            }
            if (i == a.length - 2) {
                gap = Math.abs(a[i] - a[i + 1]);
                if (gap != 0)
                    return a[i + 1];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] drm1 = {
                {2, 0, 1, 2, 3},
                {2, 3, 5, 5, 4},
                {8, -1, 6, 8, 7},
                {3, 4, 7, 2, 4},
                {2, 4, 3, 1, 2}
        };

        int[] a = {6, 6, 18, 18, -4, -4, 12, 9, 9};
        int[] b = {8, 8, -7, -7, 3, 3, 0, 0, 10, 10, 5, 5, 4};

        System.out.println(findSingle(b));
    }
}
