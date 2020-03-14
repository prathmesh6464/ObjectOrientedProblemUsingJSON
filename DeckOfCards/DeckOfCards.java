package DeckOfCards;
import java.util.Random;


//CARDS CLASS
class Cards
{
	//ARRAYS
	String[] RANK = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	String[] SUIT = {"Clubs","Diamonds", "Hearts","Spades"};
	String[] PLAYER = {"player1","player2","player3","player4"};
	
	
	//2-D ARRAY CARDS
	String[][] cards = new String[SUIT.length][RANK.length];


	//SHUFFLE METHOD
	void shuffle()
	{
		//RANDOM NUMBER GENERATION
		Random randomCards = new Random();
		int row = randomCards.nextInt(SUIT.length);
		int column = randomCards.nextInt(RANK.length);


		//INSETING CARDS FROM 2-D ARRAYS
		for (int suitIterator=0; suitIterator<SUIT.length; suitIterator++)
		{
			for(int rankIterator=0; rankIterator<RANK.length; rankIterator++)
			{
				cards[suitIterator][rankIterator] = SUIT[suitIterator] + "-" + RANK[rankIterator];				
			}
		}
		
		
		//FETCHING CARDS FROM 2-D ARRAYS
		for (int suitIterator=0; suitIterator<SUIT.length; suitIterator++)
		{
			for(int rankIterator=0; rankIterator<RANK.length-4; rankIterator++)
			{
				while(cards[row][column] == null)
				{
					row = randomCards.nextInt(SUIT.length);
					column = randomCards.nextInt(RANK.length);
				}
				System.out.println(PLAYER[suitIterator]+ " : " + cards[row][column]);
				cards[row][column] = null;
			}
			System.out.println();
		}
	}	
}


//DECK OF CARDS
public class DeckOfCards
{
	//MAIN METHOD
	public static void main(String[] args) 
	{
		//SHUFFLE METHOD CALLED
		Cards cards = new Cards();
		cards.shuffle();
	}
}
