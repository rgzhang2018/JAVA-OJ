// 此题目显然是要采用二分法：

// 第一次尝试：
	public int firstBadVersion(int n) {
		if(n==1)return n;
		int i = n/2 ;
		int start = 1 ,end = n;
		while (start<end){
			if(!isBadVersion(i)){
				start = i+1;
				i = (start+end)/2;

			}else{
				end = i-1;
				i=(start+end)/2;
			}
		}
		return i;
	}
//   	提示出错，得到的溢出结果i=1702766719
//		分析这个出错提示：想要i=1702766719，那么一定要经历一次i=(2126753390+i)/2，那么在这个过程中，括号内的数字一定存在了溢出，
//		所以导致程序在未知的范围异动，最后导致超时。
//		出错原因应该是i = (start+end)/2;这步的start+end溢出，于是进行如下改进：
	public int firstBadVersion(int n) {
		if(n==1)return n;
		int i = n/2 ;
		int start = 1 ,end = n;
		while (start<end){
            // i=(start+end)/2;
            i=start/2+end/2;
			if(!isBadVersion(i)){
				start = i+1;
			}else{
				end = i;
			}
		}
		return start;
	}
//		 改进：将start、end分别除2之后再相加