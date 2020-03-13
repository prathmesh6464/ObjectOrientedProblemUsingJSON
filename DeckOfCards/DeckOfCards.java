package DeckOfCards;
import java.util.Random;

class Cards
{
	String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	String[] suit = {"Clubs","Diamonds", "Hearts","Spades"};
	String[][] cards = new String[suit.length][rank.length];
	String[] player = {"player1","player2","player3","player4"};


	void shuffle()
	{
		Random randomCards = new Random();
		int row = randomCards.nextInt(4);
		int column = randomCards.nextInt(13);


		for (int suitIterator=0; suitIterator<suit.length; suitIterator++)
		{
			for(int rankIterator=0; rankIterator<rank.length; rankIterator++)
			{
				cards[suitIterator][rankIterator] = suit[suitIterator] + " " + rank[rankIterator];
			}
			for(int rankIterator=0; rankIterator<rank.length-4; rankIterator++)
			{
				while(cards[row][column] == null)
				{
					row = randomCards.nextInt(4);
					column = randomCards.nextInt(13);
				}
				System.out.println(player[suitIterator]+ " : " + cards[row][column]);
				cards[row][column] = null;
			}
			System.out.println();
		}
	}	
}


public class DeckOfCards
{
	public static void main(String[] args) 
	{
		Cards cards = new Cards();
		cards.shuffle();
	}
}
