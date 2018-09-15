

//方法二：不考虑数制，不转换为String，直接利用>>和&直接对位进行一步一个的操作
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
		int i = 0;
		while (i < 32) {
			int temp = n & 0x01;//取末尾
			n = n >> 1;//数右移一位（>>是带符号数移动，高位补符号，>>>是无符号位移动）
 
			result = (result << 1) | temp;
			i++;
		}
		return result;
    }
}