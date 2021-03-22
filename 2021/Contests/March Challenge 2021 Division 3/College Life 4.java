/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

// wrong answer, did not passed all test cases

class Codechef
{
    static class Item implements Comparable<Item>{
        
        String name;
        int price;
        
        Item(String name, int price) {
            
            this.name = name;
            this.price = price;
            
        }
        
        public int compareTo(Item item2) {
            
            return this.price - item2.price;
            
        }
        
    }
    
    
    public static boolean canServe(int E, int H, Item item) {
        
        String name = item.name;
        
        switch (name) {
            
            case "omelette": 
                
                return E >= 2;
                
                
            case "chocolate milkshake": 
                
                return H >= 3;
                
                
            case "chocolate cake": 
                
                return E >= 1 && H >= 1;
                
            
        }
        
        return false;
    }
    
    public static int calculate(int N, int E, int H, PriorityQueue<Item> minHeap) {
        
        int bill = 0;
        
        while (N > 0) {
            
            if (minHeap.isEmpty()) return -1;
            
            Item item = minHeap.peek();
            
            if (canServe(E, H, item)) {
                
                switch (item.name) {
                             
                    case "omelette": 
                        
                        E -= 2;
                        break;
                        
                        
                    case "chocolate milkshake": 
                        
                        H -= 3;
                        break;
                        
                    case "chocolate cake": 
                        
    
                        E -= 1;
                        H -= 1;
                        break;
                        
                }
                 
                bill += item.price;
                
                N--;
                
            } else { 
                
                minHeap.remove();
                
            }
        }
        
        return N == 0 ? bill : -1;
        
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		while (T-- > 0) {
		    
    		String line1[] = br.readLine().trim().split(" ");
    		
    		int N = Integer.parseInt(line1[0]);
    		
    		int E = Integer.parseInt(line1[1]);
    		int H = Integer.parseInt(line1[2]);
    		
    		
    		PriorityQueue<Item> minHeap = new PriorityQueue<>();
    		
    		minHeap.add(new Item("omelette", Integer.parseInt(line1[3])));
    		minHeap.add(new Item("chocolate milkshake", Integer.parseInt(line1[4])));
    		minHeap.add(new Item("chocolate cake", Integer.parseInt(line1[5])));
    		
    		int minPrice = calculate(N, E, H, minHeap);
    		
    		if (minPrice == -1) {
    		    
    		    System.out.println("-1");
    		    
    		} else {
    		    
    		    System.out.println(minPrice);
    		    
    		}	
		}
	}
}
