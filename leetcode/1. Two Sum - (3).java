
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