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
            if (p.getX() == null) {
                head = new Node(d);
            }
            return;
        }

        if (p == null) {
            Position p1 = getLast();
            if (p1 == null) return;
            p1.getX().setNext(new Node(d));
            return;
        }

        //inserting into head, if list length more than 1
        if (p.getX().equals(first().getX())){
            Node temp = head;
            head = new Node(d);
            head.setNext(temp);
            return;
        }

        //insert into other positions
        Position temp = getPrevious(p);
        if (temp != null) {
            if (temp.getX().getNextNode() == null){
                temp.getX().getNextNode().setNext(new Node(d));
            }
            Node temp2 = temp.getX().getNextNode();
            temp.getX().setNext(new Node(d));
            temp.getX().getNextNode().setNext(temp2);
        }

    }


    @Override
    public Position locate(Node x) {
        Node q = head;
        while (q!=null){
            if (q.equals(x))
                return new Position(q);
            q = q.getNextNode();
        }
        return null;
    }

    @Override
    public Node retrieve(Position p) throws IncorrectPositionException {
        if (p == null) throw new IncorrectPositionException("no such position in this List");
        return p.getX();
    }

    @Override
    public void delete(Position p) {
        if (p == null) return;
        Position temp = getPrevious(p);
        if (temp != null){
            temp.getX().setNext(temp.getX().getNextNode().getNextNode());
            p.setP(temp.getX().getNextNode());
        }
    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        if (p.getX() == null) throw new IncorrectPositionException("No such position in the list");
        return new Position(p.getX().getNextNode());
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        if (p == null || p.getX() == head) throw new IncorrectPositionException("No such position in the list");

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

    public Position getPrevious(Position p){
        Node q = head;
        Node q2 = head.getNextNode();

        while (q2 != null){
            if (p.getX() == q2){
                return new Position(q);
            }
            q = q.getNextNode();
            q2 = q2.getNextNode();
        }
        return null;
    }

    public Position getLast(){
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
    public Node end() {
        return null;
    }
}
