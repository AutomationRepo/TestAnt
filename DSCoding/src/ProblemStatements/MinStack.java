package ProblemStatements;

public class MinStack<T extends Comparable<T>> {
	
	MyStack<T> orgStack;
	MyStack<T> minStack;
	private int size;
		
	public MinStack() {
		// TODO Auto-generated constructor stub
		
		orgStack = new MyStack<>();
		minStack = new MyStack<>();
	}
	
	public MinStack(int size) {
		// TODO Auto-generated constructor stub
		this.size=size;
		orgStack = new MyStack<>(this.size);
		minStack = new MyStack<>(this.size);
	}
	
	public void Push(T value){
		if(orgStack.isFull()){
			System.out.println("Stack is full");
			return;
		}		
		orgStack.push(value);
		if(minStack.isEmpty())
			minStack.push(value);
		else
			if(value.compareTo(minStack.getPeek()) <=0 )
				minStack.push(value);		
	}
	
	public T Pop(){
		if(orgStack.isEmpty()){
			System.out.println("Stack is empty -");
			return null;
		}
		if(orgStack.getPeek().equals(minStack.getPeek()))	
			minStack.pop();
		
		return orgStack.pop();
	}
	
	public T Min(){
		if(orgStack.isEmpty()){
			System.out.print("Stack is empty -");
			return null;
		}
		return minStack.getPeek();
	}

}
