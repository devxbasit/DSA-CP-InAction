import java.util.*;
import java.io.*;
import java.lang.*;

class MissingCharsInPanagram
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str = read.readLine();
            System.out.println(new MissingPanagram().missingPanagram(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java


class MissingPanagram
{
    // Complete the function
    // str: input string
    public static String missingPanagram(String str)
    {
        // Find and return the missing characters
        // to complete Panagram string
        boolean alphabets[] = new boolean[26];
        String missingAlphabets = "";
        
        int n = str.length();
        char ch;
        
        for (int i = 0; i < n; i++){
            ch = str.charAt(i);
            
            if (ch >= 65 && ch <= 90)
                alphabets[ch - 'A'] = true;
            else if (ch >= 97 && ch <= 122)
                alphabets[ch - 'a'] = true;
        }
        
        for (int i = 0; i < 26; i++)
            if (alphabets[i] != true)
                missingAlphabets += (char)(i + 'a');
        
        return (missingAlphabets == "") ? "-1" : missingAlphabets;
    }
}

