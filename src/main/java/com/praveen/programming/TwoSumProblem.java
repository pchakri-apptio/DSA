package com.praveen.programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumProblem {

  private void checkSumTarget(int[] a,int target,List<Integer> ans){
    for(int i=0;i<a.length;i++){
      for(int j=i;j<a.length;j++){
        if(a[i]+a[j] == target) {
          ans.add(i);
          ans.add(j);
          return;
        }
      }
    }
  }

  private void checkSumHashingTech(int[] a, int target,List<Integer> ans){
    Map<Integer,Integer> targetMap = new HashMap<>();
    for(int i=0;i<a.length;i++){
      if(targetMap.containsKey(target-a[i])){
        ans.add(i);
        ans.add(targetMap.get(target-a[i]));
        return;
      }
      targetMap.put(a[i],i);
    }
  }


  public static void main(String[] args) {
    TwoSumProblem twoSumProblem = new TwoSumProblem();
    int a[] = {9,2,3,4};
    List<Integer> ans = new ArrayList<>();
//    twoSumProblem.checkSumTarget(a,6,ans);
    twoSumProblem.checkSumHashingTech(a,6,ans);
    System.out.println(ans.toString());
  }
}
