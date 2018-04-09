package ProblemStatements;

public class MyCircularQueue<T> {

		private T[] data;
		private int rear=-1;
		private int front=0;
		private int count=0;
		private int size=10;
		
		@SuppressWarnings("unchecked")
		public MyCircularQueue(){
			data = (T[]) new Object[this.size];
		}
		
		@SuppressWarnings("unchecked")
		public MyCircularQueue(int size){
			this.size=size;
			data = (T[]) new Object[this.size];
		}
		
		private boolean isEmpty(){
			return(count==0);
		}
		
		private boolean isFull(){
			return(count==size);
		}
		
		public void enque(T val){
			if(isFull()){
				System.out.println("Queue is full");
				return;
			}
			rear=(rear+1)%this.size;
			data[rear]=val;
			count++;			
		}
		
		public T dequeue(){
			if(isEmpty()){
				System.out.println("Queue is empty");
				return null;
			}			
			T val = data[front];
			front=(front+1) % this.size;
			count--;
			return val;
		}
		
		public int count(){
			return this.count;
		}
		
		public void displayQueue(){
			if(isEmpty())
				return;
			int cnt = this.count;
			int index = front;
			while(cnt>0){				
				System.out.print(data[index] + " ");
				index=(index+1)%size;
				cnt--;
			}
			System.out.println();
		}
}
