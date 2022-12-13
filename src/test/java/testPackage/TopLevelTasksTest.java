package testPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import backend.MainControllerFactory;
import dom2app.SimpleTableModel;

public class TopLevelTasksTest {
	private static MainControllerFactory appController;

	@Before
	public void setUp() throws Exception {
		appController=new MainControllerFactory();
	}

	@Test
	//T4_V0_01
	public void getTopLevelTaskTest() {
		SimpleTableModel m = appController.load("./src/main/resources/input/EggsScrambled.tsv", "\t");
		m = appController.getTopLevelTasks();
		String compare="Top Level Tasks search 	for	./src/main/resources/input/EggsScrambled.tsv\n"
				+ "TaskId	TaskText	MamaId	Start	End	Cost	\n"
				+ "100	Prepare Fry	0	1	12	60	\n"
				+ "200	Prepare the bread	0	10	12	20	\n"
				+ "300	Serve eggs	0	13	20	30	\n";

		assertEquals("HAPPY DAY test for getTaskByPrefix",compare,m.toString());
	}
}