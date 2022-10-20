package task;

public class Task {
	private int taskId;
	private String name;
	private int mamaId;
	private int start;
	private int end;
	private int cost;
	
	public Task(int taskId, String name, int mamaId, int start, int end, int cost) {
		this.taskId=taskId;
		this.name=name;
		this.mamaId=mamaId;
		this.start=start;
		this.end=end;
		this.cost=cost;
	}
	
	public Task(int taskId, String name, int mamaId) {
		this.taskId=taskId;
		this.name=name;
		this.mamaId=0;
		this.start=0;
		this.end=0;
		this.cost=0;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMamaId() {
		return mamaId;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public int getCost() {
		return cost;
	}
	
	public String toString(int p) {
		return ""+p;
		
	}
	
	public String[] tablestr() {
		String[] tsk = {toString(taskId),name,toString(mamaId),toString(start),toString(end),toString(cost)};
		return tsk;
	}
}