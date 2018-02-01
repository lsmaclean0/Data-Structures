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
public class DLListNode {
    public Object data;
    public DLListNode prev;			//pointing to the prevace node
    public DLListNode next;
    
    public DLListNode(Object d, DLListNode p, DLListNode n){
	data =d;
	prev =p;
	next =n;	
    }
}
