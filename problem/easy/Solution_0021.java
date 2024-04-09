package problem.easy;

import java.util.*;
import java.io.*;

/**
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. 
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:

list1 = (1) --> (2) --> (4)
list2 = [1] --> [3] --> [4]

----------------------------

output = [1] --> (1) --> (2) --> [3] --> (4) --> [4]


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */


public class Solution_0021 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode newListNode = new ListNode();
		ListNode addressNode = newListNode;
		
		if(list1 == null && list2 == null) {
			return null;
		}
		
		
		// doing while Both of Lists have Next node.
		while(list1 != null && list2 != null) {
			int value1 = list1.val;
			int value2 = list2.val;
			
			// Divide Two Situations about current value of list1, list2.
			if(value1 <= value2) {
				addressNode.val = value1;
				
				list1 = list1.next;
			} else {
				addressNode.val = value2;
				
				list2 = list2.next;
			}
			
			addressNode.next = new ListNode();
			addressNode = addressNode.next;
		}
		
		// if list1 Node has Next Node.
		if(list1 != null) {
			// add Nodes Until list1 Node will not have any nodes.
			while(true) {
				addressNode.val = list1.val;
				if((list1 = list1.next) == null) {
					break;
				} // go to next node address.
				addressNode.next = new ListNode();
				addressNode = addressNode.next;
			}
		// if list2 node has Next nodes.
		} else if(list2 != null) {
			// add Nodes until list2 node will not have any nodes.
			while(true) {
				addressNode.val = list2.val;
				if((list2 = list2.next) == null) {
					break;
				}
				addressNode.next = new ListNode();
				addressNode = addressNode.next;
			}
		}
		addressNode = null;
		
		return newListNode;
	}
}


class ListNode{
	int val;
	ListNode next;
	ListNode(){
		
	}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}