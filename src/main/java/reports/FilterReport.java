package reports;

import java.util.ArrayList;

import backend.ReportType;
import task.Task;

public class FilterReport {
	private String path;
	private ReportType type;
	private ArrayList<Task> arraylistwithtasks;
	
	public FilterReport(String path, ReportType type) {
		this.setPath(path);
		this.setType(type);
	}
	
	public int chooseReport(String path, ReportType type,ArrayList<Task> arraylistwithtasks) {
		
		switch(type) {
	    case TEXT:
	    	
	      TextReport choosed=new TextReport(path,type);
	      return choosed.createReportTxt(path, type, arraylistwithtasks);
	      
	    case MD:
	    	
	       MarkdownReport choosed1=new MarkdownReport(path,type);
		   return choosed1.createMarkdownReport(path, type, arraylistwithtasks);
	     
	    case HTML:
	    	
	      HtmlReport choosed2=new HtmlReport(path,type);
	      return choosed2.createHtmlReport(path, type, arraylistwithtasks);
	   
		}
		return -1;
	}
	//Setter and Getters

	public ReportType getType() {
		return type;
	}

	public void setType(ReportType type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<Task> getArraylistwithtasks() {
		return arraylistwithtasks;
	}

	public void setArraylistwithtasks(ArrayList<Task> arraylistwithtasks) {
		this.arraylistwithtasks = arraylistwithtasks;
	}
}
