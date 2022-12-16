package testPackage;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import app.AppController;



public class ReportsTest {
	private static AppController appController = new AppController();

	
	@Before
	public void setUp() throws Exception {
		appController=new AppController();
	}

	
	@Test
	//T4_V0_01
	public void createReportTextTest() {
		
		assertNotNull("Happy Day for createReportText",appController.createReportText("./src/test/resources/Eggs.tsv"));
	}

	@Test
	//T4_V0_02
	public void createReportHtmlTest() {
		assertNotNull("Happy Day for createReportHtml",appController.createReportHtml("./src/test/resources/Eggs.html"));
	}

	@Test
	//T4_V0_03
	public void createReportMdTest() {
		assertNotNull("Happy Day for createReportMd",appController.createReportMd("./src/test/resources/Eggs.md"));
	}

}
