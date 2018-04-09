package ProblemStatements;

public class MyQueue<T> {
	
	private T[] data = null;
	private int front = 0;
	private int rear = -1;
	private int size = 10;
	private int count = 0;
	
	@SuppressWarnings("unchecked")
	public MyQueue(){
		data = (T[]) new Object[this.size];
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue(int size){
		this.size=size;
		data = (T[]) new Object[this.size];
	}
	
	public boolean isEmpty(){
		return (count==0);
	}
	
	public boolean isFull(){
		return (count==size);
	}
	
	public void enque(T val){
		if(isFull()){
			System.out.println("Queue is full");
			return;
		}
		data[++rear] = val;
		count++;
	}
	
	public T dequeue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return null;
		}		
		
		T value = data[front++];
		count--;	
		if(count==0)
		{
			front=0;
			rear=-1;
		}	
		return value;
	}
	
	public int count(){
		return count;
	}
	
	public void displayQueue(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return;
		}
		
		for(int i=front;i<=rear;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	
	
}
