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
        if (array[temp].next != null && array[temp].next.next != null) return array[temp].next.next.name;

        return -1;
    }

    public int parent(int n){
        if (n == -1 || n == root || n > len) return -1;
        return ifInTree(n, root);
    }

    public void print(){
        if (root == -1)return;
        System.out.println(root);
        directBypass(root);
        System.out.println();
    }

    public void makeNull(){
        if (root == -1) return;
        indirectBypass(root);
        array[root].name = space;
        space = root;
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
        Node q = array[r].next;

        while (q != null){
            if (q.name == n) return r;

            int temp = ifInTree(n, q.name);
            if (temp == -1)
                q = q.next;
            else return temp;
        }
        return -1;

    }

    private void directBypass(int r){
        Node q = array[r].next;

        while (q != null){
            System.out.println(q.name);
            if (array[q.name].next != null) {
                directBypass(q.name);
            }
            q = q.next;
        }
    }

    private void indirectBypass(int r){
        Node q = array[r].next;

        while (q != null){

            if (array[q.name].next != null) {
                indirectBypass(q.name);
            }
            int temp = array[q.name].name;
            array[q.name].name = space;
            space = temp;
            q = q.next;

        }
    }


}
