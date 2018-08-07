// 法一：调用系统函数，将数组分类两大块，利用一个temp[]交换。代码精简，但是不符合题目的“O(1)extra space”
class Solution {
    public void rotate(int[] nums, int k) {
            k = k%nums.length;
            int[] a = new int [k];
            System.arraycopy(nums,nums.length-k,a,0,k);
            System.arraycopy(nums,0,nums,k,nums.length-k);
            System.arraycopy(a,0,nums,0,k);
        
    }
}
// 利用了System.arraycopy函数，好处是减少了时间复杂度，
// 但是却增加了空间复杂度，不符合题中的“Could you do it in-place with O(1) extra space?”
// 将原数组分为两段：第一段是0到length-k-1共length-k个元素，第二段是length-k到k共k个元素，然后对换两段


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