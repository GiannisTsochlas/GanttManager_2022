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
		{
		try{
			inputReader = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("File filename was not found");
			System.out.println("or could not be opened");
			System.exit(0);
			}
		
		String line = inputReader.nextLine();
		
		inputReader.close();
		}
	}
}
