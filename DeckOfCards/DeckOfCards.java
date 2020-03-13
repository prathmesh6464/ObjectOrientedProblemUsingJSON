package DeckOfCards;
import java.util.Random;


//CARDS CLASS
class Cards
{
	//ARRAYS
	String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	String[] suit = {"Clubs","Diamonds", "Hearts","Spades"};
	String[][] cards = new String[suit.length][rank.length];
	String[] player = {"player1","player2","player3","player4"};


	//SHUFFLE METHOD
	void shuffle()
	{
		//RANDOM NUMBER GENERATION
		Random randomCards = new Random();
		int row = randomCards.nextInt(suit.length);
		int column = randomCards.nextInt(rank.length);


		//INSETING CARDS AND FETCHING CARDS FROM 2-D ARRAYS
		for (int suitIterator=0; suitIterator<suit.length; suitIterator++)
		{
			for(int rankIterator=0; rankIterator<rank.length; rankIterator++)
			{
				cards[suitIterator][rankIterator] = suit[suitIterator] + "-" + rank[rankIterator];
			}
			for(int rankIterator=0; rankIterator<rank.length-4; rankIterator++)
			{
				while(cards[row][column] == null)
				{
					row = randomCards.nextInt(suit.length);
					column = randomCards.nextInt(rank.length);
				}
				System.out.println(player[suitIterator]+ " : " + cards[row][column]);
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
