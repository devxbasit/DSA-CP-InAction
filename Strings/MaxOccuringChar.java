import java.lang.*;
import java.io.*;
import java.util.*;
class MaxOccuringChar
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     MaxOccur obj = new MaxOccur();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}// } Driver Code Ends


class MaxOccur{
    
    // Function to get maximum occuring 
    // character in given string str
    public static char getMaxOccuringChar(String line){
        
        // Your code here
        HashMap<Character, Integer> hm = new HashMap<>();
        
        int n = line.length();
        Character ch;
        int count = 0;
        
        for (int i = 0; i < n; i++){
            ch = line.charAt(i);
            count = 1;
            
            if (hm.containsKey(ch))
                count = hm.get(ch) + 1;
            
            hm.put(ch, count);
        }
        
        int maxCount = 0;
        Character winner = ' ';
        
        for (Map.Entry<Character, Integer> entry : hm.entrySet()){
            Character key = entry.getKey();
            int val = entry.getValue();
            
            if (val > maxCount){
                maxCount = val;
                winner = key;
            }
                
            if (val == maxCount)
                if (winner.compareTo(key) > 0)
                    winner = key;
        }
        
        return winner;
    }
    
}