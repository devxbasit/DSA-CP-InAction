// Java code to find Longest Consecutive Subsequence
import java.util.Scanner;
import java.util.*;
import java.util.HashSet;

class FindLongestSubsequence
{
    // Driver Code
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    
		    // Making object of GfG	
			GfG g = new GfG();
			
			System.out.println(g.findLongestConseqSubseq(a, n));
		
		t--;
		}
	}
}// } Driver Code Ends


class GfG
{
    // Function to find Longest Consecutive Subsequence
    int findLongestConseqSubseq(int arr[], int n)
    {
        
	    // Your code here	
	    
	    HashSet<Integer> hs = new HashSet<>();
	    
	    for (int i = 0; i < n; i++)
	        hs.add(arr[i]);
	        
	        
	   int max = -1;
	   int j;
	   
	   for (int i = 0; i < n; i++){
	       
	       if (!hs.contains(arr[i] - 1)){
	           
	           j = arr[i] + 1;
	           
	           while (hs.contains(j))
	            j++;
	           
	           max = Math.max(max, j - arr[i]);
	       }
	   }
	   
	   return max;
    }
}