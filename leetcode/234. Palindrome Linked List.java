// 采用o(1)的空间复杂度和o(n)的时间：

public boolean isPalindrome(ListNode head) {
	int count=0;
	ListNode p = head;
	while (p!=null){
		count++;
		p=p.next;
	}
	boolean flag = count%2==1;//判断链表长度的奇偶，长度为奇数则是true
	count = count/2;
	ListNode head2 = new ListNode(1);//采用头插法，创建另外半个链表
	ListNode q ;
	p = head;
	while (count!=0){
		count--;
		q= p;
		p = p.next;
		q.next = head2.next;
		head2.next = q;

	}
	if(flag) p = p.next;
    q = head2.next;
	while (p!=null&&q!=null){
		if(p.val!=q.val)return false;
		p=p.next;
		q=q.next;
	}
	return true;
}