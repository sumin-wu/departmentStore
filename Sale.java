//Sale Class
public class Sale extends Transaction
{
   //Instance Variables
	public boolean cash;    //Is or isn't a cash sale
	
   //Constructor
	public Sale(String desc, int num, double cost, boolean c)
	{
		super(desc, num, cost);
		cash = c;
	}
	
   //Accessors
	public boolean isCash()				{return cash;}
	
   /*
      The total cost for a sale is the same as the total cost for a regular transaction
      EXCEPT
      there is a 3% fee added if it is not a cash sale.
      
      WRITE THIS METHOD
   */
	public double getTotalCost()
	{
	}
}