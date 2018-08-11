//方法一：按位与，获得该位的信息（复杂度在于getBit函数）
class Solution {
	public int hammingDistance(int x, int y) {
		int count = 0;
		for(int i = 0;i<31;i++){
			int num = getBit(i);
			if((x&num) == (y&num))count++;
		}
		if(((x<0)&&(y<0)) || ((x>=0)&&(y>=0)))return count;
		return count+1;
	}
	private int getBit(int x){
		if(x==0)return 1;
		return 2*getBit(x-1);
	}
}

//方法二：利用JAVA库函数
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;

		String s1 = Integer.toBinaryString(x);
		String s2 = Integer.toBinaryString(y);
		int len1 = s1.length();
		int len2 = s2.length();

		while (len1 > len2) {//先把前面补0
			s2 = "0" + s2;
			len2++;
		}
		while (len1 < len2) {
			s1 = "0" + s1;
			len1++;
		}
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		for (int i = 0; i < len1; i++) {
			if (a[i] != b[i]) {
				res++;
			}
		}
        return res;
    }
}