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
public abstract class MyBinaryTree{
    public MyBinaryTreeNode root;
    
    
    /**
     * clear method
     *  can not have constructor bc abstract class e
     */
    
    /**
     * returns the size of the tree
     * Aka the number of nodes in the tree
     * @return sizeHelper 
     */
    public int size(){
        return sizeHelper(root);
    }
    private int sizeHelper(MyBinaryTreeNode rt){
        if(rt==null) return 0;
        return sizeHelper(rt.left) + sizeHelper(rt.right) + 1; 
    }
    
    /**
     * gets the height of the tree
     * @return 
     */
    public int height(){
       return heightHelper(root, -1);        
    }
    private int heightHelper(MyBinaryTreeNode rt, int ht){
        if(rt==null) return ht;
        //add additonal check 
        return Math.max(heightHelper(rt.left, ht+1), heightHelper(rt.right, ht+1));
    }
    
    /**
     * Transversing the tree by visiting the left subtree, then the left subtree
     * and finall the node 
     */
    public void preOrderTraversal(){
        preOrderHelper(root);
        System.out.println();
    }
    /**
     * helper method
     */
    private void preOrderHelper(MyBinaryTreeNode rt){
        if(rt==null) return;
        System.out.println("\t" + rt.data);
        preOrderHelper(rt.left);
        preOrderHelper(rt.right);
    }
    
    /**
     * 
     */
    public void inOrderTranseral(){
        inOrderHelper(root);
        System.out.println();
    }
    private void inOrderHelper(MyBinaryTreeNode rt){
        if(rt==null) return;
        preOrderHelper(rt.left);
        System.out.println("\t" + rt.data);
        preOrderHelper(rt.right);
    }
    
    
    /**
     * for post order do left, then right , then visit teh node 
     */
    public void postOrderTransversal(){
        postOrderHelper(root);
        System.out.println();
    }
    /**
     * helper method for post Order transversal 
     */
    private void postOrderHelper(MyBinaryTreeNode rt){
        if(rt==null) return;
        preOrderHelper(rt.left);
        preOrderHelper(rt.right);
        System.out.println("\t" + rt.data);
    }
}
