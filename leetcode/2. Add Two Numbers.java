class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num =l1.val+l2.val;
		int nextNum = num>=10?1:0;
		ListNode head = new ListNode(num%10);
		ListNode rear = head;
		ListNode p;
		l1 = l1.next;
		l2 = l2.next;
		while(l1!=null &&l2!=null){
			num =l1.val+l2.val + nextNum;
			nextNum = num>=10?1:0;
			rear.next = new ListNode(num%10);
			rear = rear.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		if(l1==null){
			rear.next = l2;
		}else rear.next = l1;
		while (nextNum!=0){
			if(rear.next!=null){
				num = rear.next.val+  nextNum;
				nextNum = num>=10?1:0;
				rear.next.val = num%10;
			} else {
				num = nextNum;
				rear.next = new ListNode(num%10);
				break;
			}
			rear = rear.next;
		}
		return head;
	}
}
