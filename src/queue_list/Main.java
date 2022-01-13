package queue_list;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.empty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        System.out.println(q.full());
        q.print();
        System.out.println(q.front());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.empty());
    }
}
