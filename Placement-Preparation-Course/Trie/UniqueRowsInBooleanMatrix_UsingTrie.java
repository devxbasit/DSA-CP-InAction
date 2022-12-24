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
    static class TrieNode {
        
        TrieNode children[] = new TrieNode[2];
        boolean isEnd;
        
        TrieNode() {
            
            for (int i = 0; i < children.length; i++) {
                
                children[i] = null;
                
            }
            
            isEnd = false;
            
        }
        
    }
    
    public static void insertRow(TrieNode root, int a[][], ArrayList<ArrayList<Integer>> al, int row) {
        
        
        TrieNode node = root;
        
        for (int level = 0; level < a[0].length; level ++) {
            
            if (node.children[a[row][level]] == null) {
                
                node.children[a[row][level]] = new TrieNode();
                   
            }   
            
            node = node.children[a[row][level]];
        }
        
        if (!node.isEnd) {
            
            node.isEnd = true;
            
            ArrayList<Integer> temp = new ArrayList<>();
            
            for (int col = 0; col < a[0].length; col++) {
                
                temp.add(a[row][col]);    
                
            }
            
            al.add(temp);
        }
    }
    
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        
        //add code here.
        
        TrieNode root = new TrieNode();
        
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        
        for (int row = 0; row < a.length; row++) {
            
            insertRow(root, a, al, row)    ;
            
        }
        
        return al;
        
    }
}