// 方法一：
    public int[] twoSum(int[] nums, int target) {
        
        int length = nums.length;
        int[] temp = Arrays.copyOf(nums,length);
        Arrays.sort(temp);
        int flag=0;
        int p=0,q=length-1;
        while(p<=q){
            if(temp[p]+temp[q]==target)break;
            if(temp[p]+temp[q]>target)q--;
            if(temp[p]+temp[q]<target)p++;
        }
        int[] result = new int[2];
        for(int i=0;i<length;i++){
            if(nums[i]==temp[p]||nums[i]==temp[q])result[flag++]=i;
        }
        return result;
    }
//      方法巧在第8-12行，在快排排序后的数组的首尾增加两个指针p,q，判断排序后的数组的p，q位置的值之和是否为结果，
//      小于结果则左边进位，大于结果就右边减位，因此大大减少运行时间。
//      此外，尝试过剔除掉temp[]中大于二者之和target的数据，但是结果不理想，程序失去了对负数的判断能力。





