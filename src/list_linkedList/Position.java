package list_linkedList;

public class Position {
    private Node x;

    public Position(Node d){
        x = d;
    }

    public Node getNode() {
        return x;
    }

    public void setP(Node p){
        x = p;
    }

    public Node getP() {return x;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position Data = (Position) o;
        return (this.x == Data.x);
    }
}

