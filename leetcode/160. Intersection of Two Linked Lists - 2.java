

//方法二：两倍的链表相加
//A + B =  a + list + b + \list   	
//B + A =  b + list + a + \list
//a和b表示二者的不同的部分
//注意\这个标记，这时无论A,B谁在前，在二者相等的时返回的一定是交点\位置

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA== null||headB == null) return null;
		ListNode p = headA;
		ListNode q= headB;
		while (q != p)
		{
			if (q==null)
				q = headA;
			else
				q = q.next;
			if (p==null)
				p = headB;
			else
				p = p.next;
		}
		return q;
	}
}
