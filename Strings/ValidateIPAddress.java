// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class ValidateIPAddress {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        // Write your code here
        String ip[] = s.split("\\.");
        int num;
        
        if (ip.length != 4)
            return false;
            
        boolean zeroAllowed;
        
        for (int i = 0; i < 4; i++){
            
            if (ip[i].isEmpty() || ip[i].length() > 3)
                return false;
                
            zeroAllowed = false;
            
            for (int j = 0; j < ip[i].length(); j++){
                
                if ((ip[i].charAt(j) >= '0' && ip[i].charAt(j) <= '9') == false)
                    return false;
                    
                if(ip[i].length() == 1)
                    break;
                    
                // if lenght is more than one, check for leading 0
                
                if (ip[i].charAt(j) == '0' && zeroAllowed == false)
                    return false;
                    
                zeroAllowed = true;
            }
            
            num = Integer.parseInt(ip[i]); 
            if ((num >= 0 && num <= 255) == false)
                return false;
        }
        
        
        if (s.charAt(s.length() - 1) == '.')
            return false;
            
        return true;
        
    }
}