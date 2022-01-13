package list_DoublyLinkedList;

public class List implements DoublyLinkedInterface{
    private Node head;
    private Node tail;

    public List(){
        head = null;
        tail = null;
    }

    @Override
    public void insert(Data d, Position p) {
        if(head == tail){
            if (p.getNode() == null && head == null){
                //empty list
                head = new Node(d);
                tail = head;
                return;
            }

            //inserting into head, when tail == head != null
            head.setNext(new Node(head.getData()));
            head.setData(d);
            tail = head.getNextNode();
            tail.setPrev(head);

            return;
        }

        //inserting in head
        if (p.getNode() == head){
            Node temp = head.getNextNode();
            head.setNext(new Node(head.getData()));
            head.setData(d);
            head.getNextNode().setNext(temp);
            head.getNextNode().setPrev(head);
            temp.setPrev(head.getNextNode());
            return;
        }

        //inserting into null
        if (p.getNode() == null){
            tail.setNext(new Node(d));
            tail.getNextNode().setPrev(tail);
            tail = tail.getNextNode();
            printList();
            System.out.println();
            return;
        }

        //insert into tail
        if (p.getNode() == tail){
            Node temp = tail.getPrev();
            temp.setNext(new Node(d));
            temp.getNextNode().setNext(tail);
            temp.getNextNode().setPrev(temp);
            tail.setPrev(temp.getNextNode());
            return;
        }

        //all other situations
        Node temp;
        if (isInList(p))
            temp = p.getNode();
        else return;

        Node next = temp.getNextNode();
        temp.setNext(new Node(d));
        temp.getNextNode().setNext(next);
        temp.getNextNode().setPrev(temp);
        next.setPrev(temp.getNextNode());
    }

    @Override
    public Position locate(Data x) {
        if (x == null || head == null) return new Position(null);
        return new Position(search(x));
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        if (p == null) throw new IncorrectPositionException("no such position in this List");
        if (head == null) throw new IncorrectPositionException("list is empty");

        if (!isInList(p)) return null;
        return p.getNode().getData();
    }

    @Override
    public void delete(Position p) {
        if (head == null || tail == null) return;
        if (p == null) return;

        if (head == tail && p.getNode() == head){
            head = null;
            tail = null;
        }

        if (p.getNode() == head){
            head = head.getNextNode();
            head.setPrev(null);
            p.setP(head);
            return;
        }

        if (p.getNode() == tail){
            tail = tail.getPrev();
            tail.setNext(null);
            p.setP(null);
            return;
        }

        if (!isInList(p)) return;
        Node temp = p.getNode();
        Node prev = temp.getPrev();
        prev.setNext(temp.getNextNode());
        temp.getNextNode().setPrev(prev);
        p.setP(prev.getNextNode());

    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
       if (p == null || p.getNode() == null) throw new IncorrectPositionException("no such pos in the list");

       if (p.getNode() == head) {
           return new Position(head.getNextNode());
       }

       if (p.getNode() == tail) {
           return new Position(null);
       }

       if (!isInList(p)) throw new IncorrectPositionException("no such pos in the list");
       return new Position(p.getNode().getNextNode());
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        if (p == null || p.getNode() == null) throw new IncorrectPositionException("no such pos in the list");

        if (p.getNode() == tail) {
            return new Position(head.getPrevNode());
        }

        if (p.getNode() == head){
            throw new IncorrectPositionException("no such pos in the list");
        }


        if (!isInList(p)) throw new IncorrectPositionException("no such pos in the list");
        return new Position(p.getNode().getPrevNode());
    }

    @Override
    public Position first() {
        return new Position(head);
    }

    @Override
    public void makeNull() {
        head = null;
        tail = null;
    }

    @Override
    public void printList() {
        if (head == null || head.getData() == null){
            System.out.println("The List is empty");
            return;
        }
        Node p = head;
        int i = 1;
        while (p != null){
            System.out.print((i) + ") ");
            p.getData().printData();
            p = p.getNextNode();
            i++;
        }
    }

    @Override
    public Position end() {
        return new Position(null);
    }

    private Boolean isInList(Position p){
        Node q = head;

        while (q != null){
            if (p.getNode() == q) {
                return true;
            }
            q = q.getNextNode();
        }
        return false;
    }

    private Node search(Data x){
        Node q = head;
        while (q != null){
            if (q.getData().equals(x))
                return q;
            q = q.getNextNode();
        }
        return null;
    }
}
