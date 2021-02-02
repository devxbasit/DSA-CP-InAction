// Initial Template for Java

import java.util.*;
import java.io.*;

class GfG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            MinHeap h = new MinHeap(a);
            for (int i = 0; i < a; i++) {
                int c = sc.nextInt();
                int n;
                if (c == 1) {
                    n = sc.nextInt();

                    h.insertKey(n);
                }
                if (c == 2) {
                    n = sc.nextInt();
                    h.deleteKey(n);
                }
                if (c == 3) {
                    System.out.print(h.extractMin() + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class MinHeap {
    int[] harr;
    int capacity, heap_size;
    
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }


    
    void swap(int i, int j){
        int temp = harr[i];
        harr[i] = harr[j];
        harr[j] = temp;
    }
    
    void trickleUp(int pos){
        
        if (pos == 0)
            return;
            
        int p = (pos - 1) / 2;

                
        if (harr[p] > harr[pos]){
            swap(p, pos);
            
            trickleUp(p);
        }
    }
    
    
    void trickleDown(int pos){
        
        int l = left(pos);
        int r = right(pos);
        
        int smallest = pos;
        
        if (l < heap_size && harr[l] < harr[pos])
            smallest = l;
            
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
            
        if (smallest != pos){
            
            swap(pos, smallest);
            trickleDown(smallest);
        }
        
            
    }

    
    // You need to write code for below three functions
    int extractMin() {
        // Your code here.
        if (heap_size <= 0)
            return -1;
        
        int min = harr[0];
        
        swap(0, heap_size - 1);
        
        heap_size--;
        
        trickleDown(0);
        
        return min;
    }

    void insertKey(int k) {
        // Your code here.
        
        if (heap_size >= capacity)
            return;
            
        harr[heap_size] = k;
        
        trickleUp(heap_size);
        
        heap_size++;

    }
    
    
    void deleteKey(int i) {
        // Your code here.
        
        if (i >= heap_size)
            return;
            
        harr[i] = Integer.MIN_VALUE;
        trickleUp(i);
        
        extractMin();
        

    }

    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
