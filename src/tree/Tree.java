package tree;

public class Tree {

    private static class ArrayNode {
        private int name;
        private Node next;
        private char label;

        public ArrayNode(char l, Node n1, int n2){
            label = l;
            next = n1;

        }
        public ArrayNode(int n){
            name = n;
        }
    }

    private static class Node{
        private int name;
        private Node next;

        public Node(int n1, Node n2) {
            name = n1;
            next = n2;
        }
    }

    private int root;
    private static ArrayNode[] array;
    private static int space;
    private final static int len = 50;

    static {
        array = new ArrayNode[len];
        for (int i = 0; i < len-1; i++){
            array[i] = new ArrayNode(i+1);
        }
        space = 0;
        array[49] = new ArrayNode(-1);
    }

    public Tree(){
        root = -1;
    }

    public Tree create(char l){
        if (space == -1) return null;
        if (root == -1) {
            root = space;
            space = array[space].name;
            array[root].label = l;
        }
        else {
            int temp = space;
            space = array[space].name;
            array[temp].label = l;
            array[temp].next = new Node(root, null);
            root = temp;
        }
        return this;
    }

    public Tree create(char l, Tree t){
        if (space == -1) return null;

        if (root == -1) return t.create(l);
        if (t.root == -1) return create(l);

        int temp = space;
        space = array[space].name;
        array[temp].label = l;
        array[temp].next = new Node(root, new Node(t.root, null));
        root = temp;
        return this;
    }

    public int root(){
        return root;
    }

    public int leftMostChild(int n){
        if (array[n].next == null) return -1;
        if (array[n].next.next == null) return -1;
        if (n == root && array[n].next != null)
            return array[n].next.name;
        int temp = ifInTree(n, root);
        if (temp == -1) return -1;
        else return array[n].next.name;
    }

    public char label(int n){
        int a = ifInTree(n, root);
        System.out.println(a);
        if (a != -1) return array[n].label;
        else return ' ';
    }

    public void print(){

    }

    public static void printMem(){
        for (int i = 0; i < len; i ++){
            if (array[i].label == ' ') continue;
            System.out.print(array[i].label + " " + array[i].name);
            if (array[i].next !=  null) {
                System.out.print(" " + array[i].next.name);
                if (array[i].next.next != null){
                    System.out.print(" " + array[i].next.next.name);
                }
            }

            System.out.println();
        }
    }

    private int ifInTree(int n, int r){
        Node left = array[r].next;
        if (left == null) return -1;

        if (n == left.name) return r;


        Node right = left.next;
        if (right != null) {
            if (right.name == n)
                return r;
        }
        else return -1;


        ifInTree(n, left.name);
        ifInTree(n, right.name);
        return -1;
    }

}
