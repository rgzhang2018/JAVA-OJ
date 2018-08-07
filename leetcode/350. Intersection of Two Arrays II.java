public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length>nums2.length) return intersect(nums2,nums1);
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    
    int[] arr = new int[nums1.length];
    int i=0,j=0,c=0;
    while(i<nums1.length && j<nums2.length){
        if (nums1[i]>nums2[j]){
            j++;
        }else if(nums1[i] == nums2[j]){
            arr[c++] = nums1[i];
            i++;j++;
        } else{
            i++;
        }
    }
    return Arrays.copyOf(arr,c);
}