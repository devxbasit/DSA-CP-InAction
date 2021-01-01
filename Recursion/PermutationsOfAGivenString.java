import java.lang.*;
import java.io.*;
class PermutationsOfAGivenString
 {
     static SortedSet<String> ts = new TreeSet<>();
     
     public static String swap(String s, int i, int j){
         char ch[] = s.toCharArray();
         
         char t = ch[i];
         ch[i] = ch[j];
         ch[j] = t;
         
         return String.valueOf(ch);
     }
     
     public static void premute(String s, int left, int right){
         
         if (left == right){
             ts.add(s);
             return;
         }
         
         for (int i = left; i <= right; i++){
             
             // do
             s = swap(s, left, i);
             
             // recur
             premute(s, left + 1, right);
             
             // undo
             s = swap(s, left, i);
         }
     }
     
     
     public static void printPremutations(String s){
        
        premute(s, 0, s.length() - 1);
        
        for (String value : ts)
            System.out.printf("%s ", value);
            
	    System.out.println();
    
     }
     
     
	public static void main (String[] args) throws IOException
	 {
	     //code
	     
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 
    	 int T = Integer.parseInt(br.readLine().trim());
    	 
    	 while (T-- > 0){
    	     
    	     printPremutations(br.readLine().trim());
    	     
    	     ts.clear();
    	     
	    }
	 
	 }
}