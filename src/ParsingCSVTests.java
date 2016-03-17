import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ParsingCSVTests {

	ParsingCSV pCSV = new ParsingCSV();

	@Before
    public void executedBeforeEach() throws IOException {
    	int readStatus = pCSV.readWHeader("files/data.csv");
    	assertEquals(0, readStatus);
        System.out.println("@Before: executedBeforeEach");
    }

	@Test
	public void testReadCSV() {
		int readStatus = pCSV.read("files/data.csv");
		assertEquals(0, readStatus);
	}

	@Test
	public void testReadCSVFail() {
		int readStatus = pCSV.read("files/data.csv");
		assertEquals(0, readStatus);
	}

	@Test
	public void testReadCSVWithHeader() throws IOException {
		int readStatus = pCSV.readWHeader("files/data.csv");
		assertEquals(0, readStatus);
	}

	@Test
	public void testParseCSVget() {
		String value00 = pCSV.get(0, 0);
		assertEquals("Rose Castro", value00);
	}

	@Test
	public void testParseCSVGetWithColumname() {
		String value00 = pCSV.get(0, "name");
		assertEquals("Rose Castro", value00);
	}

	@Test
	public void testGetHeader() {
		String value00 = pCSV.get(0, "name");
		assertEquals("Rose Castro", value00);
	}

	@Test
	public void testSetHeader() {
		String value00 = pCSV.get(0, "name");
		assertEquals("Rose Castro", value00);
	}

	@Test
	public void testSetValue1() {
		String value = pCSV.set(0, "name", "Rose");
		assertEquals("Rose", value);
		value = pCSV.get(0, "name");
		assertEquals("Rose", value);
	}

	@Test
	public void testSetValue2() {
		String value = pCSV.set(0, 0, "Rose");
		assertEquals("Rose", value);
		value = pCSV.get(0, 0);
		assertEquals("Rose", value);
	}
	
	@Test
	public void testGetRow() {
		String[] actual = pCSV.getRow(0);
		String [] expected = {"Rose Castro","rose.castro@example.com"};
		assertArrayEquals( expected, actual);
	}
	
	@Test
	public void testGetCol() {
		String[] actual = pCSV.getCol(0);
		String [] expected = {"Rose Castro", "Valtteri Wuollet", "Lena Sanders", "Angeles Mendez", "Martin Lefevre", "Cristian Roman", "Tracey Meyer", "Victoire Riviere", "Kiara Guillot", "Venla Ylitalo", "Alvin Anderson", "Annette Harper", "Stephanie Morris", "Alex Terry", "Denise Sims", "Veera Ketola", "Crystal Dunn", "Beauty Kitchen"};
		assertArrayEquals(expected, actual);
	}
}
