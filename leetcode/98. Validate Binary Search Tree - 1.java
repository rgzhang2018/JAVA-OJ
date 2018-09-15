// 思路一（首先想到的方法）：
// 以中序遍历构建数组，该数组若是从小到大的顺序，则证明是二叉排序树
// 因为二叉排序树的中序遍历恰为顺序数列。（也可以用这种方法构造二叉排序树）（写在USTC-Summer-test）
class Solution {
	public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
		ArrayList<Integer> a = new ArrayList<Integer>();
		makeArray(root,a);
		for(int i=0;i<a.size()-1;i++){
			if(a.get(i)>=a.get(i+1))return false;
		}
		return true;
	}
	public void makeArray(TreeNode root,ArrayList a) {
		if(root.left!=null)makeArray(root.left,a);
		a.add(root.val);
		if(root.right!=null)makeArray(root.right,a);
	}
}



