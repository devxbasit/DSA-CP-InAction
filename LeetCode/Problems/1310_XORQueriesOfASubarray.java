class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {

        // using prefix sum and range query update
        
        int n = arr.length;
        for (int i = 1; i < n; i++)
            arr[i] ^= arr[i - 1];
        
        int q = queries.length;
        
        int X[] = new int[q];
        int l, r;
        
        for (int i = 0; i < q; i++){
            
            l = queries[i][0];
            r = queries[i][1];
            
            
            if (l == 0)
                X[i] = arr[r];
            else
                X[i] = arr[r] ^ arr[l - 1];    
        }
        
        return X;
    }
}