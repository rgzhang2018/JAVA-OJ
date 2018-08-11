
//难点：用java处理无符号数。 解决方法：如果是大于MAX_SIZE的数（负数），则当成负数，转化为对应的正数，再+符号位的count
public class Solution {
	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int count = 0;
		int temp ;
		if(n<0){
			n = n+Integer.MAX_VALUE+1;
			count++;		
		}
		while (n!=0){
			temp = n%2;
			if(temp==1)count++;
			n/=2;
		}
		return count;
	}
}