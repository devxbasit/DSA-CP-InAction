import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new solve().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends

/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class solve{
    
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
       
        Queue<Item> maxHeap = new PriorityQueue<>(new Comparator<Item>(){
            
            public int compare(Item item1, Item item2) {
                
                double ratio1 = item1.value / (double )item1.weight;
                double ratio2 = item2.value / (double )item2.weight;
                
                return Double.compare(ratio2, ratio1);   
                
            }
        });
        
        for (int i = 0; i < n; i++) {
            
            maxHeap.add(new Item(arr[i].value, arr[i].weight));
            
        }
        
        
        int availableSpace = W;
        double maxValue = 0;
        
        for (int i = 0; i < n; i++) {
            
            Item item = maxHeap.remove();
            // System.out.println("item.value " + item.value + " item.weight " + item.weight + " ratio " + item.value / item.weight);
            
            if (availableSpace >= item.weight) {
                
                maxValue += item.value;
                availableSpace -= item.weight;
                
            } else {
                
                // System.out.println("avSpace " + availableSpace + "maxValue " +maxValue + "item wiehgt " +item.weight );
                maxValue += (item.value / (double)item.weight) * (double ) availableSpace;    
                break;
                
            }

        }
        
        return maxValue;
    }
}