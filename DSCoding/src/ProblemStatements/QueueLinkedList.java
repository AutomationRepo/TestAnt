package ProblemStatements;

public class QueueLinkedList<T> {
	LinkedList<T> myList ;
	
	public QueueLinkedList(){
		myList = new LinkedList<>();
	}
	
	public boolean isEmpty(){
		return(myList.getHead()==null);
	}

	public void enque(T val){		
		myList.addNode(val);
	}
	
	public T dequeue(){
		T val = myList.getHead().data;
		myList.deleteFirstNode();
		return val;
	}
	
	public int count(){
		return myList.count();
	}
	
	public void displayQueue(){
		myList.displayList();
		System.out.println();
	}
}
