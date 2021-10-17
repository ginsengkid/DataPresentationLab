package list;

public class List implements ListInterface {
    private final Position End = null; //первый свободный
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

        if (p == null) {
            Position p1 = getLast();
            if (p1 == null) return;
            p1.getNode().setNext(new Node(d));
            return;
        }

        //inserting into head, if list length more than 1
        if (p.getNode().equals(first().getNode())){
            Node temp = head;
            head = new Node(d);
            head.setNext(temp);
            return;
        }

        //insert into other positions
        Position temp = getPrevious(p);
        if (temp != null) {
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
        Node q = head;
        while (q!=null){
            if (q.getData().equals(x))
                return new Position(q);
            q = q.getNextNode();
        }
        return null;
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        if (p == null) throw new IncorrectPositionException("no such position in this List");
        return p.getNode().getData();
    }

    @Override
    public void delete(Position p) {
        if (p == null) return;
        Position temp = getPrevious(p);
        if (temp != null){
            Node tempNode = temp.getNode().getNextNode();
            temp.getNode().setNext(tempNode.getNextNode());
            p.setP(temp.getNode().getNextNode());
        }
    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        if (p.getNode() == null) throw new IncorrectPositionException("No such position in the list");
        return new Position(p.getNode().getNextNode());
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        if (p == null || p.getNode() == head) throw new IncorrectPositionException("No such position in the list");

        Position result = getPrevious(p);
        if (result != null) return result;
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

    private Position getPrevious(Position p){
        Node q = head;
        Node q2 = head.getNextNode();

        while (q2 != null){
            if (p.getNode() == q2){
                return new Position(q);
            }
            q = q.getNextNode();
            q2 = q2.getNextNode();
        }
        return null;
    }

    private Position getLast(){
        Node q = head;
        if (q == null) return null;
        Node q2 = head.getNextNode();
        if (q2 == null) return null;
        while (q2 != null){
            q = q2;
            q2 = q.getNextNode();
        }
        return new Position(q);
    }

    @Override
    public Position end() {
        return null;
    }
}
