package testPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainControllerFactory;
import dom2app.SimpleTableModel;
import filemanagment.FileOpen;
import task.Task;

public class FilemanagmentTest {
	private static FileOpen fileOpenToTest;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//this runs once, before _all_ tests. Here we create a single object (to save time)
		//and use it in all tests.
	}

	@Before
	public void setUp() throws Exception {
		fileOpenToTest = new FileOpen("\t","./src/main/resources/input/EggsScrambled.tsv");
	}

	/*@Test
	public void testfileOpenNull() {
		assertNotNull("After the setup,the file open is not null",fileOpenToTest);
	}
	@Test
	public void testfileOpenNoDelimiter() {
		fileOpenToTest = new FileOpen(null,"./src/main/resources/input/EggsScrambled.tsv");
		assertNull("test if the constructor prevents creation with null delimiter",fileOpenToTest);
	}
	@Test
	public void testfileOpenNoFileName() {
		fileOpenToTest = new FileOpen("\t",null);
		assertNull("test if the constructor prevents creation with null filename",fileOpenToTest);
	}*/
	@Test
	public void testfileOpenLines() {
		ArrayList<Task> loadedfile=fileOpenToTest.loadfile();
		assertEquals("test if file open has sucesfully load the file (unsorted/unclassified) through total line number",14,loadedfile.size());
	}
	@Test
	public void testClassificationChanges() {
		MainControllerFactory testClassification=new MainControllerFactory();
		SimpleTableModel arraytotest = testClassification.load("./src/main/resources/input/EggsScrambled.tsv","\t");
		String compare="	for\t\n"+ 
				"TaskId	TaskText	MamaId	Start	End	Cost\t\n"
				+ "100	Prepare Fry	0	1	12	60\t\n"
				+ "101	Turn on burner (low)	100	1	1	10\t\n"
				+ "102	Break eggs and pour into fry	100	2	4	10\t\n"
				+ "103	Steer mixture to avoid sticking	100	5	10	10\t\n"
				+ "105	Salt, pepper	100	5	5	10\t\n"
				+ "104	Throw yellow cheese into fry	100	6	12	10\t\n"
				+ "106	Turn burner off	100	12	12	10\t\n"
				+ "200	Prepare the bread	0	10	12	20\t\n"
				+ "201	Heat bread in toaster	200	10	12	10\t\n"
				+ "202	Little bit of salt, galric spice to bread	200	12	12	10\t\n"
				+ "300	Serve eggs	0	13	20	30\t\n"
				+ "301	Put bread in plate	300	13	13	10\t\n"
				+ "302	Put eggs on bread	300	14	14	10\t\n"
				+ "303	Wash fry	300	15	20	10\t\n";
		assertEquals("HAPPY DAY test if file after Final Sort has succesfuly sorted ",compare,arraytotest.toString());

	}
	
	

}
