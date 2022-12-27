import java.util.Scanner;

public class Temprature
{
	public static void main(String[] args)
	{
		int temp;
		float temprature, arr[];
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("How many temprature value you want to insert: ");
		temp = scan.nextInt();
		arr = new float[temp];
		
		for (int i=0; i<temp; i++)
		{
			System.out.println("Enter the temprature in farenheit: ");
			temprature = scan.nextFloat();
			arr[i] = ((temprature-32)*5)/9;
		}
		
		for (int i=0;i<arr.length;i++)
		{
			System.out.println("Temprature in ceslsius: \n"+arr[i]);
		}
	}
}
