/*****************************************************************
 * Congruent.Java       @author Netanel Shoshan. 
 *   
 * A program that calculates the distance between two coordinates
 * on a triangle and determines if there's a congruence between 
 * them based on user input.
 ****************************************************************/

import java.util.Scanner; // Importing the Scanner class so we could call it later in the code.

public class Congruent
{
    public static void main(String[] args)
    {   
        // Calling and defining the Scanner constructor using the (System.in) Method.
        Scanner scan = new Scanner(System.in); 

        // Requesting the user to provide what we need.
        System.out.println("Please enter the three coordinates of the first triangle followed by x y : ");
        
        // Scanning all the coordinates from the user.
        int x11 = scan.nextInt(); 
        int y11 = scan.nextInt(); 
        int x12 = scan.nextInt();  
        int y12 = scan.nextInt(); 
        int x13 = scan.nextInt(); 
        int y13 = scan.nextInt(); 

        // Same process (for the second triangle..)
        System.out.println("Please enter the three coordinates of the second triangle followed by x y : ");
        int x21 = scan.nextInt();
        int y21 = scan.nextInt();
        int x22 = scan.nextInt();
        int y22 = scan.nextInt();
        int x23 = scan.nextInt();
        int y23 = scan.nextInt();

        // Outputs the coordinates of the first triangle entered by the user.
        System.out.println("The first triangle is " + "(x" + x11 + ",y" + y11 + ")" + 
                            " (x" + x12 + ",y" + y12 + ")" + " (x" + x13 + ",y" + y13 + ")" );

        // Calculates the distance between two coordinates using the Distance formula. <First TRIANGLE>
        double firstDistAB = Math.sqrt(Math.pow((x12 - x11),2) + Math.pow((y12 - y11),2));
        double firstDistBC = Math.sqrt(Math.pow((x13 - x12),2) + Math.pow((y13 - y12),2));
        double firstDistAC = Math.sqrt(Math.pow((x13 - x11),2) + Math.pow((y13 - y11),2));
        System.out.println("It's length are " + "a" + firstDistAB + "," + " b" + firstDistBC + "," + " c" + firstDistAC + ".");

        // Outputs the coordinates of the seconed triangle entered by the user.
        System.out.println("The second triangle is " + "(x" + x21 + ",y" + y21 + ")" + 
                            " (x" + x22 + ",y" + y22 + ")" + " (x" + x23 + ",y" + y23 + ")" );
    
        // Calculates the distance between two coordinates using the Distance formula. <Second TRIANGLE>
        double secondDistAB = Math.sqrt(Math.pow((x22 - x21),2) + Math.pow((y22 - y21),2));
        double seconedDistBC = Math.sqrt(Math.pow((x23 - x22),2) + Math.pow((y23 - y22),2));
        double seconedDistAC = Math.sqrt(Math.pow((x23 - x21),2) + Math.pow((y23 - y21),2));
        System.out.println("It's length are " + "a" + secondDistAB + "," + " b" + seconedDistBC + "," + " c" + seconedDistAC + ".");

        // Determines If three pairs of sides of two triangles are equal in length using SSS (Side-Side-Side).
        if (firstDistAB == secondDistAB && firstDistBC == seconedDistBC && firstDistAC == seconedDistAC)
            System.out.println("The trinagles are congruent.");
        else
            System.out.println("The triangles are not congruent.");
    }//End of main method.
}// End of Congruent class.
