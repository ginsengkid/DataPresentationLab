package queue_ATD;

import list_linkedList.Data;

public class Main {
    public static void main(String[] args) {
        Queue q = new Queue();
        System.out.println(q.empty());
        q.enqueue(new Data("1", "1"));
        q.enqueue(new Data("2", "2"));
        q.enqueue(new Data("3", "3"));
        q.enqueue(new Data("4", "4"));
        q.enqueue(new Data("5", "5"));
        q.enqueue(new Data("6", "6"));
        q.enqueue(new Data("7", "7"));
        q.enqueue(new Data("8", "8"));
        q.enqueue(new Data("9", "9"));
        System.out.println(q.full());
        q.print();
        System.out.println(q.empty());
        q.front().printData();
        q.dequeue().printData();
        q.dequeue().printData();
        q.dequeue().printData();
        System.out.println(q.empty());
    }
}
