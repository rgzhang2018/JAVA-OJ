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


