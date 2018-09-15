


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




