import java.util.ArrayList;

public class Main
{
   //Static constants
	private static final String DESCRIPTIONS[] = {"Shirt", "Pants", "Tie", "Socks", "Skirt", "Dress", "Shoes"};
	private static final double PRICES[] = {25, 41.5, 17.5, 7, 37, 125, 68.43};
	private static final int RANGE = 7;
   private static double RETURN_CHANCE = .15;
   private static final int INITIAL_SALES = 30, MIN_TRANSACTIONS = 50, MAX_TRANSACTIONS = 100;
	
   //Static variables
	private static ArrayList<Transaction> transactions;
	
   /*
      The run() method runs the simulation.
      It instantiates the ArrayList and populates it with sales.
      It loops through a random number of sales (based on a range) and adds transactions.
      There is a small percentage that the transaction will be a return.
      Otherwise, it's a sale.
      
      Once all of the transactions have been completed, it displays the results of the day.
   */
	private static void run()
	{
		transactions = new ArrayList<Transaction>();
      
      //Create initial sales
      for (int i = 0; i < INITIAL_SALES; i++)
         addSale();

		int numTransaction = Dice.getRandomInteger(MIN_TRANSACTIONS, MAX_TRANSACTIONS);
		for (int i = 0; i < numTransaction; i++)
		{
			if (Math.random() < RETURN_CHANCE)
				addReturn();
			else
				addSale();
		}
      
      displayResults();
	}
   
   /*
      Adds up all of the money for all of the transactions and returns that total.
      All transactions are added to the total because returns count as sales (you have to have sold something to have it returned).
   */
   private static double getTotalSales()
   {
      double money = 0;
      for (Transaction t : transactions)
         money += t.getTotalCost();
         
      return money;
   }
   
   /*
      Adds up all of the money for all of the Return transactions and returns that total.
      ONLY the money from returns is added.
      
      WRITE THIS METHOD
   */
   private static double getTotalReturns()
   {
   }
   
   /*
      Counts the number of transactions that are Returns and returns that number.
      It returns the number of Returns.
     
   */
   public static int getNumReturns()
   {
   }
   
   /*
      This takes a double and trims it down to 2 decimal places, returning the result.
   */
   private static double formatMoney(double dub)
   {
      int x = (int)(Math.round(dub * 100));
      dub = x / 100.0;
      return dub;
   }
	
   /*
      Adds a Sale to the transaction list.
   */
	private static void addSale()
	{
		int idx = Dice.getRandomInteger(0, DESCRIPTIONS.length - 1);
		transactions.add(new Sale(DESCRIPTIONS[idx], Dice.getRandomInteger(1, RANGE), PRICES[idx], Math.random() < .5));
	}
	
   /*
      Adds a return to the transaction list.
      For the purposes of this simulation, it chooses a random Sale.
      The Sale object is replaced in the ArrayList with a Return for that Sale.
   */
	private static void addReturn()
	{
		int saleIdx;
		do
		{
			saleIdx = Dice.getRandomInteger(0, transactions.size() - 1);
		} while(!(transactions.get(saleIdx) instanceof Sale));
		
		transactions.set(saleIdx, new Return((Sale)transactions.get(saleIdx)));
	}
   
   //Display
   public static void displayResults()
   {
      int numReturns = getNumReturns();
		System.out.println("Total Transaction:  " + (transactions.size() + numReturns));
		System.out.println("Total Sales:  " + transactions.size());
		System.out.println("Total Returns:  " + numReturns);
		System.out.println("Total Sales:  $" + formatMoney(getTotalSales()));
		System.out.println("Total Returns:  $" + formatMoney(getTotalReturns()));
   }
	
   //main
	public static void main(String args[])
	{
		run();
	}
}