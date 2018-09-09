class Solution {
	public ListNode oddEvenList(ListNode head) {
		boolean isOdd = true;
		ListNode odd = new ListNode(-1);
		ListNode even = new ListNode(-1);
		ListNode oddRear  = odd;
		ListNode evenRear = even;
		while (head!=null){
			if(isOdd){
				oddRear.next = head;
				oddRear = head;
				isOdd = false;
			}else {
				evenRear.next = head;
				evenRear = head;
				isOdd = true;
			}
			head = head.next;
		}
		oddRear.next = even.next;
        evenRear.next = null;//注：没有这句话在OJ上运行会超时，原因是链表的尾节点的next指向之前的某个节点，使得形成环状。
		return odd.next;
	}
}
