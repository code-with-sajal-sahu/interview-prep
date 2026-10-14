import java.util.Scanner;
public class Solution {
	public static void main(String[] args){
		int a;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number: ");
		a = input.nextInt();
		if(a % 2 == 0){
			System.out.print("Number is even");
		}else{
			System.out.print("Number is odd");
		}
	}
}