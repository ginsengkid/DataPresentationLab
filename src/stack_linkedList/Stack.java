package stack_linkedList;

public class Stack {
    private class Node{
        int n;
        Node next;
        public Node(int number, Node n){
            this.n = number;
            next = n;
        }
    }

    private Node head;

    public Stack(){
        head = null;
    }

    public boolean empty(){
        return head == null;
    }

    public boolean full(){
        return false;
    }

    public int top(){
        return head.n;
    }

    public void push(int v){
        head = new Node(v, head);
    }

    public int pop(){
        int temp = head.n;
        head = head.next;
        return temp;
    }

}
