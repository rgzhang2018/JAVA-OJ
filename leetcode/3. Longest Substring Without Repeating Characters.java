
class Solution {
	public int lengthOfLongestSubstring(String s) {
		int p = 0;
		boolean[]visited = new boolean[0xff];
		int count = 0;
		int max = 0;
		while(p<s.length()-1){
			for(int i=p;i<s.length();i++) {
				int num = s.charAt(i);
				if (visited[num]) {
					if (max < count) max = count;
					count = 0;
					Arrays.fill(visited, false);//从下一个元素开始重新判定
					p++;
					break;
				}
				visited[num] = true;
				count++;
				if(i==s.length()-1){//i循环成功走到最后一个元素了，则外层p循环也结束
					p = s.length();
				}
			}
		}
		return max>count?max:count;
	}
}