package reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import backend.ReportType;


public class TextReport {
	String path;
	ReportType type;
	
	
	public TextReport(String path, ReportType type) {
		this.path = path;
		this.type = type;
	}
	
	 public static int countLineJava(String fileName) {

	      Path path = Paths.get(fileName);

	      int lines = 0;
	      try {

	          // much slower, this task better with sequence access
	          //lines = Files.lines(path).parallel().count();

	          lines = (int) Files.lines(path).count();

	      } catch (IOException e) {
	          e.printStackTrace();
	      }

	      return lines;

	  }


	public int createReportTxt(String path, ReportType type) {
		
		FileOutputStream outputStream = null;
		
		try{
		outputStream = new FileOutputStream(path);
		}
		catch (FileNotFoundException e){
		System.out.println("Error opening the file stuff.txt.");
		return -1;
		}
		
		PrintWriter outputWriter = new PrintWriter(outputStream);
		
		outputWriter.println("jumped over the lazy dog.");
		outputWriter.close( );
		return countLineJava(path);
	}
}
