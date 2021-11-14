package cursorslist;

public class List implements CursorsInterface{
    private static final Node[] mem;
    private static int space;
    private int head;

    static {
        mem = new Node[50];
        space = 0;
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
        if (space == -1) return;

        //inserting into empty list
        if (head == -1){
            if (p.getX() == -1){
                head = space;
                space = mem[space].getNextNode();
                mem[head].setNode(d, -1);

                return;
            }
            return;
        }

        //inserting into the LAST elem
        if (p.getX() == -1) {
            int temp = space;
            space = mem[space].getNextNode();
            int pos = getLast();
            mem[pos].setNext(temp);
            mem[temp].setNode(d, -1);
            return;
        }

        //inserting into head
        if (p.getX() == head){
            int tempSpace = space;
            space = mem[space].getNextNode();


            mem[tempSpace].setNode(mem[head].getData(), mem[head].getNextNode());
            mem[head].setNode(d, tempSpace);
            return;

        }

        int temp = getPrevious(p);
        System.out.println(temp);
        if (temp == -1) return;
        int next = mem[temp].getNextNode();
        int tempSpace = space;
        space = mem[space].getNextNode();
        mem[tempSpace].setNode(d, next);
        mem[temp].setNext(tempSpace);

    }

    @Override
    public Position locate(Data x) {
        if (x == null) return null;
        return (search(x));
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        if (p.getX() < 0 || p.getX() > mem.length) throw new IncorrectPositionException("incorrect index");
        if (p.getX() == head) return mem[head].getData();

        int temp = getPrevious(p);
        if (temp == -1) throw new IncorrectPositionException("incorrect index");
        return mem[temp].getData();
    }

    @Override
    public void delete(Position p) {

    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        if (p.getX() > mem.length) throw new IncorrectPositionException("incorrect index");

        //next (head)
        if (p.getX() == head){
            int temp = mem[head].getNextNode();
            if (temp == -1) throw new IncorrectPositionException("incorrect index");
            else return new Position(temp);
        }

        int temp = getPrevious(p);
        if (temp == -1) throw new IncorrectPositionException("incorrect index");
        else temp = mem[temp].getNextNode();
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
        while (true){
            if (mem[q].getNextNode() == -1){
                return q;
            }
            q = mem[q].getNextNode();
        }
    }

    private Position search(Data x){
        int q = head;
        while (true){

            if (mem[q].getNextNode() == -1){
                return new Position(-1);
            }

            if (mem[q].getData().equals(x)){
                return new Position(q);
            }
            q = mem[q].getNextNode();
        }
    }

    public static void printMem(){
        for (int i = 0; i < mem.length; i++){
            System.out.print(i +  ") ");
            Data d = mem[i].getData();
            if (d != null) d.printData();
            System.out.print(" | next: " + mem[i].getNextNode());
            System.out.println();
        }
        System.out.println();
    }


}
