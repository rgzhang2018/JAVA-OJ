// You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
// Note: Given n will be a positive integer.
// Example 1:

// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps

// ###1.公式
// >要理解，fn=fn-1+fn-2，表示的思路是忽略下面所有的走法，只看最后一步，那么可以是从n-1阶走上去的，也可以是从n-2阶一次跨两个台阶走上去的

// ###2.代码
// **动态规划的问题难点在如何更好的规划**
// 如果直接用递归的算法的话，会出现大量的重复计算:第n-1阶可以是n-2阶+n-3阶，而第n-2阶就出现了重复计算
// 因此采用一个数组存储的方式，用迭代的方法一次性计算该有限斐波那契数列

public int climbStairs(int n) {
        if(n==0||n==1||n==2)return n;
        int[] num = new int[n+1];
        num[1]=1;
        num[2]=2;
        for(int i=3;i<=n;i++){
            num[i]=num[i-1]+num[i-2];
        }
        return num[n] 
}