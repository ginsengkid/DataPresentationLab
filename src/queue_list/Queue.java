package queue_list;

import list_linkedList.Node;

public class Queue {
    private class Node{
        int n;
        Node next;
        public Node(int number, Node nxt){
            n = number;
            next = nxt;
        }
    }
    private Node head;
    private Node tail;

    public Queue(){
        head = null;
        tail = null;
    }

    public void enqueue(int x) {
        //empty queue
        if (tail == null){
            tail = new Node(x, null);
            tail.next = tail;
            head = tail;
            return;
        }

        //one elem
        if (head == tail){
            head = new Node(x, tail);
            return;
        }

        //all others
        head.next = new Node(head.n, head.next);
        head.n = x;
    }

    public int dequeue() {
        int t = tail.n;

        //if only 1 element
        if (tail == head){
            makeNull();
            return t;
        }

        //if two elements
        if (head.next == tail){
            tail = head;
            return t;
        }

        //all others
        Node q = head;
        Node q2 = null;
        while (q != tail){
            q2 = q;
            q = q.next;
        }
        tail = q2;
        q2.next = head;
        return t;
    }

    public int front(){
        return head.n;
    }

    public boolean empty() {
        return tail == null;
    }

    public boolean full() {
        return false;
    }

    public void makeNull(){
        tail = null;
        head = null;
    }

    public void print() {
        Node h = head;
        Node t = tail;
        while (h != t) {
            System.out.print(h.n + " ");
            h = h.next;
        }
        System.out.print(tail.n);
        System.out.println();
    }


}
