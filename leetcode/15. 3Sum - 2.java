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



