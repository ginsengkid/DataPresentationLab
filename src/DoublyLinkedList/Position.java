package DoublyLinkedList;

public class Position {
    private Node x;

    Position(Node d){
        x = d;
    }

    public Node getNode() {
        return x;
    }

    public void setP(Node p){
        x = p;
    }

    public boolean equals(Object o) {
        if (o == null && (this.x == null)) return true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return false;
    }
}

