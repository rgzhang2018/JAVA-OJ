

//关键点
//1.每次大循环，找到当前子树最左边的节点，并保存路径，然后对最左边那个节点输出
//2.if的内容是找该节点的右子树
//以此规律循环

class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
        
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
        if(root==null)return list;
		TreeNode p = root.left;
        stack.push(root);
		while (!stack.empty() || p!=null){
            while(p!=null){
            stack.push(p);
            p=p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
		}
		return list;
	}
}