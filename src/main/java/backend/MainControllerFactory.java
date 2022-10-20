package backend;

import java.util.ArrayList;

import dom2app.SimpleTableModel;
import fileopen.FileOpen;
import task.Task;

public class MainControllerFactory implements IMainController {
	private String name = "";
    private String prjName ="";
    private String[] pColumnNames ={"TaskId" , "TaskText", "MamaId","Start" , "End" , "Cost" };

	public IMainController createMainController() {
		return new MainControllerFactory();
		
	}

	@Override
	public SimpleTableModel load(String fileName, String delimiter) {
		// TODO Auto-generated method stub
		FileOpen test = new FileOpen(delimiter,fileName);
		ArrayList<Task> testprit = new ArrayList<Task>(); 
		testprit=test.loadfile();	
		return new SimpleTableModel(name,prjName,pColumnNames,test.toString(testprit));
	}

	@Override
	public SimpleTableModel getTasksByPrefix(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleTableModel getTaskById(int id) {
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
