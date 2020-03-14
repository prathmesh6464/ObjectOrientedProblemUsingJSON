package DeckofCardsUsingPlayerObject;
import java.util.Random;
import java.util.Scanner;


//CREATING NODE FOR LINK LIST
class Node
{
	String expression;
	Node nextNode = null;
} 


//CREATING LINK LIST CLASS
class StackList<T>
{
	//NODE TYPE VAIABLE
	Node headNode = new Node();
	int size = 0;


	//EMPTY STACK METHOD
	Node stack()
	{
		return headNode;
	} 


	//METHOD OF TAKING INPUT
	String takeInput()
	{
		System.out.println("Enter your expression : ");
		Scanner scannerObject = new Scanner(System.in);
		String expressionInput = scannerObject.next();
		return expressionInput;		
	}


	//PUSH METHOD
	public void push(String expression)
	{
		//VARIABLES OF NODE	
		Node addingExpression = new Node();
		addingExpression.expression = expression;
		addingExpression.nextNode = null;


		if(headNode.nextNode == null )
		{
			headNode.nextNode = addingExpression;
			size++;
		}
		else
		{
			Node temporaryHeadNode = headNode;
			while(temporaryHeadNode.nextNode != null)
			{
				temporaryHeadNode = temporaryHeadNode.nextNode;
			}
			temporaryHeadNode.nextNode = addingExpression;
			size++;
		}
	}


	//METHOD TO SHOW STACK
	public void showStack()
	{
		//VARIABLE
		Node temporaryHeadNode = headNode;


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
			System.out.println(temporaryHeadNode.expression);
		}
	}


	//POP METHOD
	String pop()
	{
		if(headNode.nextNode == null)
		{
			System.out.println("Stack is empty");
			return "";
		}
		else
		{	
			//VARIABLE
			int temparoryIter = 0;
			Node temparoryHead = headNode;


			for(temparoryIter=0; temparoryIter<size; temparoryIter++)
			{
				temparoryHead = temparoryHead.nextNode;
			}


			String returnWord = temparoryHead.expression;
			temparoryHead.nextNode = null;
			size--;
			return returnWord;
		}
	}


	//PEEK METHOD
	String peek()
	{
		//VARIABLE
		Node temporaryHeadNode = headNode;


		while(temporaryHeadNode.nextNode != null)
		{
			temporaryHeadNode = temporaryHeadNode.nextNode;
		}
		return temporaryHeadNode.expression;
	}


	//METHOD OF SIZE
	int size()
	{
		return size;
	}


	//STACK EMPTY OR NOT
	void isEmpty()
	{
		if(size == 0)
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println("Stack is Not empty");
		}
	}
}


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


		//INSETING CARDS FROM 2-D ARRAYS
		for (int suitIterator=0; suitIterator<suit.length; suitIterator++)
		{
			for(int rankIterator=0; rankIterator<rank.length; rankIterator++)
			{
				cards[suitIterator][rankIterator] = suit[suitIterator] + "-" + rank[rankIterator];				
			}
		}
		
		
		//FETCHING CARDS FROM 2-D ARRAYS
		for (int suitIterator=0; suitIterator<suit.length; suitIterator++)
		{
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



public class DeckofCardsUsingPlayerObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
