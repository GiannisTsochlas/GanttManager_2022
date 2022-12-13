package testPackage;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import backend.MainControllerFactory;
import dom2app.SimpleTableModel;
import filemanagment.FileOpen;
import task.Task;

public class FilemanagmentTest {
	private static FileOpen fileOpenToTest;
	

	@Before
	public void setUp() throws Exception {
		fileOpenToTest = new FileOpen("\t","./src/main/resources/input/EggsScrambled.tsv");
	}

	@Test
	//T1_V0_03
	public void testfileOpenNull() {
		assertNotNull("After the setup,the file open is not null",fileOpenToTest);
	}
	
	@Test
	//T1_V0_04
	public void testfileOpenNoDelimiter() {
		fileOpenToTest = new FileOpen(null,"./src/main/resources/input/EggsScrambled.tsv");
		assertNull("test if the constructor prevents creation with null delimiter",fileOpenToTest);
		//failure so we must fix it 
	}
	
	@Test
	//T1_V0_01
	public void testfileOpenLines() {
		ArrayList<Task> loadedfile=fileOpenToTest.loadfile();
		assertEquals("test if file open has sucesfully load the file (unsorted/unclassified) through total line number",14,loadedfile.size());
	}
	
	@Test
	//T1_V0_02
	public void testClassificationChanges() {
		MainControllerFactory testClassification=new MainControllerFactory();
		SimpleTableModel arraytotest = testClassification.load("./src/main/resources/input/EggsScrambled.tsv","\t");
		String compare="Sort	for	./src/main/resources/input/EggsScrambled.tsv\n"+ 
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
		assertEquals("HAPPY DAY test if file after Final Sort has succesfuly sorted ",arraytotest.toString(),compare);

	}
	
	//READ ME 
	
	//this test simulates a faulty path we comment it because it do System.exit(0); so the other test will not be exucuted 
	//we have search a way to do it .we found System lamda library that have functions to test that thing BUT it writes 
	//"For JUnit 4 there is an alternative to System Lambda. Its name is System Rules." and then for System Rules they write 
	//Advice: System Rules needs at least JUnit 4.9. and we have 4.14 so we cannot test it in that way 

//	@Test 
//	//you will see in the console the problem 
//	public void testfileOpenNoFileName() {
//		MainControllerFactory testClassification=new MainControllerFactory();
//		SimpleTableModel arraytotest = testClassification.load("","\t");
//		
//	}

}
