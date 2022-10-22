package searchmethods;

import java.util.ArrayList;

import task.Task;

public class TopLevelTasks {
	
	public ArrayList<Task> getTopLevelTasks(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		
		for (int i = 0; i <arraylistwithtasks.size(); i++) {
			if(arraylistwithtasks.get(i).getMamaId()==0) {
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
