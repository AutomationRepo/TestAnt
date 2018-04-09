package ProblemStatements;

import java.lang.Comparable;

public class Sorting{	
	
	//Bubble sort
	public static <T extends Comparable <T>> void bubbleSort(T[] input){
		if(input.length <=1 )
			return;
		
		for(int i=0;i<input.length;i++){
			for(int j=0;j<input.length-1;j++){
				if((input[j].compareTo(input[j+1]) > 0)){
					T temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}					
			}
			for(int ii=0;ii<input.length;ii++)
				System.out.print(input[ii]+ ", ");
			System.out.println();
		}
	}
	
	public static <T extends Comparable <T>> void insertionSort(T[] input){
		if(input.length <=1 )
			return;
		
		for(int i=1;i<input.length;i++){
			for(int j=0;j<i;j++){
				if((input[j].compareTo(input[i]) > 0)){
					T temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}					
			}			
		}
	}
	
	public static <T extends Comparable <T>> void selectionSort(T[] input){
		if(input.length <=1 )
			return;
		
		for(int i=0;i<input.length-1;i++){	
			int min =i;
			for(int j=i+1;j<input.length;j++){				
				if((input[min].compareTo(input[j]) > 0)){
					min=j;
				}
				T temp = input[min];
				input[min] = input[i];
				input[i] = temp;
			}			
		}
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] input){
		if(input.length<=1)
			return;
		
		_quickSort_first(input,0,input.length-1);
		
		
	}

	@SuppressWarnings("unused")
	private static <T extends Comparable<T>> void _quickSort(T[] input, int start, int end) {
				
		int low = start;
		int high = end;
		
		T pivot = input[(low+high)/2];
		
		while(low<high){
			
			while(input[low].compareTo(pivot) < 0)
				low++;
			
			while(input[high].compareTo(pivot) > 0)
				high--;
			
			if(low<=high){
				T temp = input[low];
				input[low] = input[high];
				input[high] = temp;	
				high--;
				low++;
			}
		}
		
		//Check if segment is valid or not
		if(start<high)
			_quickSort(input,start,high);
		if(low<end)//Check if segment is valid or not
			_quickSort(input,low,end);
		
	}

	private static <T extends Comparable<T>> void _quickSort_first(T[] input, int start, int end) {
		
		 if (start >= end)
         {
             return;
         }
		 
		T pivot = input[start];
		int low = start+1;
		int high = end;		
		
		for(int i=low;i<=high;i++){
			if(input[i].compareTo(pivot)>=0){
				T temp = input[i];
				input[i] = input[high];
				input[high] = temp;	
				high--;
			}
		}
		
		T temp1 = input[start];
		input[start] = input[high];
		input[high] = temp1;
					
		//Check if segment is valid or not
		//if(start<high)
		_quickSort_first(input,start,high-1);
		//if(low<end)//Check if segment is valid or not
		_quickSort_first(input,high+1,end);
		
	}
}
