package cursorslist;

public class Node {
    private Data data;
    private int next = -1;

    public Node(Data d) {
        data = new Data(d.getName(),d.getAddress());
    }

    public Node(int n) {
        next = n;
    }

    public int getNextNode() {
        return next;
    }

    public void setNext(int x) {
        this.next = x;
    }

    public void setData(Data D ){
        this.data = D;
    }

    public Data getData(){
        return data;
    }

    public void setNode(Data D, int x){
        this.next = x;
        this.data = D;
    }

}

