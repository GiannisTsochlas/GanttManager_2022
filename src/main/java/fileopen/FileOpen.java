package fileopen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import task.Task;
import java.util.ArrayList;

public class FileOpen {
	private String delimiter;
	private String fileName;
	
	public FileOpen(String delimiter, String fileName) {
		this.delimiter = delimiter;
		this.fileName = fileName;
	}
	public ArrayList<Task> loadfile(String delimiter, String fileName) {
		Scanner inputReader = null;
		
		try{
			inputReader = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("File filename was not found");
			System.out.println("or could not be opened");
			System.exit(0);
		}
		ArrayList<Task> task = new ArrayList<Task>();
		while(inputReader.hasNextLine()) {
				String line = inputReader.nextLine();
				String[] words = line.split(delimiter);
				for(int i=0; i<words.length; i++) {
					if(words.length==3) {
						Task task1 = new Task(Integer.parseInt(words[0]),words[1],Integer.parseInt(words[2]));
						task.add(task1);
					}else if(words.length==6) {
						Task task1 = new Task(Integer.parseInt(words[0]),words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5]));
						task.add(task1);
					}
				}
		}
		inputReader.close();
		return task;	
	}
}
