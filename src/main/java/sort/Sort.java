package sort;

import java.util.ArrayList;

import task.Task;

public class Sort {
	
	int maxtime=0;
	
	//1
		public ArrayList<Task> sortTasksByStart(ArrayList<Task> arraylistwithtasks){
			
			ArrayList<Task> returnarraylist = new ArrayList<Task>();
			
			for (int i = 0; i < arraylistwithtasks.size(); i++) {
				
				if(maxtime<=(arraylistwithtasks.get(i)).getStart())
					maxtime=arraylistwithtasks.get(i).getStart();
				}
			
			
			
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
	
	//2
	public ArrayList<Task> sortTopLevelsTasks(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		int currentid = 0,topleveltaskid=0;
		
		//xriazete gia tin sortTasksByStart
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			
			if(maxtime<=(arraylistwithtasks.get(i)).getStart())
				maxtime=arraylistwithtasks.get(i).getStart();
			}
		
		//sinexizei apo tin sortTasksByStart
		arraylistwithtasks=sortTasksByStart(arraylistwithtasks);
		
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
	
	public ArrayList<Task> setTopLevelInfos(ArrayList<Task> arraylistwithtasks){
		
		int topleveltaskid=0;
		
		//sinexizei apo tin sortTasksByStart
		arraylistwithtasks=sortTopLevelsTasks(arraylistwithtasks);

		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			

			if(arraylistwithtasks.get(i).getMamaId()==0) {//bazei ta toplevel tasks
				
				topleveltaskid=arraylistwithtasks.get(i).getTaskId();
				
				//SOS PREPEI NA BALW TRY CATCK EDW GIATI AN DEN YPARXEI 301 THA BGALEI INDEX OUT OF BOUNCE
				int start=arraylistwithtasks.get(i+1).getStart(); 
				int end=arraylistwithtasks.get(i+1).getEnd();
				int cost=0;
				 
				for (int j = 0; j < arraylistwithtasks.size(); j++) {
					
					if(arraylistwithtasks.get(j).getMamaId()==topleveltaskid) {
						cost=cost+arraylistwithtasks.get(j).getCost();
						
						if(arraylistwithtasks.get(j).getStart()<=start){
							start=arraylistwithtasks.get(j).getStart();
						}
						if(arraylistwithtasks.get(j).getEnd()>=end){
							end=arraylistwithtasks.get(j).getEnd();
						}
					}
				}
				
				Task temporary = new Task(arraylistwithtasks.get(i).getTaskId(),arraylistwithtasks.get(i).getName(),arraylistwithtasks.get(i).getMamaId(),start,end,cost);
				
				arraylistwithtasks.set(i, temporary);
			}
			
		}

		
		return arraylistwithtasks;
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
