package ProblemStatements;

import javax.print.attribute.standard.Sides;

public class BinarySearchTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	
	public BinarySearchTree(){
		root=null;
	}
	
	public BinarySearchTree(T val){
		root=new TreeNode<>(val);
	}
	
	public BinarySearchTree(TreeNode<T> node){
		root=new TreeNode<>(node);
	}
	
	public boolean isEmpty(){
		return(root==null);
	}
	
	public void insert(T val){		
		root = _insert(root,val);	
	}
	
	private TreeNode<T> _insert(TreeNode<T> node, T value){
		if(node==null){
			node = new TreeNode<>(value);
			return node;
		}		
		
		if(value.compareTo(node.data) < 0 )
			 node.left = _insert(node.left,value);
		else 
			 node.right = _insert(node.right,value);
		
		return node;		
	}
	
	public void delete(T value){		
		 _delete(root,value);				
	}
	
	private void _delete(TreeNode<T> node,T val){
		if(node==null)
			return;
		
		if(val.compareTo(node.data) < 0)
			 _delete(node.left,val);
		else if(val.compareTo(node.data) > 0)
			 _delete(node.right,val);	
		else {
			TreeNode<T> min = minNode(node.right);
			TreeNode<T> parent = getParent(node,min.data);
			T temp = min.data;
			
			if(parent.right==min)
				parent.right=null;
			else
				parent.left = null;	
			
			node.data= temp;			
		}			
		
	}
	
	public TreeNode<T> getParent(TreeNode<T>node ,T val){
		if(node==null)
			return null;
		
		if (node.left!=null && node.left.data==val || node.right!=null && node.right.data==val)
			return node;
		else if(val.compareTo(node.data) < 0)
			return getParent(node.left, val);
		else
			return getParent(node.right, val);			
		
	}
	
	public TreeNode<T> minNode(TreeNode<T> node){
		if(node==null ||node.left==null)
			return node;		
			
		return minNode(node.left);
				 
	}
	
	public TreeNode<T> search(T val){
		return _search(root,val);
	}	
	
	private TreeNode<T> _search(TreeNode<T> node, T value){
		if(node==null || node.data.equals(value))
			return node;
		
		if(value.compareTo(node.data) < 0)
			return _search(node.left,value);
		return _search(node.right,value);		
	}
	
	public void preorder(TreeNode<T> node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);		
	}

	public void inorder(TreeNode<T> node){
		if(node==null)
			return;		
		
		inorder(node.left);
		System.out.print(node.data+" ");
		inorder(node.right);
		
	}
	
	public void postorder(TreeNode<T> node){
		if(node==null)
			return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data+" ");		
	}
	
	public int count(TreeNode<T> node){
		if(node==null)
			return 0;
		return count(node.left) + count(node.right) + 1;		
	}
	
	public int hight(TreeNode<T> node){
		if(node==null)
			return 0;
		if(node.left==null)
			return hight(node.right)+1;
		return hight(node.left)+1;
	}
	
	public void BFS(){
		MyQueue<TreeNode<T>> myQ= new MyQueue<>(count(root));		
		
		_BFS(root,myQ);
		
	}
	
	private void _BFS(TreeNode<T> node, MyQueue<TreeNode<T>> mq){
		if(node==null)
			return;
		
		System.out.print(node.data + " ");
		
		if(node.left!=null)
			mq.enque(node.left);
		if(node.right!=null)
			mq.enque(node.right);
		
		if(!mq.isEmpty())
			_BFS(mq.dequeue(), mq);
		
	}

	public void levelOrderPrint(int level){
		//for(int i=1; i<=hight(root);i++){
			//_levelOrder(root,i);
		//}
		if(level>hight(root)){
			System.out.println("level doesnt exists");
			return;
		}
		_levelOrder(root, level);
	}
	
	private void _levelOrder(TreeNode<T> node, int level){
		if(node==null)
			return;
		
		if(level==1)
			System.out.print(node.data+" ");
		else
			_levelOrder(node.left, level-1);
			_levelOrder(node.right, level-1);		
	}
	
	public int minDepth(TreeNode<T> node){
		if(node==null)
			return 0;
		return Math.min(minDepth(node.left)+1, minDepth(node.right)+1);
	}
	
	public int maxDepth1(TreeNode<T> node){
		if(node==null)
			return 0;
		int ldept = maxDepth1(node.left);
		int rdepth = maxDepth1(node.right);
		return 1+Math.max(ldept,rdepth );
	}
	
	public int maxDepth(TreeNode<T> node){
		if(node==null)
			return 0;
		return Math.max(maxDepth(node.left)+1, maxDepth(node.right)+1);
	}
	
	public boolean isTreeBalanced(){
		return(hight(root)-minDepth(root)<=1);
	}
	
	/**
	 * Find lowest common ancestor of given nodes - recursive
	 * @param val1
	 * @param val2
	 * @return
	 */
	public TreeNode<T> commonAncestor(T val1, T val2){	
		TreeNode<T> node1 = search(val1);
		TreeNode<T> node2 = search(val2);
		
		return _commonAncestor(root, node1, node2);	
	}
	
	private TreeNode<T> _commonAncestor(TreeNode<T> node,TreeNode<T> node1,TreeNode<T> node2){
		if(node==null || node1==null || node2==null)
			return null;
		if(node1.data.compareTo(node.data)<0 && node2.data.compareTo(node.data)<0)
			return _commonAncestor(node.left, node1, node2);
		if(node1.data.compareTo(node.data)>0 && node2.data.compareTo(node.data)>0)
			return _commonAncestor(node.right, node1, node2);
		return node;		
	}
	
	/**
	 * Find lowest common ancestor of given nodes - Iterative
	 * @param val1
	 * @param val2
	 * @return
	 */
 	public TreeNode<T> commonAnce(T val1,T val2){
		if(val1==null || val2==null)
			return null;
		TreeNode<T> node=root;
		
		while(node!=null){
			
			if(node.data.compareTo(val1)>0 && node.data.compareTo(val2)>0)
				node=node.left;
			
			if(node.data.compareTo(val1)<0 && node.data.compareTo(val2)<0)
				node=node.right;
			
			else
				break;
		}
		return node;
	}
	
	/**
	 * find distance between two nodes in tree
	 * @param val1
	 * @param val2
	 * @return
	 */

	public int distance(T val1,T val2){
		TreeNode<T> common = commonAncestor(val1, val2);		
		return _distance(common, val1) + _distance(common, val2);		
	}
	
	private int _distance(TreeNode<T> node, T val){
		if(node==null || node.data==val)
			return 0;
		
		if(val.compareTo(node.data) < 0)
			return _distance(node.left, val)+1;
		
		return _distance(node.right, val)+1;
	}
	
	/**
	 * Print all root-leaf node paths
	 */
	public void printAllLeafNodePaths(){
		if(root==null){
			System.out.println("Tree is empty");
			return;
		}
		
		Object[] path = new Object[count(root)*2];
		
		_pathRecu(path, root, 0);
	}
	
	private void _pathRecu(Object[] path,TreeNode<T> node,int index){
		if(node==null)
			return;
		
		path[index] = node.data;
		index++;
		
		if(node.left==null && node.right==null)
			printArray(path,index);
		else{
			_pathRecu(path, node.left, index);
			_pathRecu(path, node.right, index);
		}
				
	}
	
	private void printArray(Object[] input,int index){
		for(int i=0;i<index;i++){
			System.out.print(input[i]+" ");
		}
		System.out.println();
	}

	/** 
	 * Print path from root to given node
	 * @param val
	 */
	public void printPath(T val){
		_printPath(root,val);
	}
	
	private void _printPath(TreeNode<T> node, T value){
		
		try{
			System.out.print(node.data+" ");	
		}
		
		catch(Exception e){
			System.out.println("Node is not present");
		}
		
		if(node==null || node.data.equals(value))
			return;
				
		if(node.data.compareTo(value)<0)
			 _printPath(node.right,value);
		else
			_printPath(node.left,value);		
		
	}
	
	
	public TreeNode<T> getRoot() {
		return root;
	}
		
}
