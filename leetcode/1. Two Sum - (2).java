// 方法二：
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(target-nums[i])){
                res[1] = i;
                res[0] = hashmap.get(target-nums[i]);
                break;
            }   
            hashmap.put(nums[i],i);
        }
        return res;
    }
}
// 利用
// HashMap自带的搜索containskey提升效率，先加入Map，再回头对比，找出则放入数组。