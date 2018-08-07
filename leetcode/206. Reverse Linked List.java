class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
		ListNode p = reverseList(head.next);
		if(head.next!=null)head.next.next = head;
        head.next = null;
		return p;
    }
}

//刚好利用到递归栈，使得遍历后找到末尾的p节点，随后开始利用head倒着链接