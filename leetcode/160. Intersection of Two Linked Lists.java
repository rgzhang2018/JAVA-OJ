//方法一：补到二者一样长，再同步加减即可。

public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA== null||headB == null) return null;
		ListNode p = headA;
		ListNode q= headB;
		int numP=0,numQ=0;
		while (p!=null){
			numP++;
			p = p.next;
		}
		while (q!=null){
			numQ++;
			q = q.next;
		}
		if(numP<numQ)return findNode(headA,headB,numQ-numP);
		return findNode(headB,headA,numP-numQ);
	}

	private ListNode findNode(ListNode headA,ListNode headB,int num){
		while (num!=0){
			headB = headB.next;
			num--;
		}
		while (headA!=headB && headA!=null){
			headA=headA.next;
			headB=headB.next;
		}
		return headA;
	}
}


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
