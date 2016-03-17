import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		ParsingCSV pCSV = new ParsingCSV();
		try {
			int readStatus = pCSV.readWHeader("files/data.csv");
			String value00 = pCSV.get(0, 0);
			System.out.println(value00);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
