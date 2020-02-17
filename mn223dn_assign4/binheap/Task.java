package mn223dn_assign4.binheap;

public interface Task {

	 public boolean equals(Task t);
	 
	 public void setPriority(int input);

	 public int getPriority();
	 
	 public void setDescription(String input);

	 public String getDescription();
	 
	 public String toString();

}
