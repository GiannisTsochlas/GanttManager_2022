package backend;

import java.util.ArrayList;

import dom2app.SimpleTableModel;
import fileopen.FileOpen;
import task.Task;
import tasksbyprefix.TasksByPrefix;

public class MainControllerFactory implements IMainController {
	
	private String name = "";
    private String prjName ="";
    private String[] pColumnNames ={"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost" };

    
    ArrayList<Task> testtoprint = new ArrayList<Task>();
    ArrayList<Task> temporary2 = new ArrayList<Task>();
    
	public IMainController createMainController() {
		return new MainControllerFactory();
	}

	@Override
	public SimpleTableModel load(String fileName, String delimiter) {
		
		FileOpen test = new FileOpen(delimiter,fileName);
		testtoprint=test.loadfile();
		return new SimpleTableModel(name,prjName,pColumnNames,test.toString(testtoprint));
	}

	@Override
	public SimpleTableModel getTasksByPrefix(String prefix) {
		TasksByPrefix test2 = new TasksByPrefix(prefix);
		temporary2=test2.gettasksbyprefix(testtoprint);
		return new SimpleTableModel(name,prjName,pColumnNames,test2.toString(temporary2));
	}

	
	@Override
	public SimpleTableModel getTaskById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleTableModel getTopLevelTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int createReport(String path, ReportType type) {
		// TODO Auto-generated method stub
		return 0;
	}

}
