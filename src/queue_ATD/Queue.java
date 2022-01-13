package queue_ATD;
import list_linkedList.*;

public class Queue {
    List l;
    Position tail;

    public Queue(){
       l = new List();
       tail = null;
    }

    public void enqueue(Data x) {
        if (tail == null){
            l.insert(x,l.first());
            tail = l.first();
            return;
        }
        if (tail.equals(l.first())){
            l.insert(x,l.first());
            tail = l.next(tail);
            return;
        }
        l.insert(x,l.first());
    }

    public Data dequeue() {
        Position p = tail;
        if (tail == l.first()){
            makeNull();
            return p.getNode().getData();
        }
        tail = l.previous(tail);
        return p.getNode().getData();
    }

    public Data front(){
        return l.first().getNode().getData();
    }

    public boolean empty() {
        return l.first().getP() == null;
    }

    public boolean full() {
        return false;
    }

    public void makeNull(){
        l.makeNull();
    }

    public void print() {
        l.printList();
    }
}
