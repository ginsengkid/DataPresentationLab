package array;

public interface ArrayInterface {
    void insert(Data x, Position p);
    Position locate(Data x);
    Data retrieve(Position p) throws IncorrectPositionException;
    void delete(Position p);
    Position next(Position p) throws IncorrectPositionException;
    Position previous(Position p) throws IncorrectPositionException;
    Position first();
    void makeNull();
    void printList();
    int end();

}

