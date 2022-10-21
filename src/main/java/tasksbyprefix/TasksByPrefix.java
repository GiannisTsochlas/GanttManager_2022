package tasksbyprefix;

import java.util.ArrayList;
import task.Task;

public class TasksByPrefix {
	private String prefix;

	public TasksByPrefix(String prefix) { 
		this.prefix = prefix;
	}
	
	public ArrayList<Task> gettasksbyprefix(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();
		
//		System.out.println("gettasksbyprefix will be exicute with prefix :"+prefix+"\n");
		
		//apla printarei (den xriazete kapoy apla gia boithia)//an to exeis katalavei sbisto teleiws
//		for (int i = 0; i < arraylistwithtasks.size(); i++) {
//		      System.out.println("-"+arraylistwithtasks.get(i).getFirstWord()+"-");
//		}
		
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
			
			if(arraylistwithtasks.get(i).getFirstWord().equals(prefix)){

				//System.out.println("i found prefix "+prefix+" here \n"+arraylistwithtasks.get(i).getName());
				returnarraylist.add(arraylistwithtasks.get(i));
			} 
		}
		
		//printarei to return wste na dw an egine koble//an to exeis katalavei sbisto teleiws
//		for (int i = 0; i < returnarraylist.size(); i++) {
//			System.out.println(returnarraylist.get(i));
//		} 
		
		return returnarraylist;
	}
	
	public ArrayList<String[]> 	toString(ArrayList<Task> arl){
			
			ArrayList<String[]> indexes = new ArrayList<String[]>();
			for(int i=0; i<arl.size(); i++) {
				indexes.add(arl.get(i).tablestr());
			}
			return indexes;
	}			
}
