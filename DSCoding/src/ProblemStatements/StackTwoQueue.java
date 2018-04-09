package ProblemStatements;

public class StackTwoQueue<T> {
	
	MyQueue<T> mq1;
	MyQueue<T> mq2;
	private int size=5;
	
	public StackTwoQueue(){
		mq1=new MyQueue<>(this.size);
		mq2=new MyQueue<>(this.size);
	}
	
	public StackTwoQueue(int size){
		this.size = size;
		mq1=new MyQueue<>(this.size);
		mq2=new MyQueue<>(this.size);
	}
	
	public void push(T val){
		mq1.enque(val);
	}
	
	public T pop(){
		while(mq1.count()>1)
			mq2.enque(mq1.dequeue());
		
		T item = mq1.dequeue();
		
		MyQueue<T> tmp = new MyQueue<>();
		tmp=mq1;
		mq1=mq2;
		mq2=tmp;
		
		return item;
	}
	
	
	public int count(){
		return mq1.count();
	}

}
