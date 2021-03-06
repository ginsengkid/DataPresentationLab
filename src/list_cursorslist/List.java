package list_cursorslist;

public class List implements CursorsInterface{
    private static final Node[] mem;
    private static final Position space;
    private int head;

    static {
        mem = new Node[50];
        space = new Position(0);
        for (int i = 0; i < mem.length - 1; i++){
            mem[i] = new Node(i + 1);
        }
        mem[mem.length - 1] = new Node(-1);
    }

    public List(){
        head = -1;
    }

    @Override
    public void insert(Data d, Position p) {
        if (space.getX() == -1) return;


        if (p.getX() == -1){
            //inserting into empty list
            if (head == -1){
                head = space.getX();
                space.setX(mem[space.getX()].getNextNode());
                mem[head].setNode(d, -1);
                return;
            }

            //inserting into last element
            int temp = space.getX();
            space.setX(mem[space.getX()].getNextNode());
            int pos = getLast();
            mem[pos].setNext(temp);
            mem[temp].setNode(d, -1);
            return;
        }


        //inserting into head
        if (p.getX() == head){
            int tempSpace = space.getX();
            space.setX(mem[space.getX()].getNextNode());

            mem[tempSpace].setNode(mem[head].getData(), mem[head].getNextNode());
            mem[head].setNode(d, tempSpace);
            return;
        }

        //all others situations
        int temp = getPrevious(p);
        if (temp == -1) return;

        int myElement = mem[temp].getNextNode();
        int tempSpace = space.getX();

        mem[tempSpace] = new Node(d);
        mem[temp].setNext(tempSpace);
        mem[tempSpace].setNext(myElement);
        space.setX(mem[space.getX()].getNextNode());

    }

    @Override
    public Position locate(Data x) {
        if (x == null || head == -1) return null;
        return (search(x));
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        if (p.getX() < 0 || p.getX() > mem.length) throw new IncorrectPositionException("incorrect index");
        if (p.getX() == head) return mem[head].getData();

        int temp = getPrevious(p);
        if (temp == -1) throw new IncorrectPositionException("incorrect index");
        temp = mem[temp].getNextNode();
        if (temp == -1) throw new IncorrectPositionException("incorrect index");

        return mem[temp].getData();
    }

    @Override
    public void delete(Position p) {
        if (head == -1) return;

        if (p.getX() == head){
            space.setX(head);
            mem[space.getX()].setNext(space.getX());
            head = mem[head].getNextNode();
            p.setX(head);
            return;
        }

        int temp = getPrevious(p);
        if (temp == -1) return;
        int next = mem[temp].getNextNode();
        if (next == -1) return;
        mem[temp].setNext(mem[next].getNextNode());
        mem[next].setNext(space.getX());
        space.setX(next);
        p.setX(mem[temp].getNextNode());
    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        if (p.getX() > mem.length) throw new IncorrectPositionException("incorrect index");

        //next (head)
        if (p.getX() == head) return new Position(mem[head].getNextNode());


        int temp = getPrevious(p);
        if (temp == -1) throw new IncorrectPositionException("incorrect index");
        temp = mem[temp].getNextNode();
        if (temp == -1) throw new IncorrectPositionException("incorrect index");


        return new Position(mem[temp].getNextNode());
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        if (p.getX() > mem.length || p.getX() == head) throw new IncorrectPositionException("incorrect index");

        int temp = getPrevious(p);
        if (temp == -1) throw new IncorrectPositionException("incorrect index");
        return new Position(temp);
    }

    @Override
    public Position first() {
        return new Position(head);
    }

    @Override
    public void makeNull() {
        if (head == -1) return;
        mem[getLast()].setNext(space.getX());
        space.setX(head);
        head = -1;
    }

    @Override
    public void printList() {
        if (head == -1 || mem[head].getData() == null){
            System.out.println("The List is empty");
            return;
        }
        int q = head;
        int i = 1;
        while (true){
            System.out.print((i) + ") ");
            mem[q].getData().printData();
            System.out.println();
            if (mem[q].getNextNode() == -1){
                return;
            }
            q = mem[q].getNextNode();
            i++;
        }
    }

    @Override
    public Position end() {
        return new Position(-1);
    }

    private int getPrevious(Position p) {
        int q = head;
        int q2 = -1;

        while (q != -1){
            if (p.getX() == q) {
                return q2;
            }
            q2 = q;
            q = mem[q].getNextNode();
        }
        return -1;
    }

    private int getLast() {
        int q = head;
        int q2 = -1;

        while (q != -1){
            q2 = q;
            q = mem[q].getNextNode();
        }
        return q2;
    }

    private Position search(Data x){
        int q = head;

        while (q != -1){
            if (mem[q].getData().equals(x)) {
                return new Position(q);
            }
            q = mem[q].getNextNode();
        }
        return new Position(-1);
    }
}
