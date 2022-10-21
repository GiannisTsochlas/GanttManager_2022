package tasksbyprefix;

import java.util.*;
import task.Task;

public class TasksByPrefix {
	private String prefix;

	public TasksByPrefix(String prefix) { 
		this.prefix = prefix;
		
	}
	
	public static ArrayList<Character> convertStringToCharList(String str){
		
        // Create an empty List of character
        ArrayList<Character> chars = new ArrayList<>();

        // For each character in the String
        // add it to the List
        for (char ch : str.toCharArray()) {

            chars.add(ch);
        }
        // return the List
        return chars;
    }
	
	//Comments on that loop is to help to understand the code in case wi want to fix it  
	public ArrayList<Task> gettasksbyprefix(ArrayList<Task> arraylistwithtasks){
		
		ArrayList<Task> returnarraylist = new ArrayList<Task>();

//		System.out.println(convertStringToCharList(prefix));
//		
//		for (int i = 0; i < arraylistwithtasks.size(); i++) {
//			System.out.println(convertStringToCharList(arraylistwithtasks.get(i).getName()));
//			
//		}
		
	
		for (int i = 0; i < arraylistwithtasks.size(); i++) {
//			System.out.println("----------i=task name ="+i);
			int counter=0;
//			System.out.println((convertStringToCharList(arraylistwithtasks.get(i).getName())).get(0));
			for (int i1 = 0; i1 < convertStringToCharList(prefix).size(); i1++) {
//				System.out.println("i1 ="+i1);
				if(convertStringToCharList(prefix).get(i1)==convertStringToCharList(arraylistwithtasks.get(i).getName()).get(i1)) {
//					System.out.println("mphka sto if");
//					System.out.println("p["+i1+"]="+convertStringToCharList(prefix).get(i1));
//					System.out.println("l["+i1+"]="+convertStringToCharList(arraylistwithtasks.get(i).getName()).get(i1));
					counter=counter+1;
				}
					if(counter==convertStringToCharList(prefix).size()) {
//						System.out.println("to counter einai iso me to "+convertStringToCharList(prefix).size());
						returnarraylist.add(arraylistwithtasks.get(i));	
					}
				}				
			}
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
