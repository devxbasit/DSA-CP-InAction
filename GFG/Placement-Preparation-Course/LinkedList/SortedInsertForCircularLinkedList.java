//Code by:Saksham Raj Seth
import java.util.*;
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}
class LL{
Node head;
Node tail;
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }
 public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0) {
            int n = sc.nextInt();
            LL llist = new LL();
			llist.head=null;
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }
			int value=sc.nextInt();
			Node phead=head;
			while(phead.next!=null){
				phead=phead.next;
			}
			phead.next=head;
            GfG g=new GfG();
			head = g.sortedInsert(head,value);
			Node current = head;
			
			if(head != null){
			    do{
			        System.out.print(current.data+" ");
			        current = current.next;
			    }while(current != head);
			}
			System.out.println();
        }
    }
}// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
}*/

class GfG
{
	public static Node sortedInsert(Node head,int data)
         {
            //add code here.
            
            Node newNode = new Node(data);
            
            if (head == null){
                newNode.next = newNode;
                head = newNode;
            }
                
            
            if (head.data > data){
                
                Node temp = head.next;
                
                while (temp.next != head)
                    temp = temp.next;
                
                
                temp.next = newNode;
                newNode.next = head;
                head = newNode;
                
                return head;
            }
            
            
            
            Node temp = head;
            
            while (temp.next != head && temp.next.data < data)
                temp = temp.next;
            
            newNode.next = temp.next;
            temp.next = newNode;
            return head;
         }
}
