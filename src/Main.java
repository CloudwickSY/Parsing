import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import json.Person;

public class Main {

	public static void main(String[] args) {

		//CSV
		ParsingCSV pCSV = new ParsingCSV();
		try {
			int readStatus = pCSV.readWHeader("files/data.csv");
			String value00 = pCSV.get(0, 0);
			System.out.println(value00);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSON
	    Gson gson = new Gson();
	    Person person = null;
		try {
			person = gson.fromJson(new FileReader("files/data.json"), Person.class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(gson.toJson(person));
	    System.out.println(person.toString());

	}

}
