/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.util.*;

/**
 *
 * @author Luke
 */
public class MyExpressionTree extends MyBinaryTree{
 
        public MyExpressionTree(){
        root = null;
    }
    
    
    public MyExpressionTree(MyBinaryTreeNode rt){
        root = rt;
    }
    
   
  public int evaluate(){
        if(root == null) return -1000000;
        return evaluateHelper(root);
    }
   
    private int evaluateHelper(MyBinaryTreeNode rt){
        try{
            
        if(rt.left == null&&rt.right==null){
            return Integer.parseInt(rt.data+"");
        }
        switch(rt.data+""){
        case "+":
            return evaluateHelper(rt.left)+evaluateHelper(rt.right);
           
        case "-":
            return evaluateHelper(rt.left)-evaluateHelper(rt.right);
        case "*":
            return evaluateHelper(rt.left)*evaluateHelper(rt.right);
        case "/":
            return evaluateHelper(rt.left)/evaluateHelper(rt.right);
        case "%":
            return evaluateHelper(rt.left)%evaluateHelper(rt.right);
        }
        return (Integer) 0;
    
    }catch(NumberFormatException ex){
        System.out.println("noh");
    }return 0;
}
    
    
}
