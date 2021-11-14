package list;

public class List implements ListInterface {
    private Node head;

    public List(){
        head = null;
    }

    @Override
    public void insert(Data d, Position p) {
        if (head == null){
            if (p.getNode() == null) {
                head = new Node(d);
            }
            return;
        }

        if (p.getNode() == null) {
            Position p1 = new Position(getLast());
            p1.getNode().setNext(new Node(d));
            return;
        }

        //inserting into head
        if (p.getNode() == head){
            Node temp = head;
            head = new Node(d);
            head.setNext(temp);
            return;
        }

        //insert into other positions
        Position temp = new Position(getPrevious(p));
        if (temp.getNode() != null) {
            if (temp.getNode().getNextNode() == null){
                temp.getNode().getNextNode().setNext(new Node(d));
            }
            Node temp2 = temp.getNode().getNextNode();
            temp.getNode().setNext(new Node(d));
            temp.getNode().getNextNode().setNext(temp2);
        }

    }


    @Override
    public Position locate(Data x) {
        if (x == null) return null;
        return new Position(search(x));
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        if (p == null) throw new IncorrectPositionException("no such position in this List");

        Node temp = getPrevious(p);
        if (temp == null) throw new IncorrectPositionException("no such position in this List");
        return p.getNode().getData();
    }

    @Override
    public void delete(Position p) {
        if (p == null) return;

        if (p.getNode() == head) {
            head = head.getNextNode();
            return;
        }

        Position temp = new Position(getPrevious(p));
        if (temp.getNode() != null){
            Node tempNode = temp.getNode().getNextNode();
            temp.getNode().setNext(tempNode.getNextNode());
            p.setP(temp.getNode().getNextNode());
        }
    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        if (p == null ) throw new IncorrectPositionException("No such position in the list");

        if (p.getNode() == head) {
            if (head.getNextNode() == null) throw new IncorrectPositionException("No such position in the list");
            return new Position(head.getNextNode());
        }

        Node temp = getPrevious(p);
        if (temp == null) throw new IncorrectPositionException("No such position in the list");
        return new Position(temp.getNextNode().getNextNode());
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        if (p == null || p.getNode() == head) throw new IncorrectPositionException("No such position in the list");

        Node result = getPrevious(p);
        if (result != null) return new Position(result);
        throw new IncorrectPositionException("No such position in the list");
    }

    @Override
    public Position first() {
        return new Position(head);
    }

    @Override
    public void makeNull() {
        head = null;
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

    private Node getPrevious(Position p) {
        Node q = head;
        Node q2 = null;

        while (q != null){
            if (p.getNode() == q) {
                return q2;
            }
            q2 = q;
            q = q.getNextNode();
        }
        return null;
    }

    private Node getLast() {
        Node q = head;
        Node q2 = null;
        while (q != null){
            q2 = q;
            q = q.getNextNode();
        }
        return q2;
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


    @Override
    public Position end() {
        return new Position (null);
    }
}
