/** 
 * EN.605.201 Introduction to Java Programming
 * This is the PaperWrapper class for Vending Machine Simulator which stores the candy.
 * The user is prompted to select their candy and their total is displayed. 
 * The user is then prompted to select a currency.
 * 
 * @version		1.0 January 27, 2020
 * @author		shanzalewis
 */

import java.io.*;
import java.util.*;

public class PaperWrapper
{
	public static Scanner input = new Scanner(System.in); 
	String paper_wrapper;
	int item_num;
	String[] line;
	String[] s;
	String info;
	int i;
	String name;
	String cost;
	String amount;
	double item_cost;
	int item_amount;
	int amount_remaining;
	String amt_rem;
	
	PaperWrapper()    //empty constructor
	{
		this.item_num = 0;
		this.paper_wrapper = null;
		this.line  = new String[100];
		this.s = new String[100];
		this.info = null;
		this.i = 0;
		this.name = null;
		this.cost = null;
		this.amount = null;
		this.item_cost = 0;
		this.item_amount = 0;
		this.amount_remaining = 0;
		this.amt_rem = null;
	}
	
	/**
     * Prompts user to select candy and sets variables.
     * @param	String[]line
     * @param	String[]s
     * @param	String info
     * @param	String name
     * @param	String cost
     * @param	String amount
     * @param	double item_cost
     * @param	int item_amount
     * @param	String amt_rem
     * @param	String bags
     * @param	int item_num
     * @param	int amount_remaining
     */
    PaperWrapper(String[]line, String[]s, String info, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, String paper_wrapper, int item_num,
    		int amount_remaining) throws Exception
	{
    	this.line = line;
    	this.s = s;
    	this.info = info;
    	this.name = name;
    	this.cost = cost;
    	this.amount = amount;
    	this.amt_rem = amt_rem;
    	this.paper_wrapper = "Row3 - Paper Wrapper.txt";
    	this.item_num = item_num;
    	this.amount_remaining = amount_remaining;
    	
    	System.out.println();
		System.out.print("1 - Snickers ($10.25), 2 - Kit Kat ($5.00), 3 - Mars ($4.00), 4 - Muskateers ($6.00)" + "\nSelect Item: ");
		item_num = (input.nextInt()*2) - 1;
		setItem(line, s, info, name, cost,	amount, item_cost, item_amount, amt_rem, paper_wrapper, item_num, amount_remaining);
	}
    
    public void setItem(String[] line, String[]s, String info, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, String paper_wrapper, int item_num,
    		int amount_remaining) throws Exception
	{
    	try
		{
			File f = new File("Row3 - Paper Wrapper.txt");
			File fn = new File("PW2.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16")); 
			BufferedWriter out = new BufferedWriter(new PrintWriter(fn,"UTF-16" ));
			for (int j = 0; j < line.length; j++)
			{
			    info = in.readLine();                 //reads each line of file while the line is not empty
			    if(info != null)
			    {
			    	if (j == item_num)                //checks if the line is the selected item
					{
			    		s = info.split("\\t");        //splits the line by tab character into String array
			    		cost = s[2].toString();
			    		cost = cost.trim().replace('$', ' '); //removes $ sign trims third column
			    		item_cost = Double.parseDouble(cost); //changes third string to double
			    		
			    		amount = new String (s[3]); //sets fourth string in line to quantity of selected snacks available in the vending machine
		    			item_amount = Integer.parseInt(amount); //changes string to integer
			    		amount_remaining = item_amount - 1;      //reduces quantity of selected item by 1
			    		amt_rem = Integer.toString(amount_remaining); //changes back quantity to String
			    		s[3] = amt_rem;                               //sets fourth string in line of data to reduced quantity
			    		out.write(s[0] + "\t" + s[1] + "\t" + s[2] + "\t" + s[3] + "\n"); //writes updated line to new file
			         } else {
			        	 out.write(info + "\n");        //writes each line of file to new file
			         }
			    }
			}
			fn.renameTo(f);                            //rename new file to old file and delete old file
			in.close();                                //close old file
			out.close();                               //close new file
		} catch (Exception e) {
	    	 System.out.println(e.getMessage());       //catches and prints error message
        }
    	this.item_cost = item_cost;      
	}
	
    /**
     * Returns price of item 
     * @return	double item_cost		cost of selected item
     */
	public double getItem()
	{
		return item_cost;
	}

    /**
     * Prompts user to select currency. Stores selection.
     * @return	int currency	currency selection
     */
    public static int getCurr()
    {
    	System.out.println();
    	System.out.print("1 - USD, 2 - YEN, 3 - EURO" + "\nSelect currency: ");
		int currency = input.nextInt();
		
		return currency;
    }
    
    /**
     * Switches between currencies based on user selection.
     * Prompts user for valid entry.
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
	public static void calcItemCurr(int money, double total_bottle, double total_bag, double total_paper_wrapper, double owed, String[] line, String info, String[] s, Bottles bottle_item, String name, String cost,
    		String amount, double item_cost, int item_amount, String amt_rem, String bottles, int item_num,	int amount_remaining, String denom,  String quantity, int currency_quantity, 
			int quantity_remaining, String quant_rem, int new_quantity, double change, Bags bag_item, PaperWrapper paper_wrapper_item,String paper_wrapper, double total) throws Exception
    {
    	int currency = getCurr();
		
		if((currency >= 1) || (currency <= 3))
		{
			switch(currency)
			{
			    case 1:
			    	//new USD class
		    	    USD usdclass = new USD(money, total_bottle, total_bag, total_paper_wrapper, owed, line, info, s, bottle_item, name, cost,
		    	    		 amount, item_cost, item_amount, amt_rem, bottles, item_num, amount_remaining, denom, quantity, currency_quantity, 
		    				 quantity_remaining, quant_rem, new_quantity, change, bag_item, paper_wrapper_item, paper_wrapper, total);
		    	    break;
			    case 2:
			    	//new YEN class
		        	YEN yenclass = new YEN(money, total_bottle, total_bag, total_paper_wrapper, owed, line, info, s, bottle_item, name, cost,
		    	    		 amount, item_cost, item_amount, amt_rem, bottles, item_num, amount_remaining, denom, quantity, currency_quantity, 
		    				 quantity_remaining, quant_rem, new_quantity, change, bag_item, paper_wrapper_item, paper_wrapper, total);
		    	    break;
		        case 3:
		    	    //new EURO class
		    	    EURO euroclass = new EURO(money, total_bottle, total_bag, total_paper_wrapper, owed, line, info, s, bottle_item, name, cost,
		    	    		 amount, item_cost, item_amount, amt_rem, bottles, item_num, amount_remaining, denom, quantity, currency_quantity, 
		    				 quantity_remaining, quant_rem, new_quantity, change, bag_item, paper_wrapper_item, paper_wrapper, total);
		    	    break;
			}
		} else {
			System.out.println("1 - USD, 2 - YEN, 3 - EURO" + "\nPlease enter a valid option: ");
			calcItemCurr(money, total_bottle, total_bag, total_paper_wrapper, owed, line, info, s, bottle_item, name, cost,
	   	    		 amount, item_cost, item_amount, amt_rem, bottles, item_num, amount_remaining, denom, quantity, currency_quantity, 
	   				 quantity_remaining, quant_rem, new_quantity, change, bag_item, paper_wrapper_item, paper_wrapper, total);
		}
    }
}