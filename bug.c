#include <stdio.h>

void fun(int a,int b){
	int *ret;
	ret = &a -1;
	(*ret)+=8;
}
int main(){
	int x;
	x = 3;
	fun(1,2);
	x = 1;
	printf("x is %d\n",x );
	return 0;
}