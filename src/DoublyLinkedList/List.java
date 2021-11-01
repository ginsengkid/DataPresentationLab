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
        if(head == tail){
            if (p.getNode() == null){
                if (head == null) {
                    //empty list
                    head = new Node(d);
                    tail = head;
                    return;
                }

                //inserting into second elem, when tail == head != null
                head.setNext(new Node(d));
                tail = head.getNextNode();
                tail.setPrev(head);
                return;
            }

            //inserting into head elem, when tail == head != null
            if (p.getNode() == head){
                head = new Node(d);
                head.setNext(tail);
                tail.setPrev(head);
                return;
            }
        }

        //inserting into tail
        if (p == null){
            tail.setNext(new Node(d));
            tail.getNextNode().setPrev(tail);
            tail = tail.getNextNode();
            printList();
            System.out.println();
            return;
        }

        //inserting into head
        if (p.getNode() == head){
            Node temp = head;
            head = new Node(d);
            head.setNext(temp);
            temp.setPrev(head);
            return;
        }

        //all other situations
        Node temp = getElem(p);
        if (temp == null) return;
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
        Node res = getElem(p);
        if (res == null) return null;
        return res.getData();
    }

    @Override
    public void delete(Position p) {
        if (head == null || tail == null) return;
        if (p == null) return;

        if (head == tail){
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

        Node temp = getElem(p);
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

       Node temp = getElem(p);
       if (temp == null) throw new IncorrectPositionException("no such pos in the list");
       return new Position(temp.getNextNode());
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

        Node temp = getElem(p);
        if (temp == null) throw new IncorrectPositionException("no such pos in the list");
        return new Position(temp.getPrevNode());
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
        return null;
    }

    private Node getElem(Position p){
        Node q = head;

        while (q != null){
            if (p.getNode() == q) {
                return q;
            }
            q = q.getNextNode();
        }
        return null;
    }

    private Node search(Data x){
        Node q = head;
        while (q!=null){
            if (q.getData().equals(x))
                return q;
            q = q.getNextNode();
        }
        return null;
    }
}
