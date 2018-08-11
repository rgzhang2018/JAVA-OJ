
//求质数的方法
//法一：定义法
//浪费时间，节约空间
class Solution {
    public int countPrimes(int n) {
        if(n<=2)return 0;
        int count = 1;
        for(int i=3;i<n;i+=2){
            if(primeNum(i))count++;
        }
        return count;
    }
    private boolean primeNum(int n){
        if(n ==2 || n==3||n==5||n==7)return true;
        if(n<=10)return false;
        boolean flag = true;
        for(int i = 3 ; i<=Math.sqrt(n);i+=2){//比较到平方根的位置就够了
            if(n%i==0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}

//法二：
//利用定理：一个合数的最小质数一定小于他的平方根
//如：15 = 3 X 5 ，3一定小于sqrt(15)。



// 法二：埃氏筛选法
// 得到素数2：将所有2的倍数的标志置0；
// 得到素数3：将所有3的倍数的标志置0
// 。。。

class Solution {
    public int countPrimes(int n) {
        int num = n-1;
        int count = 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        if(num<2){
            return 0;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(!prime[i]){
                continue;
            }
            else{
                for(int num2 = i*i; num2<n; num2 += 2*i){//为何从i*i开始：如3：6已经在i=2的时候被置换过了，如5:10,15,20均在前被置换过了
                    prime[num2] = false;
                }
            }
        }
        for(int i=2; i<n; i++){
            if(prime[i]){
                count++;
            }
        }
        return count;
    }
}

