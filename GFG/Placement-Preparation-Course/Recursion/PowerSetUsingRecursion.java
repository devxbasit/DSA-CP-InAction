//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class PowerSetUsingRecursion
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //testcases        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //input string
            String st = sc.next();
            
            //calling powerSet() function
            ArrayList<String> ans = new LexSort().powerSet(st);
            
            //sorting the result of the powerSet() function
            Collections.sort(ans);
    
            //printing the result
            for(String s: ans)
                System.out.print(s + " ");
            System.out.println();    
        }
    }
}


 // } Driver Code Ends


//User function Template for Java


class LexSort
{
    // complete the function
    public static ArrayList<String> al = new ArrayList<>();
    
    public static void PSet(String s, String curr, int index){
        
        if (index == s.length()){
            al.add(curr);
            return;
        }
            
        PSet(s, curr + String.valueOf(s.charAt(index)), index + 1);
        PSet(s, curr, index + 1);
    }
    
    static ArrayList<String> powerSet(String s)
    {
        // add your code here
        al.clear();
        
        if (s.length() == 1){
            al.add("");
            al.add(s);
            return al;
        }
            
        
        PSet(s, "", 0);
        
        Collections.sort(al);
        return al;
    }
}


 

// { Driver Code Starts.

                                // } Driver Code Ends