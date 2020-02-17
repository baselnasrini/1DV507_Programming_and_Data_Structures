package mn223dn_assign4.binheap;


public class WorkTask implements Task{
	
	private int priority;
	private String description;

	public WorkTask(int in , String str){
		priority = in ;
		description = str;
	}
	
	public void setPriority(int input) {
		priority = input;
	}

	public int getPriority() {
		return priority;
	}

	public void setDescription(String input) {
		description = input;
	}
	
	public String getDescription() {
		return description;
	}
	
	public boolean equals(Task ta) {
		return this.getDescription().compareTo(ta.getDescription()) == 0 && ta.getPriority() == this.getPriority()  ;
	}
	
	@Override
	public String toString (){
		return description ;
	}

}
