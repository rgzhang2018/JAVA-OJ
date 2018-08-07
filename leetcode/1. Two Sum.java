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


// 还有一种思想：
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        if (nums == null || nums.length < 2) {
            return answer;
        }
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] difference = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (difference[other - min] > 0) {
                answer[0] = difference[other - min] - 1;
                answer[1] = i;
                return answer;
            }
            difference[nums[i] - min] = i + 1;
        }
        return answer;
    }
// 这个方法的精华在其difference数组，可以这么理解：
// 这个difference数组的数组元素的编号=数组nums的元素的值；difference数组的值=nums数组的编号
// 相当于给数组nums加上了一个反向索引，利用空间复杂度换取时间，
// 使得第22行的判断直接进行，对比方法二的HashMap.containskey来说简单粗暴的提高了效率。
// 同时其内的第19行判断可以很好地减少循环次数。