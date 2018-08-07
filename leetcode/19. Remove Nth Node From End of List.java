


//这个思维可能会用到：不知道前驱节点的情况下删除后继节点
public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;		
		//java内存制动管理。
		//由于JAVA的单继承结构，可以自动释放没有被指向的内存，不需要free
}