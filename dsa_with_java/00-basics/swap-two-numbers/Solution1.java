import java.util.Scanner;

public class Solution1 {
	public static void main(String args[]){
		int a, b, c;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first number: ");
		a = input.nextInt();
		System.out.print("Enter second number: ");
		b = input.nextInt();
		System.out.println("Before Swapping: ");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		c = a;
		a = b;
		b = c;

		System.out.println("After Swapping: ");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}