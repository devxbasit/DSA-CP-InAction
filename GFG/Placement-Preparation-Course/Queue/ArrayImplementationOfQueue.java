class Queue{
    
    int array[];
    int front, rear;
    int capacity, size;
    
    Queue(int capacity){

        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = capacity - 1;

        array = new int[this.capacity];

    }
       
    public boolean isFull(Queue queue){

        return (queue.size == queue.capacity);
    }   

    public boolean isEmpty(Queue queue){

        return (queue.size == 0);
    }


    public void enqueue(int item){

        if (isFull(this)){

            System.out.println("overflow");
            return;
        }

        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size++;
    }
    
    public int dequeue(){

        if (isEmpty(this)){
            System.out.println("underflow");
            return Integer.MIN_VALUE;
        }

        int item = this.array[this.front];

        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return item;
    }
    
    public int front(){

        if (isEmpty(this))
            return Integer.MIN_VALUE;
        

        return this.array[this.front];
    }
    

    public int rear(){

        if (isEmpty(this))
            return Integer.MIN_VALUE;

        return this.array[this.rear];
    }
}


public class ArrayImplementationOfQueue {

    public static void main(String args[]){

        Queue queue = new Queue(3);

        System.out.println("Front - " + queue.front() + ", Rear - " + queue.rear());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front - " + queue.front() + ", Rear - " + queue.rear());

        System.out.println("Dequeu - " + queue.dequeue());
        System.out.println("Dequeu - " + queue.dequeue());
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Front - " + queue.front() + ", Rear - " + queue.rear());

        //  queue.enqueue(60);

        System.out.println("Dequeu - " + queue.dequeue());
        System.out.println("Dequeu - " + queue.dequeue());
        System.out.println("Dequeu - " + queue.dequeue());

        //  System.out.println("Dequeu - " + queue.dequeue());

    }
}