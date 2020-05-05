public class Range {
    private int _center, _radius;

    public Range(int c, int r) {
        _center = c;
        _radius = r;
    }

    public int getCenter() {
        return _center;
    }

    public int getRadius() {
        return _radius;
    }


    public static int findNum(Range rangeA[], int num) {
        int low = 0, high = rangeA.length - 1, mid, diffL, diffS;
        while (low <= high) {
            mid = (low + high) / 2;
            diffL = num - rangeA[mid].getCenter();
            diffS = rangeA[mid].getCenter() - num;
            if (rangeA[mid].getCenter() == num)
                return mid;
            else if (rangeA[mid].getCenter() > num) {
                if (diffL <= rangeA[mid].getRadius())
                    return mid;
                else low = mid + 1;
            } else {
                if (diffS <= rangeA[mid].getRadius())
                    return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Range r1[] = new Range[4];
        r1[0] = new Range(4, 1);
        r1[1] = new Range(12, 0);
        r1[2] = new Range(20, 1);
        r1[3] = new Range(102, 2);


        System.out.println(findNum(r1, 5));
    }

}
