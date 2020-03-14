package RegularExpressionProblem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


//REGULAR EXPRESSION
class RegularExpression
{
	//CONSTANT VARIABLES;
	private String NAME = "Prathamesh";
	private String FULL_NAME = "Prathamesh Bhiku Jadhav";
	private int DAY = 14;
	private int MONTH = 03;
	private int YEAR = 2020;
	private long MOBILE = 9869986900L;
	private String MOBILE_NUMBER = Long.toString(MOBILE);
			
	
	public void readFile() throws IOException
	{
		//VARIABLE
		String lineOfRegExFileData = "";
		
		
		//READING FILE
		BufferedReader bufferedReaderObject = new BufferedReader(new FileReader("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//RegExFileData.txt"));
		Scanner sc = new Scanner(System.in);
				
		
		while(lineOfRegExFileData != null)
		{
			lineOfRegExFileData = bufferedReaderObject.readLine();
			if(lineOfRegExFileData != null)
			{
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("<<[a-zA-z]+>>",NAME);
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("<<[a-zA-z]+[ ]{1}[a-zA-z]+>>",FULL_NAME);
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("[x]{10}",MOBILE_NUMBER);
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("[\\d]{2}[/]{1}[\\d]{2}[/]{1}[\\d]{4}",DAY+"/"+MONTH+"/"+YEAR);
				
				
				//SHOWING REPLACE MESSAGE
				System.out.println(lineOfRegExFileData);
			}
		}
		bufferedReaderObject.close();
	}
}


//REGULAR EXPRESSION PROBLEM
class RegularExpressionProblem 
{
	public static void main(String[] args) throws IOException 
	{
		RegularExpression regExObject = new RegularExpression();
		regExObject.readFile();
	}
}
