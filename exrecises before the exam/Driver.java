public class Driver {
    public static void main(String[] args) {
        AAA a1 = new AAA(5);
        AAA a2 = new AAA(5);
        AAA ab = new BBB();
        BBB b1 = new BBB();
        BBB b2 = new BBB();
        if (a1.equals(b1)) System.out.println(1);
        if (b1.equals(a1)) System.out.println(2);
        if (a1.equals(ab)) System.out.println(3);
        if (ab.equals(a1)) System.out.println(4);
        if (b1.equals(ab)) System.out.println(5);
        if (ab.equals(b1)) System.out.println(6);
        if (a1.equals(a2)) System.out.println(7);
        if (b1.equals(b2)) System.out.println(8);


    }
}