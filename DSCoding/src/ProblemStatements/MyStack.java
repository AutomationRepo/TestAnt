package ProblemStatements;

public class MyStack<T> {
	private T[] data = null;
	private int top = -1;
	private int size = 5;
	
	@SuppressWarnings("unchecked")
	public MyStack(){
		data = (T[]) new Object[this.size];		
	}

	@SuppressWarnings("unchecked")
	public MyStack(int size){
		this.size=size;
		data = (T[]) new Object[this.size];
	}
	
	public boolean isFull(){
		if(top == size-1)
			return true;
		return false;
	}
	
	public boolean isEmpty(){
		if(top==-1)
			return true;
		return false;
	}
	
	public void push(T value){
		if(isFull()){
			System.out.println("Stack is full");
			return;
		}
				
		data[++top]=value;	
	}
	
	public T pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return null;						
		}		
		return data[top--];		
	}
	
	public int count(){
		return top+1;
	}
	
	public void displayStack(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return;
		}			
		for(int i=0;i<=top;i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}

	public T getPeek() {
		if(isEmpty())
			return null;
		return data[top];
	}

}
