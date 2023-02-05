// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Node 
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class CreateTree
{
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
            GfG gfg = new GfG();
            Node root = gfg.createTree(arr, n);
            
            printLevelOrder(root);
            System.out.println();
        }
    }
    
    public static void printList(Node root)
    {
        while(root != null)
        {
            System.out.print(root.data + " ");
        }
    }
    
    public static void printLevelOrder(Node root)
    {
        int h = height(root);
        int i;
         for (i=1; i<=h; i++)
        {
        result.clear();
        printGivenLevel(root, i);
        Collections.sort(result);
        for(int j=0;j<result.size();j++)
            System.out.print(result.get(j) + " ");
        }
    }
    
    public static int height(Node root)
    {
        if(root == null)
          return 0;
          
        else
    {

        int lheight = height(root.left);
        int rheight = height(root.right);


        if (lheight > rheight)
            return(lheight+1);
        else return(rheight+1);
    }
    }
    
    public static void printGivenLevel(Node node, int level)
    {
        if (node == null)
             return;
    if (level == 1)
        result.add(node.data);
    else if (level > 1)
    {
        printGivenLevel(node.left, level-1);
        printGivenLevel(node.right, level-1);
    }
    }
}

// } Driver Code Ends


/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class GfG
{
    public static Node createTree(int parent[], int N)
    {
        //Your code here
        
        Node created[] = new Node[N];
        
        Node parentNode = null;
        Node childNode = null;
        Node root = null;
        
        for (int i = 0; i < N; i++){
            
            // if child node is not created
            if (created[i] == null){
             
                childNode = new Node(i);
                created[i] = childNode;
            }else{
                
                childNode = created[i];
            }
            
            // if child == root (no parent)
            if (parent[i] == -1){
                
                root = childNode;
                continue;
            }
            
            // if parent node is not created
            if (created[parent[i]] == null){
                
                parentNode = new Node(parent[i]);
                created[parent[i]] = parentNode; 
            }else {
                
                parentNode = created[parent[i]];
            }
            
            // assign child node to parent
            if (parentNode.left == null){
                parentNode.left = childNode;
                continue;
            }
            
            parentNode.right = childNode;
        }
        
        return root;
        
    }
    
}

