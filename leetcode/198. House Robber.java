// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

// Example 1:

// Input: [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//              Total amount you can rob = 1 + 3 = 4.
// Example 2:

// Input: [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//              Total amount you can rob = 2 + 9 + 1 = 12.


// ###动态规划：
// 随着任务的进行，其规划的步骤在动态的变化。
// 如本题实例2：如偷窃到2的时候，最佳答案是偷窃7；偷窃到9的时候，最佳答案变成了偷窃2,9.
// 动态规划的常规解法：选择并保留可行的最佳的几个方案，随着进行继续规划

// ###本题思路：
// 对于本题，随着逐步进行，从每个位置来看，每个位置均仅有两个走法：走或者不走，由此得到动态规划的思路：
// max=max(A,B+now)
// **两个走法为下：**
// A:不走这一步得到的值
// B:不走前一步得到的值（可以走这一步），B+now：走了这一步之后的值

int rob(int[] nums) {
    if(nums.size == 0)
        return 0;
    if(nums.size == 1)
        return nums[0];
    int[] dp = new int[nums.size];//储存该动态规划路径的数组
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0],nums[1]);
        
    for(int i = 2;i<nums.size();++i)
    {
        dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
    }
    
    return dp[nums.size()-1];
}