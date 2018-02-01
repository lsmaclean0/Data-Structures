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
public class MyDeque extends DLList{

    public MyDeque(){
        super();
	//set head and tail to null
        head = null;
        tail = null;
    }
	
    public Object front(){
	if(head==null){
            return null;
	}
	return head.data;
    }
	
    public Object back(){
        if(tail==null) return null;
	else return tail.data;
    }
	
    public void insertBack(Object element){		//enqueue
	append(element);
    }

    public void insertFront(Object element){	
	insert(element);
    }
	
    public Object removeBack(){
	//remove the last node 
	if(head==null){
            return null;
	}
	//temp hold for value
	Object temp = tail.data;
	if(head==tail){
            head = tail = null;
            return temp;
	}
	tail=tail.prev;			//pointing to the tail infront
	tail.next=null;
	return temp;
    }
	
    //take data from the front then remove that node
    public Object removeFront(){
	if(head==null){
            return null;
	}
	Object temp = head.data;
            if(head==tail){
                head = tail = null;
		return temp;
            }
        head=head.next;
	head.prev=null;
	return temp;
    }
	
    /**
    * is empty method
    */
    public boolean isEmpty(){
        if(head==null && tail==null) return true;
        return false;
    }
	
	
    /**
    * to string, prints out all of the elements in the queue 
    */
    public String toString(){
	String out = "The Deque contains:\n";
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
	
    /**
    * Overriding remove method from super class
    */
    @Override 
    public void remove(Object element){
	
    }
	
	
    /**
     * clears the list 
     */
    public void clear(){
    	while(head.next!=null && tail.next!=null){
            head=null;
            tail=null;
        }
    }
    
   public int size(){
       int size=0;
       while(head.next!=null){
           size++;
       }
       return size;
   }
}
