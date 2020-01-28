import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Coins 
{
	public static Scanner input = new Scanner(System.in); 
	final String coins = "coins.txt";
	String line;
	int item_num;
	public static int coin_count = 0;                       
    public static int paper_money_count = 0; 
	
	Coins () throws Exception
	{
		System.out.println();
		System.out.println("Select Item: 1, 2, 3, 4");
		item_num = input.nextInt() + 3;
		String[] line  = new String[100];
		char [] chars = new char[100];
		String info;
		
		try( BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(coins))))
		{
			String i;
			for ( int j = 0; j < line.length; j++)
				{
				    info = in.readLine().toString();
					if (j == item_num)
					{
						chars = info.toCharArray();
						System.out.print(chars);
					}
				}
        } catch (FileNotFoundException nofile) {
  	    	 System.out.println("File not found.");
	    	 System.exit(1);
	    }
	}
}
