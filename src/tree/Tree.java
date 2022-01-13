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
    private final static int len = 10;

    static {
        array = new ArrayNode[len];
        for (int i = 0; i < len-1; i++){
            array[i] = new ArrayNode(i+1);
        }
        space = 0;
        array[len - 1] = new ArrayNode(-1);
    }

    public Tree(){
        root = -1;
    }

    public Tree create(char l){
        if (space == -1) return null;
        if (root != -1) {
            array[space].next = new Node(root, null);
        }
        array[space].label = l;
        root = space;
        space = array[space].name;

        return this;
    }

    public Tree create(char l, Tree t){
        if (space == -1 || t == null) return null;

        if (root == -1) return t.create(l);
        if (t.root == -1) return create(l);

        array[space].label = l;
        array[space].next = new Node(root, new Node(t.root, null));
        root = space;
        space = array[space].name;

        return this;
    }

    public int root(){
        return root;
    }

    public int leftMostChild(int n){
        if (array[n].next == null) return -1;

        if (n == root && array[n].next != null)
            return array[n].next.name;

        int temp = ifInTree(n, root);
        if (temp == -1) return -1;

        else return array[n].next.name;
    }

    public char label(int n){
        if (n == root) return array[n].label;
        int a = ifInTree(n, root);
        if (a != -1) {
            return array[n].label;
        }
        else return '-';
    }

    public int rightSibling(int n){
        if (n == root) return -1;

        int temp = ifInTree(n, root);
        if (temp == -1) return -1;
        if (array[temp].next.next != null) return array[temp].next.next.name;

        return -1;

    }

    public int parent(int n){
        if (n == -1 || n == root || n > len) return -1;
        return ifInTree(n, root);
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

    //return parent
    private int ifInTree(int n, int r){
        Node left = array[r].next;
        if (left == null) return -1;

        if (n == left.name) return r;

        Node right = left.next;
        if (right != null) {
            if (right.name == n)
                return r;
        }

        int temp = ifInTree(n, left.name);

        if (temp == - 1 && right != null) {
            return ifInTree(n, right.name);
        }
        return temp;
    }

}
