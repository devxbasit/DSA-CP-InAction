//  Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class IsomorphicStrings {
    
    public static void main(String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Isomorphic obj = new Isomorphic();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}
// } Driver Code Ends


class Isomorphic{
    // This function returns true if str1 and str2 are ismorphic
    // else returns false
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        int n = str1.length();
        int m = str2.length();
        
        if (n != m)
            return false;
            
        int map[] = new int[256];
        boolean marked[] = new boolean[256];

        int c1;
        int c2;
        
        for(int i = 0; i < n; i++){
            c1 = str1.charAt(i);
            c2 = str2.charAt(i);
            
            if (map[c1] == 0){
                
                if(marked[c2])
                    return false;
                    
                map[c1] = c2;
                marked[c2] = true;
            }else if (map[c1] != c2)
                return false;
        }
        
        return true;
    }
}