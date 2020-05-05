/*************************************************************
 * Triangle.java         @author: Netanel Shoshan 
 *  
 *  A program that calculates the area and the perimeter
 *  of a given triangle based on user input. 
 **************************************************************/ 

import java.util.Scanner;

public class Triangle
{
    public static void main(String[] args) 
    {   
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the area " + 
                            "and the perimeter of a given triangle.");
        System.out.println("Please enter the three lengths" + 
                             " of the triangle's sides:  ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        
        // Outputs an error if one side of the triangle is bigger then the other two combined.
        if (c > (a + b) || a > (b + c) || b > (a + c)) 
        { 
            System.out.println("Based on the information that you provided " + 
                                "the output isn't a number. Please try again.");
        }           
        double s = (a + b + c) / 2 ; // Calculates the semi-perimeter of the triangle.
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula. 

        System.out.println("The area of the triangle using Heron's formula is: " + area); // Prints out the calculated area.
    }// End of main method.
} // End of Triangle class.


