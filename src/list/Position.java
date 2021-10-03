package list;

public class Position {
    private Node x;

    Position(Node d){
        x = d;
    }

    public Node getX() {
        return x;
    }

    public Position getP(){
        return this;
    }

    public void setP(Node p){
        if (p == null) {
            x = null;
            return;
        }
        x = p;
    }
}
