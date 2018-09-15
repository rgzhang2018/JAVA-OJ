
//难点：把JAVA的带符号数当成无符号数操作
public class Solution {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		boolean flag = false;
		if(n%2!=0){//这一步是为了防止转化过后最高位为1，导致报valueOf函数的溢出
			flag = true;
			n--;
		}
		String s = Integer.toBinaryString(n);
		int length = s.length();
		StringBuffer x = new StringBuffer(s);
		x=x.reverse();
		if(length<32){
			char[] temp  = new char[32-length];
			for(int i=0;i<32-length;i++)temp[i]='0';
			x.append(temp);
		}
		s = new String(x);
		Integer x = Integer.valueOf(s,2);
		if(flag)x = x+Integer.MIN_VALUE;//原本n小于0，也就是最高位为1，也就是转换后最低位为1，最高位应该是其他值不变对应的负数的值
		return x;
	}
}
