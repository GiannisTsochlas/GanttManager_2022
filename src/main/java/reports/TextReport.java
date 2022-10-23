package reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import backend.ReportType;


public class TextReport {
	String path;
	ReportType type;
	
	
	public TextReport(String path, ReportType type) {
		this.path = path;
		this.type = type;
	}



	public int createReportTxt(String path, ReportType type) {
		
		FileOutputStream outputStream = null;
		
		try{
		outputStream = new FileOutputStream(path);
		}
		catch (FileNotFoundException e){
		System.out.println("Error opening the file stuff.txt.");
		System.exit(0);
		}
		
		PrintWriter outputWriter = new PrintWriter(outputStream);
		
		outputWriter.println("jumped over the lazy dog.");
		outputWriter.close( );
		
		return 0;
	}
}
