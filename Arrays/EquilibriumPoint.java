// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class Equilibrium {
    
        public static void main(String[] args) throws IOException {
            BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
            int t =
                Integer.parseInt(br.readLine().trim()); // Inputting the testcases
            while (t-- > 0) {
                
                //taking input n
                int n = Integer.parseInt(br.readLine().trim());
                long arr[] = new long[n];
                String inputLine[] = br.readLine().trim().split(" ");
                
                //adding elements to the array
                for (int i = 0; i < n; i++) {
                    arr[i] = Long.parseLong(inputLine[i]);
                }
    
                EquilibriumPoint obj = new EquilibriumPoint();
                
                //calling equilibriumPoint() function
                System.out.println(obj.equilibriumPoint(arr, n));
            }
        }
    }// } Driver Code Ends
    
    
    class EquilibriumPoint {
    
        // Function to find equilibrium point
        // a: input array
        // n: size of array
        public static int equilibriumPoint(long arr[], int n) {
    
            // Your code here
            if (n == 1)
                return 1;
            
            int rightSum = 0;
            int leftSum = 0;
            
            for (int i = 0; i < n; i++)
                rightSum += arr[i];
                
                
            for (int i = 0; i < n - 1; i++){
                rightSum -= arr[i];
                
                if (rightSum == leftSum)
                    return i + 1;
                    
                leftSum += arr[i];
            }
            
            return -1;
        }
    }