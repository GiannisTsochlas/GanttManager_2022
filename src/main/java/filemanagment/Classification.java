package filemanagment;

import java.util.ArrayList;
import java.util.Collections;

import task.Task;

public class Classification {
	
	private int maxtime=0;
	
	//1
		public ArrayList<Task> sortTasksByStart(ArrayList<Task> arraylistwithtasks){
			
			ArrayList<Task> returnarraylist = new ArrayList<Task>();
			
			for (int i = 0; i < arraylistwithtasks.size(); i++) {
				
				if(maxtime<=(arraylistwithtasks.get(i)).getStart())
					maxtime=arraylistwithtasks.get(i).getStart();
				}
			
			
			
			for (int i = 0; i < maxtime+1; i++) {//diatrexei ton xrono
				
				for(int j=0;j<arraylistwithtasks.size(); j++) {//diatrexei ta tasks
					if((i==(arraylistwithtasks.get(j)).getStart())){
						returnarraylist.add(arraylistwithtasks.get(j));
					}
				}
		    }
			return returnarraylist;
		}
		
		
	//1.5	sort on top top level tasks
	public ArrayList<Task> getOnTopTopLevelTasks(ArrayList<Task> arraylistwithtasks){
		
		arraylistwithtasks=sortTasksByStart(arraylistwithtasks);
		
		ArrayList<Task> temporarylist1 =new ArrayList<Task>();
		ArrayList<Task> temporarylist2 =new ArrayList<Task>();
		ArrayList<Task> appendlist =new ArrayList<Task>();
		
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			if(arraylistwithtasks.get(i).getMamaId()==0) {
				temporarylist1.add(arraylistwithtasks.get(i));
			}	
		}
		Collections.reverse(temporarylist1);
		for (int i1 = 0; i1 < temporarylist1.size(); i1++) {
			try {
			if(temporarylist1.get(i1).getTaskId()+100==temporarylist1.get(i1+1).getTaskId()) {
				Collections.swap(temporarylist1, i1,i1+1);
			}
			}
			catch(Exception e) {
				break;
			}
		}
		Collections.reverse(temporarylist1);
		
		for (int i1 = 0; i1 < arraylistwithtasks.size(); i1++) {
			if(arraylistwithtasks.get(i1).getMamaId()!=0) {
				temporarylist2.add(arraylistwithtasks.get(i1));
			}	
		}
		
		appendlist.addAll(temporarylist1);
		appendlist.addAll(temporarylist2);
		

		
		return appendlist;	
	}
	
	//2
	public ArrayList<Task> sortTopLevelsTasks(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		int currentid = 0,topleveltaskid=0;
		
		//sinexizei apo tin getOnTopTopLevelTasks
		
		arraylistwithtasks=getOnTopTopLevelTasks(arraylistwithtasks);
		
		
		
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
		
		//sinexizei apo tin sortTopLevelsTasks
		arraylistwithtasks=sortTopLevelsTasks(arraylistwithtasks);

		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			
			try {
			if(arraylistwithtasks.get(i).getMamaId()==0&&arraylistwithtasks.get(i+1).getMamaId()!=0) {//bazei ta toplevel tasks
				
				topleveltaskid=arraylistwithtasks.get(i).getTaskId();
				
				
				try {
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
					catch(Exception e) {
					  break;
					}	
			}
			else continue;
			}
			catch(Exception e) {
				
			}
		}
		return arraylistwithtasks;
	}
	
	//diorthonei ta idia start koitaei to task id 
	public ArrayList<Task> FinalSort(ArrayList<Task> arraylistwithtasks){
		
		
		//synexizoyme apo tin setTopLevelInfos
		arraylistwithtasks=setTopLevelInfos(arraylistwithtasks);

		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			try {
				if(arraylistwithtasks.get(i).getStart()==arraylistwithtasks.get(i+1).getStart()){
					if(arraylistwithtasks.get(i).getTaskId()>arraylistwithtasks.get(i+1).getTaskId()){
						Collections.swap(arraylistwithtasks, i,i+1);
					}
				}
				}
				catch(Exception e) {
				  //System.out.println("out of bounce ");
				  break;
				}
			
		}
		return arraylistwithtasks;
	}
	
	
	
	
	
	//"Convert" indexes TASKS of an ArrayList to STRING 
	public ArrayList<String[]> 	toString(ArrayList<Task> arl){
			
			ArrayList<String[]> indexes = new ArrayList<String[]>();
			for(int i=0; i<arl.size(); i++) {
				indexes.add(arl.get(i).infosInStringArray());
			}
			return indexes;
	
	}
}
