package hashmap_linkedList;
import list_linkedList.Data;

public class Map {
    private static class Node{
        Data data;
        Node next;

        public Node(char[] name, char[] address,  Node n){
            next = n;
            data = new Data(name, address);
        }

        public void setValue(char[] a) {
            this.data.setAddress(a);
        }
    }

    private Node head;

    public Map() {
        head = null;
    }

    public void makeNull() {
        head = null;
    }

    public void assign(char[] d, char[] r) {
        if (head == null) {
            head = new Node(d, r, null);
            return;
        }

        //trying to find key
        Node q = head;
        while (q != null){
            if (q.data.compareCharArrays(q.data.getName(), d)){
                q.setValue(r);
                return;
            }
            q = q.next;
        }

        //if key not found insert right after head
        if (head.next == null){
            head.next = new Node(d, r, null);
            return;
        }

        q = head.next;
        head.next = new Node(d, r, q);
    }

    public boolean compute(char[] d, char[] r) {
        if (head == null) return false;

        Node q = head;
        while (q != null){
            if (q.data.compareCharArrays(q.data.getName(), d)){
                q.setValue(r);
                return true;
            }
            q = q.next;
        }
        return false;
    }

    public void print() {
        Node q = head;
        while (q!=null){
            q.data.printData();
            q = q.next;
        }
    }
}
