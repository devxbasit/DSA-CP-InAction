import java.util.*;
import java.lang.*;
import java.io.*;

/*
Sahil is done with his internship and now it's time to attend Geeks Classes to enhance knowledge of Data Structures. However, to join this class, he has been given a task to complete. The task is to count the occurrences of "gfg" in the given string, and if he completes this task, he qualifies for Geeks Classes. But, Sahil is facing some problem in solving this task, so help him.

Input :
First line of input contains "T" testcases. Next "T" lines contains Strings with lowercase characters.

Output :
For each testcase, output the count the ccurrences of "gfg"(continuous) present in string.
*/

public class SahilLovesGFG {
    public static void main (String[] args)throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim());
        
        while (T-- > 0){
            String s = br.readLine().trim();
            int len = s.length() - 2;
            
            int count = 0;
        
            for (int i = 0; i < len; i++)
                if (s.charAt(i) == 'g' && s.charAt(i + 1) == 'f' && s.charAt(i + 2) == 'g')
                    count++;
            
            if (count == 0)
                System.out.println(-1);
            else
                System.out.println(count);
        }
    }
}