package reports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import backend.ReportType;
import task.Task;


public class TextReport {
	String path;
	ReportType type;
	
	
	public TextReport(String path, ReportType type) {
		this.path = path;
		this.type = type;
	}
	
	 public static int countLine(String fileName) {

	      Path path = Paths.get(fileName);

	      int lines = 0;
	      try {

	          lines = (int) Files.lines(path).count();

	      } catch (IOException e) {
	          e.printStackTrace();
	      }
	      return lines;
	  }


	public int createReportTxt(String path, ReportType type,ArrayList<Task> arraylistwithtasks) {
		
		if(type==ReportType.TEXT) {
		
			FileOutputStream outputStream = null;
			
			try{
			outputStream = new FileOutputStream(path);
			}
			catch (FileNotFoundException e){
			System.out.println("Error opening the file ");
			return -1;
			}
	
			PrintWriter outputWriter = new PrintWriter(outputStream);
			
			outputWriter.println("mpikes stin txtreport ");
			outputWriter.println("TaskId	 TaskText	 MamaId	   Start 	End 	Cost");
			for(int i=0;i<arraylistwithtasks.size();i++) {
				outputWriter.println(arraylistwithtasks.get(i).infosInString());
			}
			
			outputWriter.close( );
		return countLine(path);
		}
		return 0;
	}
	
	
}
