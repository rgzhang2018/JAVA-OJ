// 这道题关键点在于如何利用O(1)的空间复杂度完成问题
// 关键思路：
// 不要把这个题想为置0，而是在当前矩阵遍历的时候直接在矩阵上做标记

class Solution {
    public void setZeroes(int[][] matrix) {
        int i;
        int lengthX= matrix.length;
        int lengthY= matrix[0].length;
        boolean [][]isZero = new boolean[lengthX][lengthY];
        for(i=0;i<lengthX;i++){
		    for (int j=0; j<lengthY; j++){
                if(matrix[i][j]==0){
                    for(int k=0 ;k<lengthY;k++){
                        if(matrix[i][k]!=0)matrix[i][k]=Integer.MIN_VALUE+66;
                    }
                    for(int k=0 ;k<lengthX;k++){
                        if(matrix[k][j]!=0)matrix[k][j]=Integer.MIN_VALUE+66;
                    }
                }
            }
		}
        for(i=0;i<lengthX;i++){
		    for (int j=0; j<lengthY; j++){
                if(matrix[i][j]==Integer.MIN_VALUE+66)matrix[i][j]=0;
            }
		}
    }
}