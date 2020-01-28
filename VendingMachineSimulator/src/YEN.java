/** 
 * EN.605.201 Introduction to Java Programming
 * This is the YEN class for Vending Machine Simulator which stores the denominations
 * and their quantities for the YEN currency. The user is prompted to insert payment until
 * the total is zero. If the user overpays the vending machine calculates the change and 
 * dispenses it. 
 * 
 * @version		1.0 January 27, 2020
 * @author		shanzalewis
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class YEN 
{
	String[] line  = new String[100];
	String[] s = new String[100];
	String info;
	String amt_rem;
	String name;
	String cost;
	String amount;
	String bottles;
	String denom;
	String quantity;
	String quant_rem;
	int i;
	int item_amount;
	int amount_remaining;
	int money;
	int item_num;
	int currency_quantity;
	int quantity_remaining;
	int new_quantity;
	double item_cost;
	double owed;
	double change;
	double total_bottle;
	double total_bag;
	double paper_wrapper;
	double total;
	
	public static Scanner input = new Scanner(System.in);
	
	YEN() throws Exception
	{
		Bottles bottle_item = new Bottles();
		Bags bag_item = new Bags();
		PaperWrapper paper_wrapper_item = new PaperWrapper();
		
		this.total = 0;
		this.item_num = 0;
		this.line = null;
		this.s = null;
		this.info = null;
		this.i = 0;
		this.name = null;
		this.cost = null;
		this.amount = null;
		this.item_cost = 0;
		this.item_amount = 0;
		this.amount_remaining = 0;
		this.amt_rem = null;
		this.money = 0;
		this.owed = 0;
		this.change = 0;
		this.bottles = null;
		this.denom = null;
		this.quantity = null;
		this.currency_quantity = 0;
		this.quantity_remaining = 0;
		this.quant_rem = null;
		this.new_quantity = 0;
		this.total_bottle = bottle_item.getItem();
		this.total_bag = bag_item.getItem();
		this.paper_wrapper = paper_wrapper_item.getItem();
	}
	
	/**
     * Assign variable
     * @param	int money
     * @param	double total_bottle
     * @param	double total_bag 
     * @param	double total_paper_wrapper
     * @param	double owed
     * @param	String[] line
     * @param	String info
     * @param	String[] s
     * @param	Bottles bottle_item
     * @param	String name
     * @param	String cost
     * @param	String amount
     * @param	double item_cost
     * @param	int item_amount
     * @param	String amt_rem
     * @param	String bottles
     * @param	int item_num
     * @param	int amount_remaining
     * @param	String denom
     * @param	String quantity
     * @param	int currency_quantity
     * @param	int quantity_remaining
     * @param	String quant_rem
     * @param	int new_quantity
     * @param	double change
     * @param	Bags bag_item
     * @param	PaperWrapper paper_wrapper_item
     * @param	String paper_wrapper
     * @param	double total
     */
	YEN(int money, double total_bottle, double total_bag, double total_paper_wrapper, double owed, String[] line, String info, String[] s, Bottles bottle_item, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, String bottles, int item_num,	int amount_remaining, String denom,  String quantity, int currency_quantity, 
			int quantity_remaining, String quant_rem, int new_quantity, double change, Bags bag_item, PaperWrapper paper_wrapper_item,String paper_wrapper, double total) throws Exception
	{
		this.money = money;
		total_bottle = bottle_item.getItem();
		total_bag = bag_item.getItem();
		total_paper_wrapper = paper_wrapper_item.getItem();
		this.owed = owed;
		this.amount = amount;
		this.item_cost = item_cost;
		this.item_amount = item_amount;
		this.amt_rem = amt_rem;
		this.bottles = bottles;
		this.item_num = item_num;
		this.amount_remaining = amount_remaining;
		this.denom = denom;
		this.quantity = quantity;
		this.currency_quantity = currency_quantity;
		this.quantity_remaining = quantity_remaining;
		this.quant_rem = quant_rem;
		this.new_quantity = new_quantity;
		this.change = change;
		this.total = total;
		
		owed( money,  total_bottle,  total_bag,  total_paper_wrapper,  owed,  line,  info,  s, bottle_item,  name,  cost,
    		 amount,  item_cost,  item_amount,  amt_rem,  item_num,	 amount_remaining,  denom,   quantity,  currency_quantity, 
			 quantity_remaining,  quant_rem,  new_quantity,  change, bag_item, paper_wrapper_item,  total);
	}
	
	/**
     * Calculates remaining amount to pay
     * @param	int money
     * @param	double total_bottle
     * @param	double total_bag 
     * @param	double total_paper_wrapper
     * @param	double owed
     * @param	String[] line
     * @param	String info
     * @param	String[] s
     * @param	Bottles bottle_item
     * @param	String name
     * @param	String cost
     * @param	String amount
     * @param	double item_cost
     * @param	int item_amount
     * @param	String amt_rem
     * @param	String bottles
     * @param	int item_num
     * @param	int amount_remaining
     * @param	String denom
     * @param	String quantity
     * @param	int currency_quantity
     * @param	int quantity_remaining
     * @param	String quant_rem
     * @param	int new_quantity
     * @param	double change
     * @param	Bags bag_item
     * @param	PaperWrapper paper_wrapper_item
     * @param	String paper_wrapper
     * @param	double total
     * 
     * @return	double owed		amount remaining to pay
     */
	public static double owed(int money, double total_bottle, double total_bag, double total_paper_wrapper, double owed, String[] line, String info, String[] s, Bottles bottle_item, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, int item_num,	int amount_remaining, String denom,  String quantity, int currency_quantity, 
			int quantity_remaining, String quant_rem, int new_quantity, double change, Bags bag_item, PaperWrapper paper_wrapper_item, double total) throws Exception
    {
		if (total_bottle > 0)
		{
			owed = total_bottle;
			
		} else if (total_bag > 0) {
			owed = total_bag;
			
		} else if (total_paper_wrapper > 0) {
			owed = total_paper_wrapper;
		}
		
		System.out.println("Pay: $" + owed);
		
		while (owed > 0)
		{
			System.out.print( "1 - $0.05, 2 - $0.10, 3 - $0.25, 4 - $1.00, 5 - $5.00, 6 - $10.00, 7 - $20.00" + "\nEnter payment: ");
			money = input.nextInt();
			if ( (money >=1) || (money <= 7))
			{
				switch(money) 
				{
				    case 1:
					    owed = owed - 0.05;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				    case 2:
					    owed = owed - 0.10;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				    case 3:
					    owed = owed - 0.25;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				    case 4:
					    owed = owed - 1.00;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				    case 5:
					    owed = owed - 5.00;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				    case 6:
					    owed = owed - 10.00;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				    case 7:
					    owed = owed - 20.00;
					    pay(money, total,  denom,  s,  quantity,  currency_quantity,  quantity_remaining,  quant_rem, info,  line,  new_quantity);
					    System.out.println("$" + owed);
					    break;
				}
					
			} else {
				System.out.println("Please enter a valid option.");
				break;
			}
			
		} while (owed < 0) {
			owed *= -1;
			change = owed;
			calculateChange(money,  total,  owed,  line,  info,  s,bottle_item,  name,  cost, amount,  item_cost,  item_amount,  amt_rem,  quant_rem, item_num,  amount_remaining,  change,  denom,  
		    		 quantity,  currency_quantity,  quantity_remaining,  quant_rem,  new_quantity,  total_bottle,  total_bag,  total_paper_wrapper, bag_item, paper_wrapper_item, quant_rem, quant_rem);
		} while ((-0.01 <= owed) || (owed <= 0.01))
		{
			System.out.println();
			System.out.println("Transaction complete.");
			System.exit(0);
		}
		return owed;
	}
	
	/**
     * Prompts user to select currency. Stores selection.
     * @param 	int money
     * @param	double total
     * @param	String denom
     * @param	String[] s
     * @param	String quantity
     * @param	int currency_quantity
     * @param	int quantity_remaining
     * @param	String quant_rem
     * @param	String info
     * @param	String[] line
     * @param	int new_quantity 
     */
	public static void pay(int money, double total, String denom, String[] s, String quantity, int currency_quantity, int quantity_remaining, String quant_rem,
			String info, String[] line, int new_quantity ) throws Exception
	{
		try
		{
			File f = new File("YEN.txt");
			File fn = new File("YEN2.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16"));
	        
			BufferedWriter out = new BufferedWriter(new PrintWriter(fn, "UTF-16"));
			
		    for (int j = 0; j < line.length; j++)
		    {
		    	info = in.readLine();
		        if(info != null)
		        {
		        	
		        	if (j == money)
					{
			    		s = info.split("\\t");
			    		quantity = new String(s[2]);
			    			currency_quantity = Integer.parseInt(quantity);
				    		new_quantity = currency_quantity + 1;
				    		quant_rem = Integer.toString(new_quantity);
				    		s[2] = quant_rem;
				    		out.write(s[0] + "\t" + s[1] + "\t" + s[2] + "\n");
			    	} else {
				    	out.write(info + "\n");
				    }
		        }
		    }
		    fn.renameTo(f);
		    in.close();
			out.close();
	    } catch (Exception e) {
    	 System.out.println(e.getMessage());
        }
	}
	
	/**
     * Calculates change.
     * @param 	int money
     * @param	double total
     * @param	String denom
     * @param	String[] s
     * @param	String quantity
     * @param	int currency_quantity
     * @param	int quantity_remaining
     * @param	String quant_rem
     * @param	String info
     * @param	String[] line
     * @param	int new_quantity 
     */
	public static double calculateChange(int money, double total, double owed, String[] line, String info, String[] s, Bottles bottle_item, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, String bottles, int item_num, int amount_remaining, double change, String denom,  
    		String quantity, int currency_quantity, int quantity_remaining, String quant_rem, int new_quantity, double total_bottle, double total_bag, double total_paper_wrapper,
  		  Bags bag_item, PaperWrapper paper_wrapper_item, String bags, String paper_wrapper) throws Exception
	{
		System.out.println("Change owed: $" + change);
		
		if (change > 0)
		{
			if (change >= 20.00)
			{
				money = 7;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
				change = change - 20.00;
				
			} else if ((change >= 10.00) && (change < 20.00))
			{
				change = change - 10.00;
				money = 6;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
			} else if ((change >= 5.00) && (change < 10.00))
			{
				change = change - 5.00;
				money = 5;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
			} else if ((change >= 1.00) && (change < 5.00))
			{
				change = change - 1.00;
				money = 4;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
				
			} else if ((change >= 0.25) && (change < 1.00))
			{
				change = change - 0.25;
				money = 3;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
			} else if ((change >= 0.10) && (change < 0.25))
			{
				change = change - 0.10;
				money = 2;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
			} else if ((owed >= 0.05) && (owed < 0.10))
			{
				change = change - 0.05;
				money = 1;
				countYEN(money, total, denom, s, quantity, currency_quantity, quantity_remaining, quant_rem, info, line, new_quantity, owed, bottle_item, name, cost,
			    		 amount, item_cost, item_amount, amt_rem, item_num, amount_remaining, change,  total_bottle,  total_bag, total_paper_wrapper,
			    		 bag_item, paper_wrapper_item);
		    }
		} else if (change == 0)
		{
			System.out.println("Transaction complete.");
			System.exit(0);
		}
		return change;
	}
	
	/**
	 * @param	int money
     * @param	double total_bottle
     * @param	double total_bag 
     * @param	double total_paper_wrapper
     * @param	double owed
     * @param	String[] line
     * @param	String info
     * @param	String[] s
     * @param	Bottles bottle_item
     * @param	String name
     * @param	String cost
     * @param	String amount
     * @param	double item_cost
     * @param	int item_amount
     * @param	String amt_rem
     * @param	String bottles
     * @param	int item_num
     * @param	int amount_remaining
     * @param	String denom
     * @param	String quantity
     * @param	int currency_quantity
     * @param	int quantity_remaining
     * @param	String quant_rem
     * @param	int new_quantity
     * @param	double change
     * @param	Bags bag_item
     * @param	PaperWrapper paper_wrapper_item
     * @param	String paper_wrapper
     * @param	double total
     */
	public static void countYEN(int money, double total, String denom, String[] s, String quantity, int currency_quantity, 
			int quantity_remaining, String quant_rem, String info, String[] line, int new_quantity, double owed, Bottles bottle_item, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, int item_num,	int amount_remaining, double change, double total_bottle, double total_bag, double total_paper_wrapper,
    		  Bags bag_item, PaperWrapper paper_wrapper_item) throws Exception
	{
		try
		{
			File f = new File("YEN.txt");
			File fn = new File("YEN2.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16"));
			BufferedWriter out = new BufferedWriter(new PrintWriter(fn, "UTF-16"));
		    
			for (int j = line.length; j > 0; j--)
		    {
		        info = in.readLine();
		        if(info != null)
		        {
		        	if (money == line.length - j)
		        	{
		        		s = info.split("\\t");
			    		quantity = new String(s[2]);
			    		currency_quantity = Integer.parseInt(quantity);
			    		new_quantity = currency_quantity - 1;
			    		quant_rem = Integer.toString(new_quantity);
			    		s[2] = quant_rem;
			    		out.write(s[0] + "\t" + s[1] + "\t" + s[2] + "\n");	
				    } else {
				    	out.write(info + "\n");
				    }
		        }
		    }
		    fn.renameTo(f);
		    in.close();
			out.close();
			calculateChange(money, total, owed, line, info, s, bottle_item, name, cost, amount, item_cost, item_amount, amt_rem, quant_rem, item_num, amount_remaining, change, denom,  
		    		 quantity, currency_quantity, quantity_remaining, quant_rem, new_quantity, total_bottle, total_bag, total_paper_wrapper, bag_item, paper_wrapper_item, quant_rem, quant_rem);
		
	    } catch (Exception e) {
    	 System.out.println(e.getMessage());
        }
	}
}
