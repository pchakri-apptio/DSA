package com.praveen.programming;

import java.util.ArrayList;
import java.util.List;

/*
* Pairs count based on condition a[i] > 2*a[j] and i<j
*/
public class ReversePairs {
  private int countParis(int[] a){
    int count =0;
    for(int i=0;i<a.length;i++){
      for(int j=i;j<a.length;j++){
        if(a[i]>2*a[j])
          count++;
      }
    }
    return count;
  }

  private int mergeSortTech(int a[],int low,int high){
    if(low>=high) return 0;
    int mid = (low+high)/2;
    int count = mergeSortTech(a,low,mid);
    count+= mergeSortTech(a,mid+1,high);
    count+= merge(a,low,mid,high);
    return count;
  }

  private int merge(int[] a, int low, int mid, int high) {
    int count = 0;
    int j=mid+1;
    for(int i=low;i<=mid;i++){
      while(j<=high && a[i]> (2*((long)a[j]))){
        j++;
      }
      count += j - (mid+1) ;
    }

    List<Integer> sortedList = new ArrayList<>();
    int left = low;
    int right = mid+1;
    while(left<=mid && right<=high){
      if(a[left]<=a[right])
        sortedList.add(a[left++]);
      else
        sortedList.add(a[right++]);
    }
    while(left<=mid)
      sortedList.add(a[left++]);
    while(right<=high)
      sortedList.add(a[right++]);

    for(int i=low;i<=high;i++)
      a[i] = sortedList.get(i-low);

    return count;
  }

  public static void main(String[] args) {
    ReversePairs reversePairs = new ReversePairs();
    int a[] = {40,25,19,12,9,6,2};
    System.out.println(reversePairs.countParis(a));
    System.out.println("=====Optimal======");
    System.out.println(reversePairs.mergeSortTech(a,0,a.length-1));
  }
}
