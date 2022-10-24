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


public class MarkdownReport {
	String path;
	ReportType type;
	
	public MarkdownReport(String path, ReportType type) {
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
	
	public int createMarkdownReport(String path, ReportType type,ArrayList<Task> arraylistwithtasks) {
			
				FileOutputStream outputStream = null;
				
				try{
				outputStream = new FileOutputStream(path);
				}
				catch (FileNotFoundException e){
				System.out.println("Error opening the file ");
				return -1;
				}
		
				PrintWriter outputWriter = new PrintWriter(outputStream);
				
				outputWriter.println("mpikes stin mdreport");
				
				outputWriter.println("*"+"TaskId	  TaskText	  MamaId	   Start 	End 	Cost"+"*");//na rwtisoyme an exei thema poy fainonte ta asterakia sto telos 
				
				for(int i=0;i<arraylistwithtasks.size();i++) {
					if(arraylistwithtasks.get(i).getMamaId()==0) {
						outputWriter.println("**"+arraylistwithtasks.get(i).infosInString()+"**");
					}
					else outputWriter.println(arraylistwithtasks.get(i).infosInString());
				}
				outputWriter.close( );
			return countLine(path);
			}
}
