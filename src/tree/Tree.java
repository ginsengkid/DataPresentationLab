package tree;

public class Tree {

    private static class Node{
        int label;
        Node next;

        public Node(){}

        public Node(int l, Node n){
            label = l;
            next = n;
        }
    }

    private int root;
    private static Node[] array;
    private static int space;


    static {
        array = new Node[50];
        for (int i = 0; i < 49; i++){
            array[i] = new Node(0, array[i+1]);
        }
        space = 0;
    }

    public Tree(){
        root = -1;
    }


}
