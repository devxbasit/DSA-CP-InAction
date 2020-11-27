// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class Array {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    
	    int t=sc.nextInt(); //input testcases
	    
	    while(t-->0) //Loop until we exhaust all testcases
	    {
	        int n=sc.nextInt(); //Input size of array n
	        int arr[]=new int[n]; //Declaring the array
	        for(int i=0;i<n;i++)
	        {
	            int x=sc.nextInt();
	            arr[i]=x; //Assigning elements to array
	        }
	        
	        int x=sc.nextInt();//Input x
	        int y=sc.nextInt();//Input y
	        
	        Majority obj=new Majority(); //object to call the function
	        System.out.println(obj.majorityWins(arr,n,x,y)); //The functions you complete
	        
	    }
	}
}

// } Driver Code Ends


//User function Template for Java


class Majority
{
    public int majorityWins(int arr[],int n,int x,int y)
    {
        // code here 
        int xCount = 0;
        int yCount = 0;
        
        for (int i = 0; i < n; i++){
            if (arr[i] == x)
                xCount++;
            else if (arr[i] == y)
                    yCount++;
        }
        
        if (xCount == yCount)
            return Math.min(x, y);
            
        return (xCount > yCount) ? x : y;
    }
}

