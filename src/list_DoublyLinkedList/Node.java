package list_DoublyLinkedList;

public class Node {
    private Data data;
    private Node next;
    private Node prev;

    public Node(Data d){
        data = new Data(d.getName(), d.getAddress());
    }

    public Node(char[] name, char[] address){
        data = new Data(name, address);
    }

    public Node getNextNode() {
        return this.next;
    }

    public Node getPrevNode() {
        return this.prev;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
