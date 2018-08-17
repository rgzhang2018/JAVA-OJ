//方案一
//大量使用字符串操作函数会降低效率，除了优化本身的时间复杂度，还应该尽量少的使用不必要的低效率的字符串函数
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0)return "";
        int p,q;//p指向前面，q指向后面
        int max = 1;
        char[] c = s.toCharArray();
        int length = c.length;
        boolean flag=false;
        int []maxPQ = new int[2];
        for(p = 0;p<length-1;p++){
            for(q=length-1;q>p;q--){
                if(c[p]!=c[q])continue;
                if(ISpalindromic(c,p,q)){
                    if(max<q-p+1){
                        if(q == length-1)flag = true;
                        max = q-p;
                        maxPQ[0]=p;
                        maxPQ[1]=q;
                        break;
                    }
                }
            }
            if(flag)break;
        }
        return s.substring(maxPQ[0],maxPQ[1]+1);
    }
    private boolean ISpalindromic(char[]c,int p,int q){
        boolean flag = true;
        while(p<q){
            if(c[p]!=c[q]){
                flag = false;
                break;
            }
            p++;
            q--;
        }
        return flag;
    }
}



class Solution {
    public String longestPalindrome(String s) {
       if(s.length()<=1) return  s;  
        char[] characters = s.toCharArray();  
        //用于存放str中最长回文子串所对应的下标  
        int[] range = {0,1};  
        for(int i = 0;i<characters.length;i++){  
            i = helper(i,characters,range);  
        }  
        return s.substring(range[0],range[1]);  
    }  
  
    private int helper(int index,char[] c,int[] range) {  
        int low = index;  
        int high = index;  
        //如果遇到相同字符，则high进位，如abba（进入的位置是b的时候，才能检测到这个子串） ，这样偶回文子串也可以当做奇回文处理了  
        while(high<c.length-1 && c[high]==c[high+1]){  
            high++;  
        }  
        int cursor = high;  
        //下面是核心步骤，helper从中间位置往两边找，如果符合回文就一直继续找下去
        while(high+1<c.length&&low-1>=0&&c[low-1]==c[high+1]){  
            low--;  
            high++;  
        }  
        if(high-low+1>range[1]-range[0]){  
            range[0] = low;  
            range[1] = high + 1;  
        }  
        return cursor;  
    }
}


