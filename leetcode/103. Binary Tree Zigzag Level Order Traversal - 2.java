
//还有一种非常简洁的思路
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        if(root != null) q.add(root);
        while(!q.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            List<Integer> l = new ArrayList<Integer>();
            while(!q.isEmpty()) {		//此循环每次为一层
                TreeNode cur = q.removeLast();//从最后一个元素开始取节点
                l.add(cur.val);			
                if(!flag) {				//如果是从左往右取的，再从左往右放子节点，下次从尾部取得就是从右往左的
                    if(cur.left != null) tmp.add(cur.left);
                    if(cur.right != null) tmp.add(cur.right);
                }else {					//同上
                    if(cur.right != null) tmp.add(cur.right);
                    if(cur.left != null) tmp.add(cur.left);
                }
                
            }
            flag = !flag;
            res.add(l);
            q = tmp;
        }
        return res;
    }
}