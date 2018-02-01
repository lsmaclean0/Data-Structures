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

public class MyBinaryTreeNode implements Comparable <MyBinaryTreeNode>{
    //binary tree 
    //needa node to reference the left and right sides of the tree 
    public Object data;
    public MyBinaryTreeNode left;
    public MyBinaryTreeNode right;
    
    //create overloaded contructor
    public MyBinaryTreeNode(Object d){
        data = d;
        left = null;
        right = null;
    }
    
    public MyBinaryTreeNode(Object d, MyBinaryTreeNode l, MyBinaryTreeNode r){
        data = d;
        left = l;
        right = r;        
    }
    
    /**
     * prints out the data in the tree
     * @return 
     */
    public String toString(){
        return data.toString();
    }
    
    /**
     * comparing two BinaryTreeNodes 
     * @param target
     * @return 
     */
    public int compareTo(MyBinaryTreeNode target){
        return ((Comparable)this.data).compareTo(target.data);   
    }    
}
