//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- >0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n=Integer.parseInt(str[0]);
            int arr[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
                
            ArrayList<Integer> v = new Hashing().printNonRepeated(arr, n);
            
            for(int i=0;i<v.size();i++){
                System.out.print(v.get(i)+" ");
            }
            
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Hashing
{
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        // add your code here
        
        HashMap<Integer, Integer> hm = new HashMap();
        ArrayList<Integer> al = new ArrayList<>();
        
        int freq;
        
        for (int i = 0; i < n; i++){
        
            freq = 1;
            
            if(hm.containsKey(arr[i]))
                freq = hm.get(arr[i]) + 1;
                
            hm.put(arr[i], freq);
        }
        
        
        for (int i = 0; i < n; i++)
            if (hm.get(arr[i]) == 1)
                al.add(arr[i]);
        
        return al;
    }
}

