package list_linkedList;

public class Node {
    Data data;
    private Node next = null;

    public Node(Data d) {
        data = new Data(d.getName(),d.getAddress());
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
