package list;

public class Node {
    Data data;
    private Node next = null;

    public Node(Data d) {
        data = d;
    }

    public Node(Data d, Node n) {
        data = d;
        next = n;
    }

    public Node getNextNode() {
        return next;
    }

    public void setNext(Node x) {
        this.next = x;
    }

    public Data getData(){
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
