
// 法二：符合标准的解法：不利用空间复杂度
class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2) {
            return;
        }
        k %= nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int startIndex, int endIndex) {
        int temp;
        while(startIndex < endIndex) {
            temp = nums[endIndex];
            nums[endIndex] = nums[startIndex];
            nums[startIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
​
// 解析：
// reverse函数对带入进去的数组的内容首尾对换，将头部变为尾部，尾部变为头部，以此类推；
// 该方法整体思路类似于方法二，但是实现上更加巧妙：