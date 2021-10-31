package DoublyLinkedList;

public class List implements DoublyLinkedInterface{
    private Node head;
    private Node tail;

    public List(){
        head = null;
        tail = null;
    }

    @Override
    public void insert(Data d, Position p) {
        if(head == null && tail == null){
            if (p.getNode() == null){
                head = new Node(d);
                tail = head;
            }
        }

    }

    @Override
    public Position locate(Data x) {
        return null;
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        return null;
    }

    @Override
    public void delete(Position p) {

    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        return null;
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        return null;
    }

    @Override
    public Position first() {
        return null;
    }

    @Override
    public void makeNull() {

    }

    @Override
    public void printList() {

    }

    @Override
    public Position end() {
        return null;
    }
}
