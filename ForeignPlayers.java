package Assignment;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForeignPlayers {
//Write a test that validates that the team has only 4 foreign players.
	@Test
	public void ForeignPlayers() throws IOException, ParseException, Throwable
	{
		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader(".\\src\\main\\resources\\testdata\\team.jason");

		Object obj = parser.parse(reader);

		JSONObject rcbjsonobj = (JSONObject) obj;

		JSONArray array = (JSONArray) rcbjsonobj.get("player");

		int count = 0;
		int foreigncount = 0;

		for (int i = 0; i < array.size(); i++)
		{
			JSONObject player = (JSONObject) array.get(i);

			String country = (String) player.get("country");

			if (country.equalsIgnoreCase("India"))
			{
				count++;
			} else
			{
				foreigncount++;
			}
		}
		System.out.println("India Players  " + count);
		System.out.println("Foreign Players " + foreigncount);

		  Assert.assertEquals(4, foreigncount);
		int expected = 4;

		if (expected == foreigncount)
		{
			System.out.println("In RCB there is : " + foreigncount + " foreign Players");
		}
	}

}
	