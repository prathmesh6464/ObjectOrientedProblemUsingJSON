package RegularExpressionProblem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


//REGULAR EXPRESSION
class RegularExpression
{
	void readFile() throws IOException
	{
		//READING FILE
		BufferedReader bufferedReaderObject = new BufferedReader(new FileReader("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//RegExFileData.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		String lineOfRegExFileData = "";
		while(lineOfRegExFileData != null)
		{
			lineOfRegExFileData = bufferedReaderObject.readLine();
			if(lineOfRegExFileData != null)
			{
				//CONSTANT VARIABLES;
				String NAME = "Prathamesh";
				String FULL_NAME = "Prathamesh Bhiku Jadhav";
				int DAY = 14;
				int MONTH = 03;
				int YEAR = 2020;
				long MOBILE = 9869986900L;
				String MOBILE_NUMBER = Long.toString(MOBILE);
								
				
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("<<[a-zA-z]+>>",NAME);
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("<<[a-zA-z]+[ ]{1}[a-zA-z]+>>",FULL_NAME);
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("[x]{10}",MOBILE_NUMBER);
				lineOfRegExFileData = lineOfRegExFileData.replaceAll("[\\d]{2}[/]{1}[\\d]{2}[/]{1}[\\d]{4}",DAY+"/"+MONTH+"/"+YEAR);
				
				
				//SHOWING REPLACE MESSAGE
				System.out.println(lineOfRegExFileData);
			}
		}
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