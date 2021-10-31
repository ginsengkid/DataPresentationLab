package DoublyLinkedList;

public class Node {
    Data data;
    Node next;
    Node prev;

    public Node(Data d){
        new Node (d.getName(), d.getAddress());
    }

    public Node(char[] name, char[] address){
        data = new Data(name, address);
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
