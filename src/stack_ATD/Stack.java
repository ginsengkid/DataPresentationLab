package stack_ATD;
import list_linkedList.*;

public class Stack {
    List l;

    public Stack(){
        l = new List();
    }

    public boolean full(){
        return false;
    }

    public boolean empty(){
        return l.first() == null;
    }

    public Data top(){
        return l.retrieve(l.first());
    }

    public void push(Data d){
        l.insert(d,l.first());
    }

    public Data pop(){
        Data d = l.retrieve(l.first());
        l.delete(l.first());
        return d;
    }


}
