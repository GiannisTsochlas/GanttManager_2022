package sort;

import java.util.ArrayList;

import task.Task;

public class Sort {
	
	int maxtime=0;
	
	public ArrayList<Task> sortTopLevelsTasks(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		int currentid = 0,topleveltaskid=0;
		
		
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			
			if(maxtime<=(arraylistwithtasks.get(i)).getStart())
				maxtime=arraylistwithtasks.get(i).getStart();
			}
		
		System.out.println("maxtime="+maxtime);
		
		arraylistwithtasks=sortTasks(arraylistwithtasks);
		
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			
			topleveltaskid=arraylistwithtasks.get(i).getTaskId();
			
			if(arraylistwithtasks.get(i).getMamaId()==0) {//bazei ta toplevel tasks
				returnarraylist.add(arraylistwithtasks.get(i));
			}
			
			for(int j = 0; j < arraylistwithtasks.size(); j++) {
				
				currentid = arraylistwithtasks.get(j).getMamaId();//bazei ta ypolipa tasks
				
				if(currentid==topleveltaskid) {
					returnarraylist.add(arraylistwithtasks.get(j));
				}	
			}	
		}
		
		return returnarraylist;
	}
	
	
	//na ftiaksw aythn giati moy troei to teleyteo
	public ArrayList<Task> sortTasks(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			
			if(maxtime<=(arraylistwithtasks.get(i)).getStart())
				maxtime=arraylistwithtasks.get(i).getStart();
			}
		
		System.out.println("maxtime="+maxtime);
		
		
		for (int i = 0; i < maxtime+1; i++) {//diatrexei ton xrono
			
			for(int j=0;j<arraylistwithtasks.size(); j++) {//diatrexei ta tasks
				if((i==(arraylistwithtasks.get(j)).getStart()))
				{
					returnarraylist.add(arraylistwithtasks.get(j));
				
				}
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
