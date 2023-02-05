import java.util.*;
import java.lang.*;
import java.io.*;

class RotationsOfEachOther {
    
	public static void main (String[] args)throws IOException{
		
		//taking input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//taking total count of testcases
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    //Reading the two Strings
		    String s1 = br.readLine();
		    String s2 = br.readLine();
		    
		    //Creating an object of class Rotate
		    Rotate obj = new Rotate();
		    
		    //calling areRotations method 
		    //of class Rotate and printing
		    //"1" if it returns true
		    //else "0"
		    if(obj.areRotations(s1,s2))
		    {
		        System.out.println("1");
		    }
		    else
		    {
		        System.out.println("0");
		    }
		}
	}
}// } Driver Code Ends


class Rotate{
    
    /*  Function to check if two strings are rotations of each other
    *   s1, s2: are the input strings
    */
    public static boolean areRotations(String s1, String s2 )
    {
        // Your code here
        
        int n = s1.length();
        int m = s2.length();
        
        if (n != m)
            return false;
            
        String temp = s1 + s1;
        
        if (temp.contains(s2))
            return true;
        
        
        return false;
    }
    
}
