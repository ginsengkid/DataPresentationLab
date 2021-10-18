package array;

public class List implements ArrayInterface {
    private Position End;
    private final Data[] array;

    public List(){
        array = new Data[50];
        End = new Position(0);
    }

    @Override
    public void insert(Data x, Position p) {
        if (End.getX() >= array.length)
            return;

        if (p.getX() >= End.getX() && p.getX() > 1) return;

        for (int i = End.getX(); i >= p.getX(); i--){
            array[i] = array[i-1];
        }
        array[p.getX()-1] = x;
        End.increaseByOne();
    }

    @Override
    public Position locate(Data x) {
        for (int i = 0; i < End.getX(); i++){
            if (array[i].equals(x))
                return (new Position(i + 1));
        }
        return End;
    }

    @Override
    public Data retrieve(Position p) throws IncorrectPositionException {
        if ((p.getX() - 1) > End.getX() || array[p.getX() - 1] == null){
            throw new IncorrectPositionException("Position: " + p.getX() +
                    " out of possible positions: " + (End.getX() + 1));
        }
        return array[p.getX() - 1];
    }

    @Override
    public void delete(Position p) {
        if ((p.getX() - 1) == End.getX() || array[p.getX() - 1] == null)
            return;

        for (int i = p.getX() - 1; i < End.getX() - 1; i++)
            array[i] = array[i + 1];
        End.decreaseByOne();
    }

    @Override
    public Position next(Position p) throws IncorrectPositionException {
        if ((p.getX() - 1) == End.getX() || array[p.getX() - 1] == null)
            throw new IncorrectPositionException("Position: " + p.getX() +
                    " out of possible positions: " + (End.getX() + 1));
        return (new Position(p.getX() + 1));
    }

    @Override
    public Position previous(Position p) throws IncorrectPositionException {
        if ((p.getX() - 1) == End.getX() || array[p.getX() - 1] == null || p.getX() == 1)
            throw new IncorrectPositionException("No position behind " + p.getX());
        return (new Position(p.getX() -1));
    }

    @Override
    public Position first() {
        return new Position(1);
    }

    @Override
    public void makeNull() {
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
        End = new Position(0);
    }

    @Override
    public Position end() {
        return new Position(End.getX() + 1);
    }

    @Override
    public void printList() {
        for (int i = 0; i < End.getX(); i++){
            System.out.print((i + 1) + ": ");
            array[i].printData();
        }
    }

}
