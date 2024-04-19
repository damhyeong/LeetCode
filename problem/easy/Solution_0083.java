package problem.easy;

/**
83. Remove Duplicates from Sorted List

Given the head of a sorted linked list, 
delete all duplicates such that each element appears only once. 
Return the linked list sorted as well.


 

Example 1:

Input: head = [1,1,2]
Output: [1,2]


Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]
 

Constraints:

* The number of nodes in the list is in the range [0, 300].
* -100 <= Node.val <= 100
* The list is guaranteed to be sorted in ascending order.
* 
* 
 */

public class Solution_0083 {
	public ListNode deleteDuplicates(ListNode head) {
        boolean[] checkNum = new boolean[201]; // checking number had been appered.
        ListNode resultNode = new ListNode(); // Entire Node.
        ListNode addressNode = resultNode; // It is Working node.
        ListNode previousNode = null; // remember node for remove at last. ( for removing 0 at last.)

        if(head == null){ // there is usecase ex - [] ==> It mean head equals null.
            return null;
        }

        while(head != null){
            int ckNum = head.val; // extract number from Origin ListNode.

            if(!checkNum[ckNum + 100]){ // if number is be first appered.
            	checkNum[ckNum + 100] = true;

                addressNode.val = ckNum;                
				addressNode.next = new ListNode();
				previousNode = addressNode;
				addressNode = addressNode.next;
                
            }
            
            head = head.next;
        }

        previousNode.next = null;

        return resultNode;
    }
}



