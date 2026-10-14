import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		int a, b, c;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		a = input.nextInt();
		System.out.print("Enter second integer: ");
		b = input.nextInt();
		System.out.print("Enter third integer: ");
		c = input.nextInt();

		if(a >= b && a >= c){
			System.out.print("Largest number: " + a);
		}else if(b >= c){
			System.out.print("Largest number: " + b);
		}else{
			System.out.print("Largest number: " + c);
		}
	}
}