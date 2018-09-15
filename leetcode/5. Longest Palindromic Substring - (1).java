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

