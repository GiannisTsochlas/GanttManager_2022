package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainControllerFactory;
import dom2app.SimpleTableModel;

public class TaskByIdTest {
	private static MainControllerFactory appController;

	@Before
	public void setUp() throws Exception {
		appController=new MainControllerFactory();
	}

	@Test
	//T3_V0_01
	public void getByIdTest() {
		SimpleTableModel m = appController.load("./src/main/resources/input/EggsScrambled.tsv", "\t");
		m = appController.getTaskById(200);
		String compare="Id search '200'		for	./src/main/resources/input/EggsScrambled.tsv\n"+
				"TaskId	TaskText	MamaId	Start	End	Cost\t\n"
				+ "200	Prepare the bread	0	10	12	20\t\n";
		assertEquals("HAPPY DAY test for getTaskById",m.toString(),compare);
	}

}
