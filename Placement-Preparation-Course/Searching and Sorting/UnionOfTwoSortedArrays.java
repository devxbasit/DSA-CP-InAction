//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

public class UnionOfTwoSortedArrays {
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Union obj = new Union();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}


// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Union
{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> al = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while(i < n && j < m){
            int k = al.size() - 1;
        
            if (arr1[i] < arr2[j]){
                if (k == -1  || arr1[i] != al.get(k))
                    al.add(arr1[i]);
                
                i++;
            }else if (arr2[j] < arr1[i]){
                    if (k == -1 || arr2[j] != al.get(k))
                        al.add(arr2[j]);
        
                    j++;
            }else{
                if (k == -1 || arr1[i] != al.get(k) )
                    al.add(arr1[i]);
                
                i++;
                j++;
            }
        }
        
        while(i < n){
            int k = al.size() - 1;
            
            if (k == -1 || arr1[i] != al.get(k))
                al.add(arr1[i]);
   
            i++;
        }

        while(j < m){
            int k = al.size() - 1;
            
            if (k == -1 || arr2[j] != al.get(k))
                al.add(arr2[j]);
   
            j++;
        }
        
        return al;
    }
}


