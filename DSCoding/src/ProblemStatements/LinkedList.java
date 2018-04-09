package ProblemStatements;

import java.util.Hashtable;

public class LinkedList<T> {
	private ListNode<T> head;

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public LinkedList() {
		head = null;
	}

	public LinkedList(T value) {
		head = new ListNode<>();
		head.data = value;
		head.next = null;
	}

	public LinkedList(ListNode<T> node) {
		head = node;
	}

	public void addNode(T value) {
		if (head == null) {
			head = new ListNode<>(value);
		} else {
			ListNode<T> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new ListNode<>(value);
		}
	}

	public void addNode(ListNode<T> node) {
		if (head == null)
			head = node;
		else {
			ListNode<T> tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = node;
		}
	}

	public void addNodeAt(T value, int position) {
		if (position <= 0)
			return;

		if (head == null)
			head = new ListNode<>(value);
		else {
			ListNode<T> tmp = getNode(position - 1);
			ListNode<T> tmp1 = tmp.next;
			tmp.next = new ListNode<>(value);
			tmp.next.next = tmp1;
		}
	}

	public void deleteLastNode() {
		if (head == null)
			return;
		ListNode<T> tmp = head;
		while (tmp.next.next != null)
			tmp = tmp.next;
		tmp.next = null;
	}

	public void deleteFirstNode() {
		if (head == null)
			return;
		head = head.next;
	}

	public void deleteNodeAt(int position) {
		if (head == null | position <= 0)
			return;

		ListNode<T> tmp = getNode(position - 1);
		tmp.next = tmp.next.next;
	}

	public ListNode<T> getNode(int position) {
		if (position < 0 | head == null)
			return null;
		int cnt = 1;
		ListNode<T> tmp = head;
		while (tmp.next != null) {
			if (cnt == position)
				break;
			tmp = tmp.next;
			cnt++;
		}
		return tmp;
	}

	public int count() {
		if (head == null)
			return 0;
		int cnt = 1;
		ListNode<T> tmp = head;
		while (tmp.next != null) {
			cnt++;
			tmp = tmp.next;
		}
		return cnt;
	}

	public void displayList() {
		if (head == null)
			return;
		ListNode<T> tmp = head;
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}

	public void reverseList() {
		if (head == null)
			return;
		ListNode<T> current = head;
		ListNode<T> previous = null;

		while (current != null) {
			ListNode<T> tmp = current.next;
			current.next = previous;
			previous = current;
			current = tmp;
		}
		head = previous;

	}

	public ListNode<T> reverseList_recur(ListNode<T> headNode) {
		if(headNode == null  || headNode.next==null)
            return headNode;

		ListNode<T> current = headNode;
		ListNode<T> rest = headNode.next;

        ListNode<T>  revese = reverseList_recur(rest);
        current.next.next= current;

        current.next = null;
       
        return revese;
		
	}

	public void reverseList_recur(ListNode<T> current, ListNode<T> previuos){
		if(current==null)
			return;
		
		if(current.next==null)
			head=current;	
				
		reverseList_recur(current.next,current);
		current.next=previuos;		
	}
	
	public ListNode<T> reversePartOfList(ListNode<T> headnode,int parts){
		if(headnode==null)
			return null;
		
		ListNode<T> current = headnode;
		ListNode<T> previuos = null;
		ListNode<T> next = null; 
		int cnt = 0;
		while(cnt<parts & current!=null){
			next = current.next;
			current.next=previuos;
			previuos=current;
			current=next;
			cnt++;				
		}	
		
		if(current!=null)
			headnode.next=reversePartOfList(current,3);
		
		return previuos;			
	}
	
	public void removeDuplicates_hash(){
		if(head==null)
			return;
		
		Hashtable<T, Boolean> hs= new Hashtable<>();
		ListNode<T> temp = head;
		ListNode<T> previuos = null;
		
		while(temp!=null){
			if(!hs.containsKey(temp.data)){
				hs.put(temp.data, true);
				previuos=temp;					
			}
			else{
				previuos.next=temp.next;
			}
			
			temp=temp.next;				
		}		
	}
	
	/**
	 * remove duplicate nodes
	 */
	public void removeDuplicates_InPlace(){
		if(head==null)
			return;
	/*
		ListNode<T> cur = head;		
		while (cur != null) {
			ListNode<T> tmp = cur.next;
			ListNode<T> prev = cur;
			while (tmp != null) {				
				if (cur.data.equals(tmp.data)) {
					prev.next = tmp.next;
				}
				else {
					prev = tmp;
				}
				tmp = tmp.next;				
			}
			cur = cur.next;			
		}
		*/
		ListNode<T> checker=head.next;
		ListNode<T> prev=head;	
		
		while(checker!=null) {
			ListNode<T> current=head;
			while(current!=checker){
				if(checker.data==current.data){
					prev.next=checker.next;	
				    break;
				}					
				current=current.next;
			}			
			if(current==checker)
				prev=prev.next;			
			checker=checker.next;			
		}		
		
	}
	
	public ListNode<T> nthNodeFromLast(int k){
		if(head==null | k<1)
			return null;
			
		ListNode<T> nNode = head;
		ListNode<T> current = head;
	
		for(int j=1;j<=k;j++){
			if(nNode==null)
				return null;			
			nNode=nNode.next;			
		}	
		
		while(nNode!=null){
			nNode=nNode.next;
			current=current.next;
		}		
		return current;
	}
	
	public boolean deleteGivenNode(ListNode<T> input){
		if(head==null | input==null|input.next==null)
			return false;
		
		T data = input.data;
		input.data=input.next.data;
		input.next.data= data;
		
		input.next=input.next.next;
		
		return true;
	}
	
	/**
	 * Add 2 linked list
	 * 
	 * @param input1 first linked list
	 * @param input2 second linked list
	 * @return added linked list
	 */
	public LinkedList<Integer> addTwoLists(LinkedList<Integer> input1, LinkedList<Integer> input2){
		if(input1==null & input2==null)
			return null;
		if(input1==null)
			return input2;
		if(input2==null)
			return input1;
		
		LinkedList<Integer> result = new LinkedList<>();
		int carry=0;		
		
		ListNode<Integer> temp1= input1.head;
		ListNode<Integer> temp2= input2.head;
		
		while(temp1!=null | temp2!=null){
			
			Integer res=carry;
			if(temp1!=null){
				res=res+temp1.data;
				temp1=temp1.next;
			}
				
			if(temp2!=null){
				res=res+temp2.data;
				temp2=temp2.next;
			}		
			
			carry=res/10;			
			result.addNode(res%10);			
		}
		return result;
	}
	
	public ListNode<T> startOfLoop(){
		if(head==null || head.next==null)
			return null;
			
		ListNode<T> slow = head.next;
		ListNode<T> fast = head.next.next;
		
		while(fast!=null && fast.next!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast)
					break;
			}
		
		if(fast==null || fast.next==null)
			return null;
		
		slow=head;
		while(slow!=fast){
			slow=slow.next;
			fast=fast.next;
		}
				
		return fast;
	}
	
	/**
	 * Verify if linked list is palindrome or not
	 * @return
	 */
	public boolean isPalindrome(){
		if(head==null || head.next ==null)
			return false;
		
		boolean stat=true;
		ListNode<T> slow = head;
		ListNode<T> fast = head;
		
		while(fast.next!=null && fast.next.next!=null){
			slow=slow.next;
			fast=fast.next.next;
		}
		fast=head;
		ListNode<T> tmp = reverseList_recur(slow.next);
		slow.next=tmp;
		
		while(tmp!=null){
			if(! fast.data.equals(tmp.data)){
				stat=false;
				break;
			}
			fast=fast.next;
			tmp=tmp.next;
				
		}
		
		//ListNode<T> tmp1 = reverseList_recur(slow.next);
		//slow.next=tmp1;
		return stat;				
	}
	
	
}
	
/*
class WrapperForRef{
	public Object ref;
	public WrapperForRef(Object ref){
		this.ref=ref;
	}
}
*/
