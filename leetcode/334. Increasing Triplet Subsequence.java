//方法一（最早的想法）：
//定一动二
class Solution {
	public boolean increasingTriplet(int[] nums) {
		int min,mid,max;
		int length = nums.length;
		for(int i= 1;i<length-1;i++){
			mid = i;
			min = i-1;
			max = i+1;
			while (min != -1 && max != length){
				if(nums[min]<nums[mid] && nums[mid]<nums[max])return true;
				if(nums[min]>=nums[mid] )min--;
				if(nums[max]<=nums[mid] )max++;
			}
		}
		return false;
	}
}

//该方法存在了许多浪费：如在每次外层循环，均要重新对内层循环的所有数值进行挨个判定赋值，就十分浪费时间
//因此有了下面的改进方案：
class Solution {
	public boolean increasingTriplet(int[] nums) {
		int min=0,mid=1,max=2;
		int length = nums.length;
		while(mid<length-1){
			if(max<=mid)max = mid+1;
			while (max<length-1 && nums[max]<=nums[mid] )max++;//每趟mid往后走，只可能影响max的值（如当前的max所在的位置在mid之前），因此只需要在必要的时候判定max即可
			if(nums[min]<nums[mid] && nums[mid]<nums[max])return true;
			if(nums[min]>=nums[mid])min = mid;				//min的判定随着大循环一块走，不需要单独进行
			mid++;
		}
		return false;
	}
}
//通过减少多余的判定，明显减少了循环次数，提高了效率
//注：改进前用时100+ms，改进后为5ms