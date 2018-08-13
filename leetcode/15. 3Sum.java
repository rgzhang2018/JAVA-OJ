


//最早的方法。当相同的数字在该数组里出现超过3次之后，就可能会丢跟
class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new LinkedList<>();
		if(nums.length<3) return lists;
		else if(nums.length==3){
			if(nums[0]+nums[1]+nums[2]==0){
				List<Integer> x = new ArrayList<>();
				x.add(nums[0]);
				x.add(nums[1]);
				x.add(nums[2]);
				lists.add(x);
			}
			return lists;
		}
		int i;
		int length = nums.length;
		boolean []visited = new boolean[length];
		Arrays.sort(nums);
		for(i = 0;i<length-1;i++){

			int n = 0- nums[i];
			int p = 0,q=nums.length-1;
			//找为0的：
			while(p<q){
				if(p==i)p++;
				if(q==i)q--;
				if(nums[p]+nums[q]==n &&(!visited[p] ||!visited[q]))break;
				else if(nums[p]+nums[q]>n)q--;
				else if(nums[p]+nums[q]<n)p++;
				else{
					p++;
					q--;
				}
			}
			//加入对应的三元组
			if(p<length && q>=0 && nums[p]+nums[q]+nums[i]==0&&p!=q&& (!visited[p] ||!visited[q])){
				List<Integer> x = new ArrayList<>();
				x.add(nums[i]);
				x.add(nums[p]);
				x.add(nums[q]);
				visited[i]=true;
				visited[p]=true;
				visited[q]=true;
				boolean []visitX = new boolean[3];
				boolean isEqual = false;
				for (List<Integer> list : lists) {
					for (int j = 0; j < 3; j++) {
						for (int m = 0; m < 3; m++) {
							if (list.get(j).equals(x.get(m))&&!visitX[m]){
								visitX[m] = true;
								break;
							}
						}
					}
					for(int j = 0 ;j<3;j++){
						if(!visitX[j])break;
						if(j==2)isEqual = true;
					}
				}
				if(!isEqual)lists.add(x);
				i--;
			}
		}
		return lists;
	}
}

//改进后
//注意对重复的检测部分

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3 || nums == null) { return result; }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) { break; }
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            int j = i + 1, k = nums.length - 1;
            int sum = 0 - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    while (j < k && nums[j] == nums[j + 1]) { j++; }//重复的元素直接在这一步进行跳过，比设置flag，然后在最后再检测三元组要方便的多
                    while (j < k && nums[k] == nums[k - 1]) { k--; }
                    j++;
                    k--;
                } else if (nums[j] + nums[k] < sum) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}






