package DeckofCardsUsingPlayerObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;


//CREATING CARD NODE FOR CARD QUEUE 
class cardNode
{
	String card;
	cardNode nextCardNode = null;
} 


//CREATING QUEUE USING LINK LIST
class queueOfCards<T>
{ 
	//headCardNode cardNode TYPE VAIABLE
	cardNode headCardNode = new cardNode();
	int size = 0;


	//ENQUEUE METHOD
	public void enqueue(String card)
	{
		//VARIABLES OF CARD NODE
		cardNode addingCardNewCardNode = new cardNode();
		addingCardNewCardNode.card = card;
		addingCardNewCardNode.nextCardNode = null;


		if(headCardNode.nextCardNode == null )
		{
			headCardNode.nextCardNode = addingCardNewCardNode;
			size++;
		}
		else
		{
			cardNode temporaryHeadCardNode = headCardNode;
			while(temporaryHeadCardNode.nextCardNode != null)
			{
				temporaryHeadCardNode = temporaryHeadCardNode.nextCardNode;
			}
			temporaryHeadCardNode.nextCardNode = addingCardNewCardNode;
			size++;
		}
	}


	//DEQUEUE METHOD
	String dequeue()
	{
		if(headCardNode.nextCardNode == null)
		{
			System.out.println("Queue is empty");
			return "";
		} 
		else
		{	
			cardNode previousHeadCardNode = headCardNode.nextCardNode; 			
			headCardNode.nextCardNode = headCardNode.nextCardNode.nextCardNode;	
			size--;
			return previousHeadCardNode.card;			
		}
	}		


	//METHOD TO SHOW LIST OF CARDS 
	public void showCardQueue()
	{
		try 
		{
			//VARIABLES
			cardNode temporaryHeadCardNode = headCardNode;


			while(temporaryHeadCardNode.nextCardNode != null)
			{
				temporaryHeadCardNode = temporaryHeadCardNode.nextCardNode;
				System.out.println(temporaryHeadCardNode.card);
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("Queue endded");
		}
	}


	//METHOD OF SORTING CARDS
	void saveSortedCards() throws IOException,FileNotFoundException
	{
		//ARRAY OF STRING
		String[] arrayForSortingcards = new String[size];


		//VARIABLES
		cardNode temporaryHeadCardNode2 = headCardNode;
		int arrayIndex = 0;


		//ADDING LIST'S cardS INTO ARRAY
		while(temporaryHeadCardNode2.nextCardNode != null)
		{				
			temporaryHeadCardNode2 = temporaryHeadCardNode2.nextCardNode;
			arrayForSortingcards[arrayIndex] = temporaryHeadCardNode2.card;				
			arrayIndex++;
		}


		//SORTING ARRAY AND ADDING INTO FILE
		for(int arrayIndex2=0; arrayIndex2<arrayForSortingcards.length; arrayIndex2++)
		{
			for(int arrayIndex3=arrayIndex2+1; arrayIndex3<arrayForSortingcards.length; arrayIndex3++)
			{
				//SPLITING ARRAY DATA INTO RANK AND SUIT
				String [] arrayOfRank1 = (arrayForSortingcards[arrayIndex2]).split("-",2);
				String [] arrayOfRank2 = (arrayForSortingcards[arrayIndex3]).split("-",2);


				//SORTING ARRAY
				if(0 < (arrayOfRank1[1].compareTo(arrayOfRank2[1])))
				{					
					String temparorySwapVairable = arrayForSortingcards[arrayIndex2];
					arrayForSortingcards[arrayIndex2] = arrayForSortingcards[arrayIndex3];
					arrayForSortingcards[arrayIndex3] = temparorySwapVairable;		
				}
			}
		}


		//VARIABLES
		cardNode temporaryHeadCardNode = headCardNode;
		int arrayIndex1 = 0;


		//ADDING CARDS FORM QUEUE TO ARRAY
		while(temporaryHeadCardNode.nextCardNode != null)
		{				
			temporaryHeadCardNode = temporaryHeadCardNode.nextCardNode;
			temporaryHeadCardNode.card = arrayForSortingcards[arrayIndex1];				
			arrayIndex1++;
		}
	}
}


//CARDS CLASS
class Cards
{
	//ARRAYS RANK,SUTI AND PLAYER
	String[] RANK = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack", "Queen", "King", "Ace"};
	String[] SUIT = {"Clubs","Diamonds", "Hearts","Spades"};
	String[] PLAYER = {"player1","player2","player3","player4"};
	
	
	//2-D ARRAY CARDS
	String[][] cards = new String[SUIT.length][RANK.length];


	//CREATED OBJECTS OF LINK LIST OF CARDS CLASS (HAS-A RELATIONSHIP - COMPOSITION)
	queueOfCards queueOfCardsObject1 = new queueOfCards();
	queueOfCards queueOfCardsObject2 = new queueOfCards();
	queueOfCards queueOfCardsObject3 = new queueOfCards();
	queueOfCards queueOfCardsObject4 = new queueOfCards();


	//SHUFFLE METHOD
	void shuffle() throws FileNotFoundException, IOException
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


				if(suitIterator == 0)
					queueOfCardsObject1.enqueue("Player"+(suitIterator+1)+" : "+cards[row][column]);				
				else if(suitIterator == 1 )
					queueOfCardsObject2.enqueue("Player"+(suitIterator+1)+" : "+cards[row][column]);
				else if(suitIterator == 2)
					queueOfCardsObject3.enqueue("Player"+(suitIterator+1)+" : "+cards[row][column]);
				else if (suitIterator == 3)
					queueOfCardsObject4.enqueue("Player"+(suitIterator+1)+" : "+cards[row][column]);	
				cards[row][column] = null;
			}
		}	
	}


	//SHOW PLAYER AND CARDS
	void showPlayerAndCardsInSortedOrder() throws FileNotFoundException, IOException
	{
		System.out.println("********** Player 1 cards : **********");
		queueOfCardsObject1.saveSortedCards();
		queueOfCardsObject1.showCardQueue();
		System.out.println();


		System.out.println("********** Player 2 cards : **********");
		queueOfCardsObject2.saveSortedCards();
		queueOfCardsObject2.showCardQueue();
		System.out.println();
		

		System.out.println("********** Player 3 cards : **********");
		queueOfCardsObject3.saveSortedCards();
		queueOfCardsObject3.showCardQueue();
		System.out.println();
		

		System.out.println("********** Player 4 cards : **********");
		queueOfCardsObject4.saveSortedCards();
		queueOfCardsObject4.showCardQueue();
	}
}


public class DeckofCardsUsingPlayerObject
{
	public static void main(String[] args) throws FileNotFoundException, IOException 
	{
		Cards cardsObject = new Cards();
		queueOfCards queueOfCardsObject = new queueOfCards();
		cardsObject.shuffle();
		cardsObject.showPlayerAndCardsInSortedOrder();
	}
}
