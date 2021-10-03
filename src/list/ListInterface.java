package list;

    public interface ListInterface {
    void insert(Data d, Position p);
    Position locate(Node x);
    Node retrieve(Position p) throws IncorrectPositionException;
    void delete(Position p);
    Position next(Position p) throws IncorrectPositionException;
    Position previous(Position p) throws IncorrectPositionException;
    Position first();
    void makeNull();
    void printList();
    Node end();

}
