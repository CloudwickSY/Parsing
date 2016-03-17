import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ParsingCSV {
	private HashMap<Integer, String> headerIN;
	private HashMap<String, Integer> headerNI;
	private String[][] csvFile;

	public ParsingCSV() {
		headerIN = null;
		headerNI = null;
		csvFile = null;
	}

	public int readWHeader(String file) throws IOException {
		Reader reader = new FileReader(file);
		final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
		List<CSVRecord> records = parser.getRecords();
		
		try {
			headerNI = (HashMap<String, Integer>) parser.getHeaderMap();
			headerIN = new HashMap<Integer, String>();
			for (String key : headerNI.keySet()) {
				headerIN.put(headerNI.get(key), key);
			}
			csvFile = new String[records.size()][headerNI.size()];
			int row = 0;
			for (final CSVRecord record : records) {
				//System.out.println(record);
				for (String key : headerNI.keySet()) {
					csvFile[row][headerNI.get(key)] = record.get(key);
				}
				row++;
			}
		} finally {
			parser.close();
			reader.close();
		}
		return 0;
	}

	public int read(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String get(int row, int column) {
		return csvFile[row][column];
	}

	public String get(int row, String columnname) {
		return csvFile[row][headerNI.get(columnname)];
	}

	public String set(int row, int column, String value) {
		csvFile[row][column] = value;
		return csvFile[row][column];
	}

	public String set(int row, String columnname, String value) {
		csvFile[row][headerNI.get(columnname)] = value;
		return csvFile[row][headerNI.get(columnname)];
	}

	public String[] getRow(int row) {
		return csvFile[row];
	}

	public String[] getCol(int columnid) {
		String[] column = new String[csvFile.length];
		for (int index = 0; index < csvFile.length; index++) {
			column[index] = csvFile[index][columnid];
		}
		return column;
	}

	public HashMap<Integer, String> getHeaderIN() {
		return headerIN;
	}

	public void setHeaderIN(HashMap<Integer, String> headerIN) {
		this.headerIN = headerIN;
	}

	public HashMap<String, Integer> getHeaderNI() {
		return headerNI;
	}
	
	public void setHeaderNI(HashMap<String, Integer> headerNI) {
		this.headerNI = headerNI;
	}

}
