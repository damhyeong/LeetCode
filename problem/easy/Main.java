package problem.easy;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Solution_0083 answer = new Solution_0083();
		
		ListNode inputNode = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
		
		ListNode result = answer.deleteDuplicates(inputNode);
		
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}

}
