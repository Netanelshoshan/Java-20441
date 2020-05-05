/**
 * Tester for mmn14 by Netanel Shoshan.
 */


public class Ex14_tester {

    public static void main(String[] args) {
        Ex14 a = new Ex14();

        String s;
        char c = 'c';
        int k;

        System.out.println("Starting tests for mmn14:");
        System.out.println();
        System.out.println("------------Tests for subStrC------------");

        c = 'c';
        s = "abcbc";
        System.out.print("Testing where n is the key and the String is \"" + s + "\"  , (Should return 0): ");
        System.out.println(Ex14.subStrC(s, c));

        c = 'n';
        s = "snetanelshoshannetanelshoshansnetanelshoshan";
        System.out.print("Testing where n is the key and the String is  \"" + s + "\" , (Should return 7): ");
        System.out.println(Ex14.subStrC(s, c));

        c = 'c';
        s = "abcbcabcacabcc";
        System.out.print("Testing where c is the key and and the String is \"" + s + "\" , (Should return 4): ");
        System.out.println(Ex14.subStrC(s, c));

        c = 'd';
        s = "abdcddacdbddabd";
        System.out.print("Testing where d is the key and the String is \"" + s + "\" , (Should return 5): ");
        System.out.println(Ex14.subStrC(s, c));


        c = 'c';
        s = "abcbcabcacabcc";
        System.out.print("Testing where c is the key and the String is \"" + s + "\" , (Should return 4): ");
        System.out.println(Ex14.subStrC(s, c));

        System.out.println("---------END of tests for subStrC---------");

        System.out.println();
        System.out.println();

        System.out.println("------------Tests for subStrMaxC------------");
        s = "snetanelshoshannetanelshoshansnetanelshoshan";
        c = 'n';
        k = 0;
        System.out.print("Testing where c is the key k= " + k + " the String is \"" + s + "\" , (Should return 8): ");
        System.out.println(Ex14.subStrMaxC(s, c, k));


        s = "abcbc";
        c = 'c';
        k = 0;
        System.out.print("Testing where c is the key, k= " + k + " the String is \"" + s + "\", (Should return 1): ");
        System.out.println(Ex14.subStrMaxC(s, c, k));
        c = 'c';
        s = "abcbcabcacab";
        k = 2;
        System.out.print("Testing where c is the key, k= " + k + " the String is \"" + s + "\", (Should return 6): ");
        System.out.println(Ex14.subStrMaxC(s, c, k));
        c = 'c';
        s = "abcbcabcacab";
        k = 3;
        System.out.print("Testing where c is the key, k= " + k + " the String is \"" + s + "\", (Should return 6): ");
        System.out.println(Ex14.subStrMaxC(s, c, k));

        s = "abc";
        k = 2;
        System.out.print("Testing where c is the key, k= " + k + " the String is \"" + s + "\", (Should return 0): ");
        System.out.println(Ex14.subStrMaxC(s, c, k));

        System.out.println("----------END of tests for subStrMaxC--------");
        System.out.println();
        System.out.println("----------Tests for zeroDistance--------");


        int[] b = {0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1};
        System.out.println("zeroDistance starts with:");
        System.out.println("{0,1,1,1,1,1,1,0,1,1,1,1,1,0,1,1}");
        Ex14.zeroDistance(b);
        System.out.println("Your result: ");
        for (int i = 0; i < b.length - 1; i++)
            System.out.print(b[i] + ", ");

        System.out.println(b[b.length - 1]);
        System.out.println("How the result should be : ");
        System.out.println("0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0, 1, 2");

        System.out.println("----------END of tests for zeroDistance--------");
        System.out.println();
        System.out.println("----------Tests for isTrans--------");

        boolean result = Ex14.isTrans("abbcd", "aabbccdd");
        System.out.println("For abbcd and aabbccdd (should return true): " + result); //expected true

        result = Ex14.isTrans("abbcd", "abbcd");
        System.out.println("For abbcd and abbcd (should return true): " + result);

        result = Ex14.isTrans("abbcd", "aaaabbcd");
        System.out.println("For abbcd and aaaabbcd (should return true): " + result);

        result = Ex14.isTrans("abbcd", "abbcdddddd");
        System.out.println("For abbcd and abbcdddddd (should return true): " + result); //expected true

        result = Ex14.isTrans("abbcd", "aabbccdd");
        System.out.println("For abbcd and aabbccdd (should return true): " + result); //expected true

        result = Ex14.isTrans("abbcd", "abbbccd");
        System.out.println("For abbcd and abbbccd (should return true): " + result); //expected true

        System.out.println();
        System.out.print("This three should return false:");
        System.out.println();

        result = Ex14.isTrans("abbcd", "a");
        System.out.println("For abbcd and a (should return false): " + result); //expected false

        result = Ex14.isTrans("abbcd", "aaccbbdd");
        System.out.println("For abbcd and aaccbbdd (should return false): " + result); //expected false

        result = Ex14.isTrans("abbcd", "abcd");
        System.out.println("For abbcd and abcd (should return false): " + result); //expected false

        System.out.println("----------END of tests for isTrans--------");

        System.out.println();

        System.out.println("----------Tests for countPath--------");

        /*
        {12, 22, 23, 54},
                {43, 35, 21, 20},
                {34, 21, 43, 21},
                {25, 30, 0, 20},
                {0, 22, 10, 10},
                {20, 13, 3, 45}
         */
        int[][] a1 = {
        {20, 21, 32, 31, 65, 96},
        {45, 30, 82, 79, 10, 52},
        {51, 46, 96, 48, 45, 10},
        {50, 13, 5, 95, 1, 37}};

        int[][] countPathArr2 = {{20, 97, 93, 15, 15, 61}, {37, 10, 36, 40, 93, 18}, {1, 12, 82, 85, 69, 25}, {12, 52, 95, 36, 7, 90}, {80, 84, 30, 97, 24, 50}, {46, 12, 56, 1, 70, 27}, {51, 6, 74, 7, 50, 48}, {10, 52, 23, 28, 75, 45}, {37, 26, 78, 90, 8, 64}, {97, 67, 2, 58, 92, 2}};


        int studentRes = Ex14.countPaths(countPathArr2);
        int expectedRes = 6;
        System.out.println("array : ");
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                System.out.print(a1[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("expected=" + expectedRes + " : student=" + studentRes);
        if (studentRes != expectedRes)
            System.out.println("countPaths FAILED ");
        else
            System.out.println("countPaths PASSED ");

        System.out.println("----------END of tests for countPath--------");

    }

}

