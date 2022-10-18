package task;

public class Task {
	int taskId;
	int mamaId;
	int start;
	int end;
	int cost;
	
	public Task(int taskId, int mamaId, int start, int end, int cost) {
		this.taskId=taskId;
		this.mamaId=mamaId;
		this.start=start;
		this.end=end;
		this.cost=cost;
	}
	
	public Task(int taskId, int mamaId) {
		this.taskId=taskId;
		this.mamaId=0;
		this.start=0;
		this.end=0;
		this.cost=0;
	}	
}