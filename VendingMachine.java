import java.util.Scanner;

/**
 *The vending machine class shows the items and money used to process the vending machine
 * It also performs the buy and sell process that is carried out between the vending machine and costumer
 * Arrays and method calling were used to carry out this transaction
 * @author ValentineEzenwa
 */
public class VendingMachine
{
    Scanner in = new Scanner (System.in);
    public int[] qty = {5, 5, 5, 5, 5, 5}; //quantity of each item
    public String[] items = {"coke", "sprite", "peanuts", "cookies", "oreo", "starburst"}; //item name
    public int [] amount = { 5, 15, 25, 25 }; //quantity of money
    public double [] money = { 5, 1, 0.25, 0.10 }; //money inserted
    
    int dispItem;  //item dispensed 
    double change;  //change dispensed
    
    //display item, quantity of item and price of item
    public void displayInv()
    {
	System.out.println(items[0] + ": qty: " + qty[0] + " $1.50" );
	System.out.println(items[1] + ": qty: " + qty[1] + " $1.50 " );
	System.out.println(items[2] + ": qty: " + qty[2] + " $2.00 " );
	System.out.println(items[3] + ": qty: " + qty[3] + " $2.00 " );
	System.out.println(items[4] + ": qty: " + qty[4] + " $1.00 " );
	System.out.println(items[5] + ": qty: " + qty[5] + " $1.00 " );
    }
	
    //display quantity of money present and money value
    public void displayCurrency()
    {
        System.out.println(amount[0] + " : $" + money[0] );
	System.out.println(amount[1] + " : $" + money[1] );
	System.out.println(amount[2] + " : $" + money[2] );
	System.out.println(amount[3] + " : $" + money[3] );
    }
    /**
     * this methods dispenses the item from vending machine if money is sufficient  
     * @param pay equals money returned by the vending machine that was initially paid by costumer.
     * @param remainder equals remaining money after money has been inserted into vending machine
     */
    public void changeCheck(double pay, double remainder) 
    {
	while(remainder < 0) 
	{
	    dispItem = 0; //implies money is not enough
	    System.out.println("Insufficient funds" );
	    System.out.println("Do you want to continue? (Yes or No): ");
	    String inp = in.next();  //user inputs yes or no
	    if (inp.equalsIgnoreCase("Yes"))
	    {
	        System.out.println("what type of money are you using ");
		Double newPay = in.nextDouble();  //initial money inserted into vending machine
                System.out.println(remainder);
		remainder = newPay + remainder;
                System.out.println(remainder);
                
                if(remainder == 0)
		{
                    dispItem = 1;  //implies money is sufficient 
		}
		
		else if(remainder > 0) 
		{
		    dispItem = 1;
		    dispChange(remainder);
		}
	    }
	    else if(inp.equalsIgnoreCase("No"))
	    {
		System.out.println("$" + pay + " returned");  //money is given back
         
		if(pay == 1.0)
		{
		    amount[1] -= 1;
		}
		else if(pay == 0.25)
		{
		    amount[2] -= 1;
		}
		else if(pay == 0.10) 
		{
		    amount[3] -= 1;
		}
		remainder = 0.0;
	    }
			
	}
		
	if(change == 0)
	{
            dispItem = 1;
	}
		
	else if(change > 0) 
	{
            dispItem = 1;
            dispChange(change);
        }
    }
	
    /**
     * This method shows the transaction carried out once an item has been selected and paid for by costumer
     * @param input equals the item typed by costumer   
     * @param pay equals money entered by costumer 
     */
    public void check(String input, double pay)
    {
		
        if (input.equalsIgnoreCase("coke"))
	{
	    change = pay - 1.50;
            changeCheck(pay, change);
	    if(dispItem == 1) 
            {
		if(qty[0] > 0)
                {
		    System.out.println("coke is dispensed");
		}
		else 
                {
		    System.out.println("Out of coke");
		}
		qty[0] = qty[0] - 1;
            }
	}
		
	else if (input.equalsIgnoreCase("sprite"))
	{
	    change = pay - 1.50;
	    changeCheck(pay, change);
			
	    if(dispItem == 1) 
            {
		if(qty[1] > 0)
	        {
		    System.out.println("sprite is dispensed");
	        }
	        else
                {
	            System.out.println("Out of sprite");
	        }
	        qty[1] = qty[1] - 1;
	    }
        }
		
	else if (input.equalsIgnoreCase("peanuts"))
	{
	    change = pay - 2.0;
	    changeCheck(pay, change);
			
	    if(dispItem == 1) 
            {
	        if(qty[2] > 0)
		{
		    System.out.println("peanuts is dispensed");
		}
		else 
                {
		    System.out.println("Out of peanuts");
		}
		qty[2] = qty[2] - 1;
	    }
	}
		
	else if (input.equalsIgnoreCase("cookies"))
	{
	    change = pay - 2.0;
	    changeCheck(pay, change);
			
	    if(dispItem == 1) 
            {
	        if(qty[3] > 0)
		{
		    System.out.println("cookies is dispensed");
		}
		else 
                {
		    System.out.println("Out of cookies");
		}
		qty[3] = qty[3] - 1;
	    }
        }
		
	else if (input.equalsIgnoreCase("oreo"))
	{
	    change = pay - 1.0;
	    changeCheck(pay, change);
			
	    if(dispItem == 1)
            {
	        if(qty[4] > 0)
		{
		    System.out.println("oreo is dispensed");
		}
		else 
                {
		    System.out.println("Out of oreo");
		}
		qty[4] = qty[4] - 1;
	    }
	}
		
	else if (input.equalsIgnoreCase("starburst"))
	{
	    change = pay - 1.0;
	    changeCheck(pay, change);
			
	    if(dispItem == 1) 
	    {
	        if(qty[5] > 0)
                {
		    System.out.println("starburst is dispensed");
		}
		else
                {
		    System.out.println("Out of starburst");
		}
		qty[5] = qty[5] - 1;
	    }
	}
        else
        {
            System.out.println(" item not available ");
            System.out.println("$" + pay + " returned");
            if(pay == 5.0)
            {
                amount[0] -= 1;
            }
            else if(pay == 1.0)
            {
                amount[1] -= 1;
            }
            else if(pay == 0.25)
            {
                amount[2] -= 1;
            }
            else if(pay == 0.10) 
            {
                amount[3] -= 1;
            }
        }    
    }
	
    /**
     * This method allows user to select item to be purchased
     * It also allows user to specify the type of money used to carry out the transaction
     */
    public void moneyUsed()
    {
        System.out.println("Type item you want to purchase");
	String inp = in.next();
	System.out.println("what type of money are you using ");
	Double newPay = in.nextDouble();
	if (newPay == 5.0)
	{
	    amount[0] = amount[0] + 1;
	    check(inp, newPay);
        }
	else if (newPay == 1.0)
	{
	    amount[1] = amount[1] + 1;  
	    check(inp, newPay);
	}
	else if (newPay == 0.25)
	{
	    amount[2] = amount[2] + 1;
	    check(inp, newPay);
	}
	else if (newPay == 0.10)
	{
	    amount[3] = amount[3] + 1;
	    check(inp, newPay);
	}
	    	
    }
    
    /**
     * @param remainder calculates the change to be dispensed back to costumer after transaction is complete
     * casting was used in order to make the calculation more simple
     */
    public void dispChange(double remainder)
    {
	int x = (int)remainder; 
	double t = remainder / 0.25;
	double u = remainder / 0.10;
	if (amount[1] >= x )
	{
	    amount[1] = amount[1] - x;
	    System.out.print("change = " + x);
	}
	else if (amount [1] < x)
	{
	    t = remainder / 0.25;
	    System.out.println(t + "0.25 ");
	    amount[2] = amount[2] - (int)t;
	}
	else if (amount[2] < t)
	{
	    u = remainder / 0.10;
	    System.out.println(u + "0.25 "); 
	    amount[3] = amount[3] - (int)u;
	}
	else if (amount[3] < u)
	{
	    System.out.println("print no change");
	}
        double y = remainder - x;
        System.out.println("."+ (int)(y*100));
        double z = y / 0.25;
        amount[2] = amount[2] - (int)z;
        double a = 0;
        if (amount [2] < 0)
        {
            a = y / 0.10;
            System.out.println(a + "0.10");
        }
        else if ( amount[3] < a )
        {
            System.out.println("no change available" );
        }
    }
} 
