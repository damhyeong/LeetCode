package problem.medium;

public class Solution_0002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode startNode = null;
        ListNode tempNode = null;
        ListNode currNode = null;
        int nextPlus = 0;

        while(l1 != null && l2 != null){
            int newVal = l1.val + l2.val + nextPlus;
            nextPlus = newVal / 10;
            newVal = newVal % 10;

            ListNode newNode = new ListNode(newVal);

            if(startNode == null){
                startNode = newNode;
                currNode = newNode;
            } else {
                tempNode = currNode;
                tempNode.next = newNode;
                currNode = tempNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int newVal = l1.val + nextPlus;
            nextPlus = newVal / 10;
            newVal = newVal % 10;

            ListNode newNode = new ListNode(newVal);

            tempNode = currNode;
            tempNode.next = newNode;
            currNode = tempNode.next;

            l1 = l1.next;
        }

        while(l2 != null){
            int newVal = l2.val + nextPlus;
            nextPlus = newVal / 10;
            newVal = newVal % 10;

            ListNode newNode = new ListNode(newVal);

            tempNode = currNode;
            tempNode.next = newNode;
            currNode = tempNode.next;

            l2 = l2.next;
        }

        if(nextPlus != 0){
            ListNode newNode = new ListNode(nextPlus);

            currNode.next = newNode;
        }

        return startNode;
    }
}
