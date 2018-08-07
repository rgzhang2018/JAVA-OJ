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



// 思路二：
// 时间最短的解法：
// 对于每个节点，分别判断它是否是其左子树的最大值、右子树的最小值
// 使之对于每个节点的判断，包含了他的整个子树，而不仅是当前节点的左右孩子节点。
// 这种方法的min和max是随着每次遍历而逐步压缩、夹逼，在底层达到最小的区间

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}