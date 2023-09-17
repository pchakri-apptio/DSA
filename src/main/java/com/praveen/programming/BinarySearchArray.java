package com.praveen.programming;

import java.util.Arrays;

public class BinarySearchArray {

  private int findUniquePath(String[][] inputArr,int row, int col,int countleft, int countRight){
    if(row == inputArr.length-1 && col == inputArr[0].length-1){
      return 1;
    }
    if(row>inputArr.length-1 || col>inputArr[0].length-1)
      return 0;
    countleft= findUniquePath(inputArr,row,col+1,countleft, countRight);
    countRight= findUniquePath(inputArr,row+1,col,countleft, countRight);
    return countleft+countRight;
  }

  //DP solution
  private int findUniquePathsDP(String[][] inputArr,int row, int col,int[][] dp){
    if(row == inputArr.length-1 && col == inputArr[0].length-1){
      return 1;
    }
    if(row>inputArr.length-1 || col>inputArr[0].length-1)
      return 0;
    if(dp[row][col] != -1) return dp[row][col];
    return dp[row][col] = findUniquePathsDP(inputArr,row,col+1,dp)+findUniquePathsDP(inputArr,row+1
        ,col,
        dp);
  }

  //best way
  private int findPaths(int m,int n){
    int N = m+n-2;
    int r = m-1;
    double res = 1;
    for(int i=1;i<=r;i++){
      res*= (double) (N - r + i) /i;
    }
    return (int)res;
  }

  public static void main(String[] args) {
    String[][] strArray = new String[2][3];
    int[][] intArray = new int[2][3];
    Arrays.stream(strArray).forEach(a->Arrays.fill(a,""));
    Arrays.stream(intArray).forEach(a->Arrays.fill(a,-1));
    BinarySearchArray bsa = new BinarySearchArray();
    System.out.println(bsa.findUniquePath(strArray,0,0,0,0));
    System.out.println(bsa.findUniquePathsDP(strArray,0,0,intArray));
    System.out.println(bsa.findPaths(2,3));
  }
}
