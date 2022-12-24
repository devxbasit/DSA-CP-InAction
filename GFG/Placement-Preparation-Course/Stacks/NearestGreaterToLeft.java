// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new solve().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class solve{
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        
        long nextGreater[] = new long[n];
        
        Stack<Long> stack = new Stack<>();
    
        nextGreater[0] = -1;
        stack.push(arr[0]);
        
        
        for (int i = 1; i < n; i++){
                
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
                
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
    
            stack.push(arr[i]);
        }
        
        return nextGreater;
    } 
}