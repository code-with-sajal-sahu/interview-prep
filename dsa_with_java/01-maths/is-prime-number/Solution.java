
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = input.nextInt();
        boolean isPrime = n > 1;

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.print(n + " is prime");
        } else {
            System.out.print(n + " is not prime");
        }
    }
}
