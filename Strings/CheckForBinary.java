import java.util.*;

class CheckForBinary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		while(T>0)
		{
			String str = sc.nextLine();
			GfG g = new GfG();
			boolean b = g.isBinary(str);
			if(b== true)
				System.out.println(1);
			else
			    System.out.println(0);
		T--;
		}
	}
}

// } Driver Code Ends


class GfG
{
	boolean isBinary(String str)
	{
	  //Your code here
	  char ch;
	  for (int i = 0; i < str.length(); i++){
	    ch = str.charAt(i); 
	    if (ch != '0' && ch != '1')
	        return false;
	  }
	  return true;
	}
}