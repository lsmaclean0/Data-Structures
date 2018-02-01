/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author Luke
 */
public class DLList {
    public DLListNode head;
    public DLListNode tail;
    //set the head and tail equal to node

    //appending element at the end of the node												
    public void append(Object element){
        //is empty
	if(head==null){
            //create new head and tail using element
            head=tail=new DLListNode(element, null, null);
            return;
	}
	tail.next = new DLListNode(element, tail, null);	//passing in tail to new node	
	tail = tail.next;
    }
	
    //insert method, infront of node
    public void insert(Object element){
	//is empty
	if(head==null){
            //create new head and tail using element
            head=tail=new DLListNode(element, null, null);
            return;
	}
	//need to create new node, next feild needs to point to 
	head = new DLListNode(element, null, head);
	head.next.prev = head;
    }
	
    /**
    * remove method 
    * search for element in the node that matches element
    */
    public void remove(Object element){
        if(head==null) return;
        //comparison
        if(((Comparable)(head.data)).compareTo(element)==0){
            //check the sie of the node 
            if(head==tail){
                head=tail=null;
            }
            else{
                head = head.next;
                head.prev = null; 
            }
        }
        if(head==tail) return;
        DLListNode ref = head.next;
        while(ref!=tail){
            if(((Comparable)(ref.data)).compareTo(element)==0){
                ref.prev.next = ref.next;
		ref.next.prev = ref.prev;
		return;
            }
            ref = ref.next;
        }
        if(((Comparable)(tail.data)).compareTo(element)==0){
            tail = tail.prev;
            tail.next = null;
        }
    }
	
    /**
     * to String method, prints out each element in the list 
     * @return 
     */
    public String toString(){
	String out = "The DLList contains:\n";
	if(head==null){
            return out + " 0 nodes";
	}
	out+="head -->\t";
	DLListNode ref = head;
	while(ref != tail){
            out+=ref.data + "\t-->\t";
            ref=ref.next;
	}
	out+=tail.data + "\t<-- tail";
	return out;
    }
}
