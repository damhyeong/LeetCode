package problem.easy;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution_0021 answer = new Solution_0021();
		
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		
		ListNode answerList = answer.mergeTwoLists(list1, list2);
		
		while(answerList != null) {
			System.out.println(answerList.val);
			answerList = answerList.next;
		}
		
	}

}
