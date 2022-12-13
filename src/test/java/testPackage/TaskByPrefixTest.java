package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import backend.MainControllerFactory;
import dom2app.SimpleTableModel;

public class TaskByPrefixTest {
	private static MainControllerFactory appController;

	@Before
	public void setUp() throws Exception {
		appController=new MainControllerFactory();
	}

	@Test
	//T2_V0_01
	public void getByPrefixTest() {
		SimpleTableModel m = appController.load("./src/main/resources/input/EggsScrambled.tsv", "\t");
		m = appController.getTasksByPrefix("Put");
		String compare="Prefix search  'Put'	for	./src/main/resources/input/EggsScrambled.tsv\n"+
						"TaskId	TaskText	MamaId	Start	End	Cost\t\n"+
				 		"301	Put bread in plate	300	13	13	10	\n"+
						"302	Put eggs on bread	300	14	14	10	\n";
		assertEquals("HAPPY DAY test for getTaskByPrefix",compare,m.toString());
	}
}