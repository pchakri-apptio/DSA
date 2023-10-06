package com.praveen.programming;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {

  private Deque<Integer> doublePointer;
  private HashSet<Integer> reference;
  private Integer CACHE_SIZE;

  LRUCache(int size){
    doublePointer = new LinkedList<>();
    reference = new HashSet<>();
    CACHE_SIZE = size;
  }

  private void refer(int value){
    if(!doublePointer.contains(value)){
      if(doublePointer.size() == CACHE_SIZE){
        int refLast = doublePointer.removeLast();
        reference.remove(refLast);
      }
    }
    else{
      doublePointer.remove(value);
    }
    doublePointer.push(value);
    reference.add(value);
  }

  private void display(){
    doublePointer.forEach(System.out::println);
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(4);
    lruCache.refer(1);
    lruCache.refer(2);
    lruCache.refer(3);
    lruCache.refer(1);
    lruCache.refer(4);
    lruCache.refer(5);
    lruCache.display();
  }
}
