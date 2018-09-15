//方法一，利用层次遍历，在每层之间加null来改变遍历方向
class Solution {
	//难点：每次的转折位置。这里采用把null也加入list中，当做本层结束标志
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		int index = 0;
		int rear = 0;			//同时通过该变量表示当前层是否完成（rear/2>index），用于确定当前层是否遍历完了
		boolean leftFlag = false;	//当前层从左往右为false，否则为true
		List<TreeNode> list = new ArrayList<>();    //存放层次遍历
		List<List<Integer>> intLists = new ArrayList<>();
		list.add(root);
		list.add(null);
		TreeNode tempNode;
		while (!(list.get(rear)==null && list.get(rear+1)==null)){//结束判断：尾部连着两个空节点（表示下一层为空了）
			if(leftFlag){//
				//从右往左的遍历，在遍历前，需要先从左往右的把节点先放入List中，再遍历
                //此时index刚好指向下一层的开始(见else部分的while循环出口)
                while((tempNode = list.get(index++))!=null){
                    if(tempNode.left!=null)list.add(tempNode.left);
					if(tempNode.right!=null)list.add(tempNode.right);
                }
                index = rear + 2;//重置index，供else部分使用
				ArrayList<Integer> tempList = new ArrayList<>();
				while ((tempNode = list.get(rear--))!=null){
					tempList.add(tempNode.val);
				}//访问到null为止，表示本层已经完成
				list.add(null);//加上子层结束标志
				intLists.add(tempList);
				leftFlag = false;
                rear = list.size()-2;			//-1表示尾节点，-2去掉末尾的null
			}else{
				//从左往右的遍历
				ArrayList<Integer> tempList = new ArrayList<>();
				while ((tempNode = list.get(index++))!=null){
					tempList.add(tempNode.val);
					if(tempNode.left!=null)list.add(tempNode.left);
					if(tempNode.right!=null)list.add(tempNode.right);
				}//访问到null为止，表示本层已经完成
				list.add(null);
				intLists.add(tempList);
				leftFlag = true;
                rear = list.size()-2;			//-1表示尾节点，-2去掉末尾的null
			}
		}
		return intLists;
	}
}

