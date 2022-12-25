// { Driver Code Starts
    import java.util.*;


    class ImplementStrstr_RabinKarp_Horner
    {
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            sc.nextLine();
            while(t>0)
            {
                String line = sc.nextLine();
                String a = line.split(" ")[0];
                String b = line.split(" ")[1];
                
                GfG g = new GfG();
                System.out.println(g.strstr(a,b));
                
                t--;
            }
        }
    }// } Driver Code Ends
    
    
    /*
    the function returns the 
    position where the target string 
    matches the string str
    
    Your are required to complete this method */
    
    class GfG
    {
        int strstr(String text, String pattern)
        {
           // Your code here
           int d = 256;
           int q = 101;
           int n = text.length();
           int m = pattern.length();
           
           if (n < m)
            return -1;
           
           int p = 0;
           int t = 0;
           int j;
           
           // see Horner's & rabin-karp's method first, then jump into code
           
            int hash = 1;
            for (int i = 0; i < m - 1; i++ )
                hash = (hash * d) % q;
            
            
           for (int i = 0; i < m; i++){
               p = (p * d + pattern.charAt(i)) % q;
               t = (t * d + text.charAt(i)) % q;
           }
           
            for (int i = 0; i <= n - m; i++){
                if (p == t){
                    
                    for (j = 0; j < m; j++)
                        if(text.charAt(i + j) != pattern.charAt(j))
                            break;
                    
                    if(j == m)
                        return i;
                }
                    
                if (i < n - m){
                    t = (d * (t - hash * text.charAt(i)) + text.charAt(i + m)) % q;
                        
                    if (t < 0)
                        t = t + q;
                }
            }
            
            return -1;
        }
    }
    