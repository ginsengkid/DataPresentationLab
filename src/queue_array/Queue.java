package queue_array;

public class Queue {
    private final int[] array;
    private int front;
    private int rear;
    private final int len = 10;

    public Queue(){
        array = new int[len];
        rear = len - 1;
        front = 0;
    }

    public void enqueue(int x) {
        rear = next(rear);
        array[rear] = x;
    }

    public int dequeue() {
        int temp = array[front];
        front = next(front);
        return temp;
    }

    public int front(){
        return array[front];
    }

    public boolean empty() {
        return(next(rear) == front);
    }

    public boolean full() {
        return(next(next(rear)) == front);
    }

    public void makeNull(){
        rear = len - 1;
        front = 0;
    }

    public void print() {
        int i = front;
        int j = next(rear);
        while(i != j) {
            System.out.print(array[i] + " ");
            i = next(i);
        }
        System.out.println();
        System.out.println();
    }

    private int next(int a){
        return((a + 1) % len);
    }
}
