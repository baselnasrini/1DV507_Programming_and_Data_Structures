package mn223dn_assign4.binheap;

public interface PriorityQueue {
	
	public void insert (Task t);
	
	public Task pullHighest();
		
	public boolean contains(Task t);
	
	public int size();
	
	public boolean isEmpty();

	public Task peekHighest();

}