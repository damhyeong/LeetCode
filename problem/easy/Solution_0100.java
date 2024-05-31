package problem.easy;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

/**
100. Same Tree
Easy
Topics
Companies

Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:

                                                 
      ( 1 )              ( 1 )                                        
      /   \              /   \                           
     /     \            /     \                       
   ( 2 )  ( 3 )       ( 2 )  ( 3 )                                  
                                           
Input: p = [1,2,3], q = [1,2,3]
Output: true


Example 2:
                                               
                                                
      ( 1 )    ( 1 )                                      
       /          \                               
      /            \                              
    ( 2 )         ( 2 )                                   
                                                
                                 
Input: p = [1,2], q = [1,null,2]
Output: false


Example 3:
                                                  
                                                  
          ( 1 )             ( 1 )                               
          /   \             /   \                    
         /     \           /     \                   
       ( 2 )  ( 1 )      ( 1 )  ( 2 )                              
                                                  

Input: p = [1,2,1], q = [1,1,2]
Output: false
 

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
 */

public class Solution_0100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p == null || q == null)
            return false;

        Queue1<TreeNode> queue = new Queue1<>();

        List1<TreeNode> list1 = new List1<>();
        List1<TreeNode> list2 = new List1<>();

        queue.add(p);

        while(!queue.isEmpty()){
            TreeNode element = queue.poll();
            list1.add(element);

            if(element == null)
                continue;

            queue.add(element.left);
            queue.add(element.right);
        }
        TreeNode[] arr1 = list1.toArray();

        queue.add(q);

        while(!queue.isEmpty()){
            TreeNode element = queue.poll();
            list2.add(element);

            if(element == null)
                continue;

            queue.add(element.left);
            queue.add(element.right);
        }
        TreeNode[] arr2 = list2.toArray();

        if(arr1.length != arr2.length)
            return false;
        
        boolean result = true;
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] == null && arr2[i] == null)
                continue;
            else if(arr1[i] == null && arr2[i] != null){
                result = false;
                break;
            } else if(arr1[i] != null && arr2[i] == null){
                result = false;
                break;
            }

            int val1 = arr1[i].val;
            int val2 = arr2[i].val;

            if(val1 != val2){
                result = false;
                break;
            }
        }

        return result;
    }
}

class List1 <T>{
    Node1<T> startNode;
    Node1<T> currNode;
    int size;

    public List1 (){
        this.size = 0;
    }

    public boolean add(T newValue){
        // if(newValue == null)
        //     return false;
        
        Node1<T> newNode = new Node1<>(newValue);
        
        if(isEmpty()){
            this.startNode = newNode;
            this.currNode = newNode;
        } else {
            this.currNode.setNextNode(newNode);
            newNode.setPreNode(this.currNode);
            this.currNode = newNode;
        }
        this.size++;
        return true;
    }
    public boolean isEmpty(){
        return this.size == 0 ? true : false;
    }
    public int size(){
        return this.size;
    }

    @SuppressWarnings("unchecked")
	public T[] toArray(){
    	if(isEmpty())
    		return (T[]) Array.newInstance(this.startNode.getValue().getClass(), 0);
    	
        T[] arr = (T[]) Array.newInstance(this.startNode.getValue().getClass(), this.size);
        
        Node1<T> curr = this.startNode;
        
        int index = 0;
        while(curr != null) {
        	arr[index++] = curr.getValue();
        	curr = curr.getNextNode();
        }
        
        return arr;
    }
}

class Queue1 <T>{
    Node1<T> startNode;
    Node1<T> headNode;
    int size;

    public Queue1(){
        this.size = 0;
    }

    public boolean add(T newValue){
        // if(newValue == null)
        //     return false;

        Node1<T> newNode = new Node1<>(newValue);

        if(isEmpty()){
            this.startNode = newNode;
            this.headNode = newNode;
        } else {
            newNode.setNextNode(this.startNode);
            this.startNode.setPreNode(newNode);
            this.startNode = newNode;
        }

        this.size++;
        return true;

    }
    public boolean push(T newValue){
        return this.add(newValue);
    }

    public T poll(){
        T returnValue = this.headNode.getValue();
        
        size--;

        if(!isEmpty()){
            this.headNode = this.headNode.getPreNode();
            this.headNode.setNextNode(null);
        } else {
            this.startNode = null;
            this.headNode = null;
        }

        return returnValue;
    }
    public T peek(){
        return this.headNode.getValue();
    }

    public boolean isEmpty(){
        return this.size == 0 ? true : false;
    }
    public int size(){
        return this.size;
    }
}

class Node1 <T> {
    T value;
    Node1<T> nextNode;
    Node1<T> preNode;

    public Node1(){

    }

    public Node1(T value){
        this.value = value;
        this.nextNode = null;
        this.preNode = null;
    }

    public void setValue(T value){
        this.value = value;
    }
    public T getValue(){
        return this.value;
    }

    public void setNextNode(Node1<T> nextNode){
        this.nextNode = nextNode;
    }
    public Node1<T> getNextNode(){
        return this.nextNode;
    }

    public void setPreNode(Node1<T> preNode){
        this.preNode = preNode;
    }
    public Node1<T> getPreNode(){
        return this.preNode;
    }
}

