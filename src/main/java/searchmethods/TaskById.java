package searchmethods;

import java.util.ArrayList;
import task.Task;

public class TaskById {
	private int Id;

	public TaskById(int Id) {
		this.Id = Id;
	}
	
	public ArrayList<Task> getTasksById(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			if(Id==arraylistwithtasks.get(i).getTaskId()){
				returnarraylist.add(arraylistwithtasks.get(i));
			}
		}
		
		return returnarraylist;
	}
	
	//"Convert" indexes TASKS of an ArrayList to STRING 
	public ArrayList<String[]> 	toString(ArrayList<Task> arl){
		
		ArrayList<String[]> indexes = new ArrayList<String[]>();
		for(int i=0; i<arl.size(); i++) {
			indexes.add(arl.get(i).tablestr());
		}
		return indexes;
	}	

}
