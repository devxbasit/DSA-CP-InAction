// { Driver Code Starts
import java.lang.Math;
import java.util.*;
class UniqueRows{
public static void main(String[] args)
 {  Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int r=sc.nextInt();
			int c=sc.nextInt();
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        System.out.print(demo.get(j)+" ");
			    }
			    System.out.print("$");
			}
			System.out.println();
		}
 }
}// } Driver Code Ends


/*Complete the given function*/
class GfG
{
    
    public static ArrayList<Integer> stringToArrayList(String S) {
        
        ArrayList<Integer> al = new ArrayList<>();
        
        for (int i = 0; i < S.length(); i++) {
            
            
            al.add(Character.getNumericValue(S.charAt(i)));
            
        }
        
        return al;

    }
    
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][], int r, int c)
    {
        //add code here.
        
        HashSet<String> hs = new HashSet<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    
        for (int i = 0; i < a.length; i++) {
            
            String S = "";
            
            for (int j = 0; j < a[0].length; j++) {
                
                S += String.valueOf(a[i][j]);
                
            }
            
            if (!hs.contains(S)) {
                
                hs.add(S);
                al.add(stringToArrayList(S));
                
            }
            
        }
        
        
        return al;
    }
}