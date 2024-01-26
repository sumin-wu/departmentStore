//Basic Transaction class
public class Transaction
{
   //Instance Variables
	private String description;
	private int numItems;
	private double itemCost;
	
   //Constructor
	public Transaction(String desc, int items, double cost)
	{
		description = desc;
		numItems = items;
		itemCost = cost;
	}
	
   //Accessors
	public String getDescription()		{return description;}
	public double getItemCost()			{return itemCost;}
	public int getNumItems()			{return numItems;}
	
	public double getTotalCost()
	{
		return numItems * itemCost;
	}
}