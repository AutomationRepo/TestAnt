package ProblemStatements;

public class ThreeStacks<T> {
	
	private int stackSize=5;	
	private T[] data;
	private int[] tops = {-1,-1,-1};
	
	@SuppressWarnings("unchecked")
	public ThreeStacks(){		
		data = (T[]) new Object[stackSize*3];		
	}
	
	@SuppressWarnings("unchecked")
	public ThreeStacks(int size){
		stackSize=size;		
		data = (T[]) new Object[stackSize*3];
	}
	
	public void push(int stack,T val){
		if(isFull(stack)){
			System.out.println("Stack is full");
			return;
		}
		int index = stack*stackSize + tops[stack]+1;
		data[index] = val;
		tops[stack]++;
	}
	
	public T pop(int stack){
		if(isEmpty(stack)){
			System.out.println("Stack is empty");
			return null;
		}
		int index = stack*stackSize + tops[stack];
		T val = data[index];
		tops[stack]--;
		return val;		
	}
	
	public boolean isEmpty(int stack){
		return(tops[stack]==-1);
	}

	public boolean isFull(int stack){
		return(tops[stack]==stackSize-1);
	}
	
	public T peek(int stack){
		if(isEmpty(stack)){
			System.out.println("Stack is empty");
			return null;
		}
		int index = stack*stackSize + tops[stack];
		return(data[index]);
	}
	
	public int count(int stack){
		return(tops[stack]+1);
	}
	
	public void displayStack(int stack){
		int index = stack*stackSize;
		int tmpcnt = this.count(stack);
		while(tmpcnt>0){
			System.out.print(data[index]+" ");
			index++;
			tmpcnt--;
		}		
		System.out.println();
	}
}
