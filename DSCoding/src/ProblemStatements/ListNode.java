package ProblemStatements;

public class ListNode<T> {
	public T data;
	public ListNode<T> next;
	
	public ListNode(){
		this.next = null;				
	}

	public ListNode(T value){
		this.data = value;		
		this.next=null;
	}
	
	public ListNode(ListNode<T> node){
		this.data = node.data;
		this.next = node.next;
	}
} 
