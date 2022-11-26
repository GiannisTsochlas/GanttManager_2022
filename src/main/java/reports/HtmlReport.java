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


public class HtmlReport {
	private String path;
	private ReportType type;
	
	public HtmlReport(String path, ReportType type) {
		this.setPath(path);
		this.setType(type);
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
	
	public int createHtmlReport(String path, ReportType type,ArrayList<Task> arraylistwithtasks) {
			
			
				FileOutputStream outputStream = null;
				
				try{
				outputStream = new FileOutputStream(path);
				}
				catch (FileNotFoundException e){
				System.out.println("Error opening the file ");
				return -1;
				}
		
				PrintWriter outputWriter = new PrintWriter(outputStream);
				
				outputWriter.println("<html>");
				outputWriter.println("<html>");
				outputWriter.println("<meta http-equiv=\"Content-Type\" content\"text/html; charset=windows-1253\">");
				outputWriter.println("<title>Gantt Project Data</title>");
				outputWriter.println("</head>");
				outputWriter.println("<body>");
				outputWriter.println("<table>");
				outputWriter.println("<tr>");
				outputWriter.println("<td>TaskId</td>	<td>TaskText</td>	<td>MamaId</td>	<td>Start</td>	<td>End</td>	<td>Cost</td>	</tr>");
				for(int i=0;i<arraylistwithtasks.size();i++) {
					outputWriter.println();
					outputWriter.println("<tr>");
					outputWriter.println("<td>"+arraylistwithtasks.get(i).getTaskId()+"</td>	"+"<td>"+arraylistwithtasks.get(i).getName()+"</td>	"+"<td>"+arraylistwithtasks.get(i).getMamaId()+"</td>	"+"<td>"+arraylistwithtasks.get(i).getStart()+"</td>	"+"<td>"+arraylistwithtasks.get(i).getEnd()+"</td>	"+"<td>"+arraylistwithtasks.get(i).getCost()+"</td>");
				}
				outputWriter.println("<table></body>");
				outputWriter.println("</html>");


				
				outputWriter.close( );
			return countLine(path);
			}
	//Setters and Getters

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ReportType getType() {
		return type;
	}

	public void setType(ReportType type) {
		this.type = type;
	}
}