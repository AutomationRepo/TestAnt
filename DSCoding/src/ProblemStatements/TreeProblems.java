package ProblemStatements;

import ProblemStatements.BinarySearchTree;

public class TreeProblems<T extends Comparable<T>> {

/**
 * Create Binary search tree from sorted array
 * @param input
 * @return binary search tree
 */
public BinarySearchTree<T> createBST(T[] input){			
		
		int arrSize = input.length;
		
		if(input==null || input.length<1)
			return null;			
		
		BinarySearchTree<T> tree = new BinarySearchTree<>();
		_createBST(0, arrSize-1, input, tree);
		return tree;
	}
	
private void _createBST(int low,int high,T[] input,BinarySearchTree<T> bst){				
		if(low>high)
			return;
		int mid = (low+high)/2;		
		bst.insert(input[mid]);
		_createBST(low, mid-1, input, bst);
		_createBST(mid+1, high, input, bst);		
	}


}
