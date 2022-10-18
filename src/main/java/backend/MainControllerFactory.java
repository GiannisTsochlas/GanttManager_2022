package backend;

import dom2app.SimpleTableModel;
import fileopen.FileOpen;

public class MainControllerFactory implements IMainController {

	public IMainController createMainController() {
		return new MainControllerFactory();
		
	}

	@Override
	public SimpleTableModel load(String fileName, String delimiter) {
		// TODO Auto-generated method stub
		FileOpen test = new FileOpen(delimiter,fileName);
		System.out.println(test);
		return null;
	}

	@Override
	public SimpleTableModel getTasksByPrefix(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SimpleTableModel getTaskById(int id) {
		6
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
