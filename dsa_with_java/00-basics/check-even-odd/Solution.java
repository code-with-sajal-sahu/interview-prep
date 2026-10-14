import java.util.Scanner;
public class Solution {
	public static void main(String[] args){
		int a;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		a = input.nextInt();
		if(a % 2 == 0){
			System.out.print(a + " is even");
		}else{
			System.out.print(a + " is odd");
		}
	}
}