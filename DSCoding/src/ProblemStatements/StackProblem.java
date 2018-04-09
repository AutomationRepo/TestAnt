package ProblemStatements;

public class StackProblem<T extends Comparable<T>> {

	public MyStack<T> sortStack(MyStack<T> ms){
		MyStack<T> tmp = new MyStack<>();
		//until all items are sorted
		while(!ms.isEmpty()){
			T item = ms.pop();
			//take peek from tmp 
			//check if peek is less than popped item(ms)			
			//else			
				//pop items from tmp until item(ms) is less than pop from tmp
				//push item(ms) to tmp	
				while(!tmp.isEmpty() && tmp.getPeek().compareTo(item) < 0 )
					ms.push(tmp.pop());		
				tmp.push(item);
		}
		
		return tmp;
	}
}
