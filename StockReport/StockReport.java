package StockReport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class Stock
{
	public void showStockReport() throws IOException, ParseException
	{
		//CREATING OBJECT OF JSON PARSOR
		JSONParser jsonParserObject = new JSONParser();

		
		//ARRAY OF STOCK KEYS
		String[] stockKeys = {"Biscuit","Mobile"};
		double totalStockValue= 0.0;

		
		//READING FILE USING BUFFER READER 
		BufferedReader jsonBufferReaderObject = new BufferedReader(new FileReader("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//StockInformation.json"));
		JSONObject jsonObject = (JSONObject)jsonParserObject.parse(jsonBufferReaderObject);

		
		//PRINTING JSON DATA		
		for(int key=0; key<stockKeys.length; key++)
		{
			JSONArray stockArray = (JSONArray)jsonObject.get(stockKeys[key]);
			for(int stockArrayIterator=0; stockArrayIterator<stockArray.size(); stockArrayIterator++)
			{
				System.out.println(stockKeys[key]+" : "+stockArray.get(stockArrayIterator));
				JSONObject arrayObjectOfStockArray = (JSONObject) stockArray.get(stockArrayIterator);
				System.out.println("Stock Name "+arrayObjectOfStockArray.get("Stock Name"));
				System.out.println("Number Of Share "+arrayObjectOfStockArray.get("Number Of Share"));
				System.out.println("Share Price "+arrayObjectOfStockArray.get("Share Price"));
				String numberOfShare = JSONObject.toString("Number Of Share",arrayObjectOfStockArray.get("Number Of Share"));
				String sharePrice = JSONObject.toString("Share Price",arrayObjectOfStockArray.get("Share Price"));
				String cleanNumberOfShare = numberOfShare.replaceAll("\\D","");
				String sharePriceValue = sharePrice.replaceAll("\\D","");
				int numberOfShareInInt = Integer.parseInt(cleanNumberOfShare);
				Double sharePirceValueInDouble = Double.parseDouble(sharePriceValue);
				System.out.println("Total price : "+numberOfShareInInt*sharePirceValueInDouble);	
				totalStockValue = numberOfShareInInt*sharePirceValueInDouble + totalStockValue;
			}
		}
		System.out.println("Total share price : "+totalStockValue);
	}
}


//STOCK REPORT CLASS
public class StockReport 
{
	//MAIN CLASS
	public static void main(String[] args) throws IOException, ParseException 
	{
		Stock stockObject = new Stock();
		stockObject.showStockReport();
	}
}			
