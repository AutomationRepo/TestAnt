package ProblemStatements;

import java.util.ArrayList;

public class SetOfStacks<T>{
	ArrayList<MyStack<T>> stackSet;
	private final int capacity = 5;
	
	public SetOfStacks(){
		stackSet = new ArrayList<MyStack<T>>();
	}
	
	public void push(T val){
		MyStack<T> last = getLastStack();
		if(last==null || last.isFull()){
			MyStack<T> newStack = new MyStack<>(capacity);
			newStack.push(val);
			stackSet.add(newStack);
		}
		else 
			last.push(val);
	}

	public T pop(){
		MyStack<T> last = getLastStack();
		T val = last.pop();
		if(last.isEmpty())
			stackSet.remove(stackSet.size()-1);
		return val;
	}
		
	private MyStack<T> getLastStack() {
		if(stackSet.size()==0)
			return null;
		return stackSet.get(stackSet.size()-1);
	}
	
	public T popAt(int index){
		if(stackSet.size()==0)
			return null;
		MyStack<T> stack = stackSet.get(index);
		T val = stack.pop();
		if(stack.isEmpty())
			stackSet.remove(index);
		else 
			shiftValues(index);
		return val;
	}
	
	private void shiftValues(int index){
		if(stackSet.size() > index+1){
			MyStack<T> tmp= new MyStack<>();
			MyStack<T> current = stackSet.get(index);
			MyStack<T> next = stackSet.get(index+1);
			while(!next.isEmpty())
				tmp.push(next.pop());
			current.push(tmp.pop());
			while(!tmp.isEmpty())
				next.push(tmp.pop());
			index = index+1;
			shiftValues(index);
		}				
	}

}
