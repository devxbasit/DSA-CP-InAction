//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}

// } Driver Code Ends


//User function Template for Java

/*Complete the function below*/
class Solution{
    
    static class Element implements Comparable<Element>{
        
        int data;
    
        int i;
        int j;
        
        Element(int data, int i, int j){
            
            this.data = data;
            this.i = i;
            this.j = j;
        }
        
        public int compareTo(Element e){
            
            return data - e.data;
    
        }
    }
    public static Element getNext(int[][] arr,int k, Element prev) {
        
        if (prev.j >= k - 1)
            return null;
            
        return new Element(arr[prev.i][prev.j + 1], prev.i, prev.j + 1);
        
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) {
        
        // Write your code here.
        
        Queue<Element> minHeap = new PriorityQueue<>();
        
        
        for (int i = 0; i < k; i++)
            minHeap.add(new Element(arr[i][0], i, 0));
        
        
        ArrayList<Integer> al = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            
            Element min = minHeap.poll();
            al.add(min.data);
            
            Element next = getNext(arr, k, min);
            
            
            if (next != null) {
                
                minHeap.add(next);
                
            }
            
        }
        
        return al;
        
    }
}