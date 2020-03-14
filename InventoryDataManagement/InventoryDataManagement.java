import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class InventoryMangement
{
	public void inventoryDataMethod() throws IOException, ParseException
	{
		//CREATING OBJECT OF JSON PARSOR
		JSONParser jsonParserObject = new JSONParser();
		
		
		//ARRAY OF KEYS
		String[] keys = {"Pulses","Rice","Wheat"};


		//READING FILE USING BUFFER READER 
		BufferedReader jsonBufferReaderObject = new BufferedReader(new FileReader("//home//admin1//Documents//GamblerProblem//SnakeAndLadder//InventoryList.json"));
		JSONObject jsonObject = (JSONObject)jsonParserObject.parse(jsonBufferReaderObject);

		
		//PRINTING JSON DATA		
		for (int key=0; key<keys.length; key++)
		{
			JSONArray inventoryArray = (JSONArray)jsonObject.get(keys[key]);
			for(int inventoryIterator=0; inventoryIterator<inventoryArray.size(); inventoryIterator++)
			{
				System.out.println(keys[key]+" : "+inventoryArray.get(inventoryIterator));
				JSONObject arrayObjectOfInventory = (JSONObject) inventoryArray.get(inventoryIterator);
				System.out.println("name "+arrayObjectOfInventory.get("name"));
				System.out.println("weight "+arrayObjectOfInventory.get("weight"));
				System.out.println("price "+arrayObjectOfInventory.get("price"));
				String weight = JSONObject.toString("weight",arrayObjectOfInventory.get("weight"));
				String price = JSONObject.toString("price",arrayObjectOfInventory.get("price"));
				String cleanWeight = weight.replaceAll("\\D","");
				String cleanPrice = price.replaceAll("\\D","");
				int weightInInt = Integer.parseInt(cleanWeight);
				Double priceInDouble = Double.parseDouble(cleanPrice);
				System.out.println("Total price : "+weightInInt*priceInDouble);		
			}
		}
	}
}


//INVENTORY MANAGEMENT CLASS
public class InventoryDataManagement 
{
	//MAIN CLASS
	public static void main(String[] args) throws IOException, ParseException 
	{
		InventoryMangement inventoryObject = new InventoryMangement();
		inventoryObject.inventoryDataMethod();
	}
}	