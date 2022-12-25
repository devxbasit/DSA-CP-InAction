import java.io.*;

class AnagramStrings {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
            Anagram obj = new Anagram();
		    
		    if(obj.isAnagram(s1,s2))
		    {
		        System.out.println("YES");
		    }
		    else
		    {
		         System.out.println("NO");
		    }
		    
		    
		    
		}
	}
}// } Driver Code Ends


class Anagram{    
    /*  Function to check if two strings are anagram
    *   a, b: input string
    */
    public static boolean isAnagram(String a,String b)
    {
        
        // Your code here
        int n = a.length();
        int m = b.length();
        
        if (n != m)
            return false;
        
        int count[] = new int[256];
        
        for (int i = 0; i < n; i++)
            count[a.charAt(i)] += 1;
        
        for (int i = 0; i < n; i++)
            count[b.charAt(i)] -= 1;
            
        for (int i = 0; i < 256; i++)
            if(count[i] != 0)
                return false;
        
        return true;
        
    }
}