package RegularExpressionProblem;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.*;



//REGULAR EXPRESSION
class RegularExpression
{
	void readFile() throws IOException
	{
		BufferedReader bufferedReaderObject = new BufferedReader(new FileReader("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//RegExFileData.txt"));
		String lineOfRegExFileData = "";
		while(lineOfRegExFileData != null)
		{
			lineOfRegExFileData = bufferedReaderObject.readLine();
			System.out.println(lineOfRegExFileData);
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
