package ProblemStatements;

public class TreeNode<T> {
	
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(){
		data=null;
		left=null;
		right=null;
	}
	
	public TreeNode(T val){
		data=val;
		left=null;
		right=null;
	}

	public TreeNode(TreeNode<T> node){
		data=node.data;
		left=node.left;
		right=node.right;
	}
}
