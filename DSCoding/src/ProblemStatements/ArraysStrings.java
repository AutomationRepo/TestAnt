package ProblemStatements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedHashSet;

class ArraysStrings {
	
	// with brute force its O(n2)
	//Check if string has unique chars by 256 char array O(n)
	public static boolean areUniqueChars_256(String input) {
		
		//if string is null or empty return true
		if(input==null || input.isEmpty())
			return true;
			
		boolean[] chars = new boolean[256];
		for(int i= 0;i<input.length();i++){
			if(chars[input.charAt(i)])
				return false;
			chars[input.charAt(i)] = true;
		}
			
		return true;
	}

	//Check if string has unique chars by bit manipulation O(n)
	public static boolean areUniqueChars_bit(String input){		
		if(input == null || input.isEmpty())
			return true;
		int checker = 0;
		//input = input.toLowerCase();
		for(int i = 0; i<input.length();i++){
			int val = input.charAt(i) - 'a';
			if((checker &  (1 << val) ) > 0)
				return false;
			checker = checker | (1 << val); 
		}
		return true;
	}
	
	//Check if string has unique chars by sorting string O(n log n)
	public static boolean areUniqueChars_sorting(String input){
		if(input == null || input.isEmpty())
			return true;
		
		char[] charArray = input.toCharArray();		
		Arrays.sort(charArray);
		for(int i =0; i<charArray.length-1;i++){
			if(charArray[i] == charArray[i+1])		
				return false;			
		}
		return true;		
	}
	
	//Reverse string using two pointers O(n/2)
	public static String reverseString(String input){
		if(input == null || input.isEmpty())
			return null;
		
		char[] charArray = input.toCharArray();
		for(int start = 0,end=input.length()-1;start<end;start++,end--){
			char temp = charArray[start];
			charArray[start] = charArray[end] ;
			charArray[end] = temp;
		}
		return String.valueOf(charArray);
	}
	
	//Reverse string using string builder(n)
	public static String reverseString_SB(String input){
		if(input == null || input.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder(input);
		sb.reverse();
		return sb.toString();
	}
	
	//Remove duplicates using 256 chars and string builder
	public static String removeDuplicates(String input){
		if(input == null || input.isEmpty())
			return null;
		
		boolean[] chars = new boolean[256];		
		StringBuilder sb = new StringBuilder(chars.length);
		for(int i =0 ; i<input.length();i++){
			if(!chars[input.charAt(i)]){
				chars[input.charAt(i)] = true;
				sb.append(input.charAt(i));
			}				
		}		
		return sb.toString();
	}
	
	//Remove duplicates using LinkedHashSet
	public static String removeDuplicate_LHS(String input){
		if(input == null || input.isEmpty())
			return null;
		//Set<Character> lhs = new LinkedHashSet<Character>();
		LinkedHashSet<Character> lhs = new LinkedHashSet<Character>();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<input.length();i++)
			lhs.add(input.charAt(i));	
		
		for(Character ch:lhs)
			sb.append(ch);
		
		return sb.toString();
	}

	//Remove duplicates using chararray
	public static String removeDuplicate_array(String input){
			if(input == null || input.isEmpty())
				return null;
			
			char[] charArray = input.toCharArray();
			int tail=1;
			
			for(int i=1;i<input.length();i++){
				int j;
				for(j=0;j<tail;j++){
					if(charArray[i]==charArray[j])
						break;
				}
				if(j==tail){
					charArray[tail] = charArray[i];
					tail++;
				}			
				
			}			
			return new String(charArray,0,tail); //   Arrays.toString(charArray);//charArray.toString();
		}
	
	//check if two strings are anagram or not by hashtable
	public static boolean isStringAnagram(String input1, String input2){
		if((input1==null & input2==null))
			return true; 		
		if((input1==null | input2==null))
			return false;		
		if(input1.length()!=input2.length())
			return false;
		
		int uniqueChars=0;
		int completed=0;
		Hashtable<Character,Integer> ht = new Hashtable<Character,Integer>();
		for(int i=0;i<input1.length();i++){
			int temp=0;
			if(!ht.containsKey(input1.charAt(i))){				
				uniqueChars++;
			}
			else{
				 temp = ht.get(input1.charAt(i));
			}
			temp++;
			ht.put(input1.charAt(i),temp);
		}
		
		for(int j=0;j<input2.length();j++){
			if(!ht.containsKey(input2.charAt(j)))
				return false;
			
			int temp = ht.get(input2.charAt(j));
			temp--;
			ht.put(input2.charAt(j), temp);
			if(ht.get(input2.charAt(j)) == 0){
				completed++;	
				ht.remove(input2.charAt(j));
			}				
		}
		
		if(uniqueChars==completed)
			return true;
		return false;
	}
	
	//Check if two strings are anagram by sorting
	public static boolean isStringAnagram_sort(String input1,String input2){
		if((input1==null & input2==null))
			return true; 		
		if((input1==null | input2==null))
			return false;		
		if(input1.length()!=input2.length())
			return false;
		
		char[] char1 =input1.toCharArray();
		char[] char2 =input2.toCharArray();
		
		Arrays.sort(char1);
		Arrays.sort(char2);		
		if(Arrays.equals(char1, char2))
			return true;
		return false;
		
		//String s1 = new String(char1);
		//String s2 = new String(char2);
		//if(s1.equals(s2))
		//	return true;
		//return false;		
	}
	
	//replace space by stringbuilder
	public static String replaceSpace(String input){
		if(input == null | input.isEmpty())
			return null;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==32)
				sb.append("%20");
			else
				sb.append(input.charAt(i));
		}
		return sb.toString();
	}
	
	//replace space in string using char array
	public static String replaceSpace_array(String input){
		if(input == null | input.isEmpty())
			return null;
		
		int noOfSpace=0;
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)==32)
				noOfSpace++;
		}
		
		int size = input.length() + noOfSpace*2;
		char[] charArray = new char[size];
		for(int j=input.length()-1;j>=0;j--){
			if(input.charAt(j)==32){				
				charArray[size-1]='0';
				charArray[size-2]='2';
				charArray[size-3]='%';
				size=size-3;
			}
			else{
				charArray[size-1]=input.charAt(j);
				size = size-1;
			}
			
		}
		return String.valueOf(charArray);
	}
	
	public static char[][] rotateMatrix(char[][] input){
		if(input.length <=0)
			return null;
		
		char[][] rotatedPixel = new char[input[0].length][input[1].length];
		for (int i = 0; i < input.length; i++) {
	           for (int j = 0; j < input[0].length; j++) {
	               rotatedPixel[j][input.length-1-i] = input[i][j];
	           }
		}
		return rotatedPixel;
	}
	
	public static char[][] rotateMatrix_inPlace(char[][] input){
		if(input.length <=0)
			return null;
		
		//cyclic approach
		//Switch elements layer by layer
		for(int layer=0;layer<input.length/2;layer++){
			int first = 0;
			int last = input.length-1-layer;
			for(int i=first;i<last;i++)
			{
				int os = i-first;
				char temp=input[first][i];
				// left -> top
				input[first][i] = input[last-os][first];
				//bottom -> left
				input[last-os][first] = input[last][last-os];
				//right->bottom
				input[last][last-os] =input[i][last];
				input[i][last] = temp;
			}
			
		}
		return input;
	}
	
	public static char[][] rotateMatrix_transpose(char[][] input){
		if(input.length <=0)
			return null;
		
		for(int i=0;i<input.length;i++){
			for(int j=i+1;j<input.length;j++){
				char tmp = input[i][j];
				input[i][j] = input[j][i];
				input[j][i] = tmp;
			}		
		}
		
		for (int i = 0; i < input[0].length; i++)
	    {
			for (int j = 0; j < input.length; j++)
	        {
	            char tmp = input[j][i];
	            input[j][i] = input[j][input.length - i - 1];
	            input[j][input.length - i - 1] = tmp;
	        }
	    }
		return input;
	}
	
	public static int[][] setAllRowAndColZero(int[][] input){
		if(input.length <=0)
			return null;
		
		int[] row = new int[input.length];
		int[] col = new int[input[0].length];
		
		for(int i=0;i<row.length;i++){
			for(int j=0;j<col.length;j++){
				if(input[i][j] == 0){
					row[i]=1;
					col[j]=1;
				}
			}
		}
		
		for(int i=0;i<row.length;i++){
			for(int j=0;j<col.length;j++){
				if(row[i] == 1 | col[j] == 1){
					input[i][j]=0;
				}
			}
		}
	return input;
	}

	public static boolean isRotation(String input1,String input2){
		if(input1==null | input2==null)
			return false;
		if(input1.length() == input2.length() & input1.length()>0){
			String res= input1+input1;
			return isSubstring(res,input1);
		}
		return false;		
	}

	private static boolean isSubstring(String res, String input1) {
		return res.contains(input1);		
	}
	
	public static void testTryFinally(){
		int b = 10;
		int a=0;
		double c;
		
		try{
			 c = divide(b, a);
		}
		finally{			
			System.out.println("from finally block");
			System.out.println();
		}
		
		System.out.println("Hi " + c);
	}
		
	public static double divide(int temp,int div) throws ArithmeticException{
		return temp/div;
	}
	
	public static void testCatch(){
		int b = 10;
		int a=0;
		double c=0;
				
		try{
			// c = divide(b, a);
			FileInputStream fis = new FileInputStream("C://text.txt");
			
		}catch(Exception e){
			c = 10/2;			
			e.printStackTrace();
		}	
		
		System.out.println("Hi " + c);
	}
}
