// 1.出口：
// 空节点则出0；

// 2.递归，进行的操作：
// a.当节点不空的时候，遍历其子节点，并使得当前的节点的深度+1
// b.返回时用Math.max函数对比找出最大值，即是跑的最深的那个点

class Solution {
	public int maxDepth(TreeNode root) {
		if(root==null)return 0;
		return Math.max(maxDepth(root.right)+1,maxDepth(root.left)+1);
	}
}