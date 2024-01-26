//The Return Class
public class Return extends Transaction
{
   //Instance variables
	private Sale returned;     //The original sale
	
   //Constructor
   /*
      The return is built off of the information generated by the sale.
      The returned object IS the sale.
      
      
   */
	public Return(Sale s)
	{
	}
	
   //Accessors
	public boolean isCash()						{return returned.isCash();}
	
   /*
      The total cost of the return is the total cost of the original sale.
      
   */
	public double getTotalCost()
	{
	}
}