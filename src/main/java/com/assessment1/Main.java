package com.assessment1;

public class Main {

  public static void main(String[] args) {
    int[] myArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    
    System.out.println(iterateOver(myArray));
  }
  
  public static int iterateOver(int[] arr) {
    int total = 0;
    for (int i : arr) {
      total += i;
    }
    return total;
  }

}
