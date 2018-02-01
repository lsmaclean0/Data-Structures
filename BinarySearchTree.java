/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.NoSuchElementException;

        
/**
 *
 * @author Luke
 */
public class BinarySearchTree extends MyBinaryTree{
    
    //get other methods from pictures!!!!!!!! 
        
        public void insert(Object item){
        root = insertHelper(root, new MyBinaryTreeNode(item));
    }
    
    /*
    recursive helper method for insert 
    */
    private MyBinaryTreeNode insertHelper(MyBinaryTreeNode rt, MyBinaryTreeNode newNode){
        if(rt==null){
            rt = newNode;
            return rt;
        }
        if(newNode.compareTo(rt)<0){
            rt.left = insertHelper(rt.left, newNode);
        }
        else{
            rt.right = insertHelper(rt.right, newNode);
        }
        return rt;
    }
    /**
     * 
     * @param target
     * @return 
     */
    public MyBinaryTreeNode find(Object target){
        return findHelper(root, new MyBinaryTreeNode(target));      //anonymus object creation
    }
    
    /**
     * 
     * @param rt
     * @param targetNode
     * @return 
     */
    private MyBinaryTreeNode findHelper(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode){
        if(rt==null) return null;
        //if the root is bigger then the target 
        if(rt.compareTo(targetNode)>0){
            return findHelper(rt.left, targetNode);
        }
       //if the root is leff than target 
        if(rt.compareTo(targetNode)<0){
            return findHelper(rt.right, targetNode);
        }
        //if both cases are not possible then return rt, ie they are equal 
        return rt;
    }
    
    /**
     * 
     * @param rt
     * @param targetNode
     * @return 
     */
    private MyBinaryTreeNode findParent(MyBinaryTreeNode rt, MyBinaryTreeNode targetNode){
        if(targetNode.compareTo(rt) < 0){
            if(rt.left==null){
                return null;
            }
            else if(targetNode.compareTo(rt.left) == 0){
                return rt;
            }
            else{
                return findParent(rt.left, targetNode);
            }
        }
        else{
            if(rt.right==null){
                return null;
            }
            else if(targetNode.compareTo(rt.right)==0){
                return rt;
            }
            else{
                return findParent(rt.right, targetNode);
            }
        }
    }
    
    /**
     * looking for the successor node 
     * @return 
     */
    private MyBinaryTreeNode successorParent(MyBinaryTreeNode rt){
        //starting at the node we want to remove, looking for its successor 
        if(rt==null){
            return null;
        }
        if(rt.right == null){
            return null;
        }
        if(rt.right.left==null){
            return null;
        }
        MyBinaryTreeNode temp = rt.right;
        while(temp.left.left!=null){
            temp=temp.left;
        }
        return temp;
    }
    /**
     * removing a node from the binary search tree
     * @param target
     */
    public void remove(Object target){
        if(root==null) return;
        MyBinaryTreeNode targetNode = new MyBinaryTreeNode(target);
        if(root.compareTo(targetNode)==0){
            MyBinaryTreeNode sp1 = successorParent(root);
            if(sp1==null && root!=null){
                root=root.left; 
            }
            else if(sp1==root){
                root.right.left=root.left;
                root=root.right;
            }
            else{
                MyBinaryTreeNode rightChildOfSucc = sp1.left.right;
                sp1.left.left = root.left;
                sp1.left.right = root.right;
                root=sp1.left;
                sp1.left=rightChildOfSucc;
            }
            return;
        }
        MyBinaryTreeNode targetParent = findParent(root, targetNode);
        if(targetParent==null) return;
        /*checking if the left target parent != nul*/
        if(targetParent.left!=null){
            if(targetParent.left.compareTo(targetNode)==0){
                //temp reference to targetParent left node
                MyBinaryTreeNode rNode = targetParent.left;
                MyBinaryTreeNode sp2 = successorParent(rNode);
                if(rNode.left==null && rNode.right==null){
                    targetParent.left=null;
                }
                else if(sp2==null && rNode!=null){
                    //the rNode has no right child
                    targetParent.left = rNode.left;
                }
                else if(sp2==rNode){
                    //the rNode's right child has no left child
                    sp2.right.left = rNode.left;
                    targetParent.left = sp2.right;
                }
                //General case 
                else{
                    MyBinaryTreeNode rightChildOfSucc = sp2.left.right;
                    sp2.left.left = rNode.left;
                    sp2.left.right = rNode.right;
                    targetParent.left = sp2.left;
                    sp2.left = rightChildOfSucc;
                }
                return;
            }
        }
        //if we havent found the node we want to remove yet 
        if(targetParent.right!=null){  
            if(targetParent.right.compareTo(targetNode)==0){
                //targetNode is the node we want to remove 
                MyBinaryTreeNode rNode = targetParent.right;        //temporary reference to the right child of TargetParent
                MyBinaryTreeNode sp3 = successorParent(rNode);
                if(rNode.left==null && rNode.right==null){
                    //if true then rNode is a leaf node 
                    targetParent.right = null;   
                }
                else if(sp3==null && rNode!=null){
                    //the rNode has no right child
                    targetParent.right = rNode.left;
                }
                else if(sp3==rNode){
                    //the rNode's left child has no right child
                    sp3.right.left = rNode.left;
                    targetParent.right = sp3.right;
                }
                //general case
                else{
                    //the successsor must be the left child of the successor parent
                    //creating temp reference to oright child of successor
                    MyBinaryTreeNode rightChildOfSucc = sp3.left.right;
                    sp3.left.left = rNode.left;
                    sp3.left.right = rNode.right;
                    targetParent.right = sp3.left;
                    sp3.left = rightChildOfSucc;
                }
                return;
            }
        }
    } //end of remove method 
    
    /*
    method to find the smallest vale in the tree
    */
    public int getMin(){
        if (root == null) {
            throw new NoSuchElementException();
        }
        return getMin(root);
    }
    /*
    helper method for getMin
    */
    private int getMin(MyBinaryTreeNode rt){
        if(rt.left==null){
            return (int) rt.data;
        }
        else{
            return getMin(rt.left);
        }
    }
    
    /*
    method to find the maximum value in the BST
    */
    public int getMax(){
        if(root==null){
            throw new NoSuchElementException();
        }
        return getMax(root);
    }
    private int getMax(MyBinaryTreeNode rt){
        if(rt.right==null){
            return (int) rt.data;
        }
        else{
            return getMax(rt.right);
        }
    }
    
   
} //end of binary Search Tree

