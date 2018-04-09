package ProblemStatements;

public class QueueTwoStacks<T> {
	
	MyStack<T> ms;
	MyStack<T> tmp;
	private int size=5;
	
	public QueueTwoStacks(){
		ms =new MyStack<T>(this.size);
		tmp = new MyStack<T>(this.size);
	}
	
	public QueueTwoStacks(int size){
		this.size = size;
		ms =new MyStack<T>(this.size);
		tmp = new MyStack<T>(this.size);
	}
	
	public int count(){
		return(ms.count() + tmp.count());
	}
	
	public void enqueue(T val){		
		ms.push(val);
	}
	
	public T dequeue(){
		if(!tmp.isEmpty())
			return tmp.pop();
		while(!ms.isEmpty())
			tmp.push(ms.pop());
		return tmp.pop();
	}
	
	public T getPeek(){
		if(!tmp.isEmpty())
			return tmp.getPeek();
		while(!ms.isEmpty())
			tmp.push(ms.pop());
		return tmp.getPeek();
	}
}
