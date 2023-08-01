//This program is the solution to a hackerrank challenge described in the following link:  https://www.hackerrank.com/challenges/java-if-else/problem
import java.util.Scanner;

public class Solution {
    public static void Method(int number) {
        if (number % 2 != 0) {
            System.out.println("Weird");
        } else if (number % 2 == 0 && number >= 2 && number <= 5) {
            System.out.println("Not Weird");
            
        } else if (number%2 == 0 && number >= 6 && number <= 20) {
            System.out.println("Weird");
        } else if(number%2 == 0 && number > 20) {
            System.out.println("Not Weird");
        } else {
            System.out.println("Not a valid number");        
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();
        Method(n);
        
    }
}

