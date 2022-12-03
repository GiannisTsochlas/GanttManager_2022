package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import filemanagment.Classification;
import filemanagment.FileOpen;

public class FilemanagmentTest {
	private static FileOpen fileOpenToTest;
	//private Classification classificationToTest;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Here we create a single object (to save time)
		//and use it in all tests.
	}

	@Before
	public void setUp() throws Exception {
		fileOpenToTest = new FileOpen("\t","./src/main/resources/input/EggsScrambled.tsv");
	}

	@Test
	public void testfileOpenNull() {
		assertNotNull("After the setup,the file open is not null",fileOpenToTest);
	}
	@Test
	public void testfileOpenNoDelimiter() {
		fileOpenToTest = new FileOpen(null,"./src/main/resources/input/EggsScrambled.tsv");
		assertNull("test if the constructor prevents creation with null delimiter",fileOpenToTest);
	}

}
