//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] A=new int[N];
            for(int i=0;i<N;i++)
            A[i]=sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.maximum_sum(N,A,K));
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution{
    
    long maximum_sum(int N,int[]A,int K){
        
        //code here
    
        Map<Integer, Integer> hm = new HashMap<>();
        int key, freq;
        
        for (int i = 0; i < N; i++){
            
            key = A[i];
            freq = 1;
            
            if (hm.containsKey(key)){
                
                hm.put(key, hm.get(key) + 1);
                
            }else{
                
                hm.put(key, freq);
            }
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pque = new PriorityQueue<>(
            
            new Comparator<Map.Entry<Integer, Integer>>(){
                
                public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                    
                    
                    // if frequence is same
                
                    if (e1.getValue() == e2.getValue())
                        return e2.getKey() - e1.getKey(); 
                        
                    
                    return e2.getValue() - e1.getValue();     
                }
            });
            
            
            for (Map.Entry<Integer, Integer> entry : hm.entrySet())
                pque.add(entry);
                
                
            long sum = 0;
            
            for (int i = 0; i < K; i++){
                
                Map.Entry entry = pque.remove();
                
                key = (int) entry.getKey();
                freq = (int) entry.getValue();
                
                sum += key;
                
                if(freq != 1){
                    entry.setValue(freq - 1);
                    pque.add(entry);
                }
            }
            
            return sum;
    }
}