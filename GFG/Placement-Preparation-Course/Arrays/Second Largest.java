// https://practice.geeksforgeeks.org/problems/second-largest3735/1
class Solution {
    int print2largest(int arr[], int n) {
        // code here
        
        // other approaches
        // 1. sort array first, then find max2
        // 2. traverse array two time, find max1 in first iteration, max2 in second
        
        // third approach below
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            
            if (arr[i] > max1) {
                
                max2 = max1;
                max1 = arr[i];
                
            } else if (arr[i] > max2 && arr[i] != max1) {
                
                max2 = arr[i];
                
            }
            
        }
        
        return max2 == Integer.MIN_VALUE ? -1 : max2;
        
    }
}