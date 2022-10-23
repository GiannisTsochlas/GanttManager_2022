package backend;

import java.util.ArrayList;

import dom2app.SimpleTableModel;
import filemanagment.FileOpen;
import filemanagment.Sort;
import reports.TextReport;
import searchmethods.TaskById;
import searchmethods.TasksByPrefix;
import searchmethods.TopLevelTasks;
import task.Task;

public class MainControllerFactory implements IMainController {
	
	private String name = "";
    private String prjName ="";
    private String[] pColumnNames ={"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost" };

    
    ArrayList<Task> loadedfile,sortedfile = new ArrayList<Task>();
    ArrayList<Task> temporary1,temporary2,temporary3 = new ArrayList<Task>();
   
    
	public IMainController createMainController() {
		return new MainControllerFactory();
	}

	@Override
	public SimpleTableModel load(String fileName, String delimiter) {
		
		FileOpen test = new FileOpen(delimiter,fileName);
		Sort test11 = new Sort();
		
		loadedfile=test.loadfile();
		sortedfile=test11.FinalSort(loadedfile);
		//thelei kati poy na kanei kai taksinomish blepe discord general (mia klash se ena paketo sort )
		
		return new SimpleTableModel(name,prjName,pColumnNames,test.toString(sortedfile));
	}

	@Override
	public SimpleTableModel getTasksByPrefix(String prefix) {
		TasksByPrefix test2 = new TasksByPrefix(prefix);
		temporary1=test2.getTasksByPrefix(sortedfile);
		return new SimpleTableModel(name,prjName,pColumnNames,test2.toString(temporary1));
	}

	
	@Override
	public SimpleTableModel getTaskById(int id) {
		TaskById test3 = new TaskById(id);
		temporary2=test3.getTasksById(sortedfile);
		return new SimpleTableModel(name,prjName,pColumnNames,test3.toString(temporary2));
	}

	@Override
	public SimpleTableModel getTopLevelTasks() {
		TopLevelTasks test4 =new TopLevelTasks();
		temporary3=test4.getTopLevelTasks(sortedfile);
		return new SimpleTableModel(name,prjName,pColumnNames,test4.toString(temporary3));
	}

	@Override
	public int createReport(String path, ReportType type) {
		TextReport test5 =new TextReport(path,type);
		return test5.createReportTxt(path, type);
	}

}
