public final class Dice
{
	//The constructor of this class is private in order to prevent instantiation of an object.
   private Dice(){}
   
	/*
		The getRandomInteger() method returns a random number between lower and upper (inclusive).
	*/
   public static int getRandomInteger(int lower, int upper)
   {
   	//R = (rnd * (u - (L - 1)) + L
   	int multiplier = upper - (lower - 1);
   	return (int)(Math.floor(Math.random() * multiplier)) + lower;
   }

	/*
		The rollDie() static method returns a random result (a die roll) using a die of numSides sides.
	*/
   public static int rollDie(int numSides)
   {
      return getRandomInteger(1, numSides);
   }

	/*
		The rollDie() static method returns a random result (a die roll) using a 6 sided die.
	*/
   public static int rollDie()
   {
      return rollDie(6);
   }
   
	/*
		The rollDice() static method returns a random result using numDice dice of numSides sides.
	*/
   public static int rollDice(int numSides, int numDice)
   {
      int total = 0;
      for (int i = 0; i < numDice; i++)
         total += rollDie(numSides);
         
      return total;
   }
   
	/*
		The rollDice() static method returns a random result using numDice dice of 6 sides.
	*/
   public static int rollDice(int numDice)
   {
      return rollDice(6, numDice);
   }
}