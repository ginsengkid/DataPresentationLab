package tree;

public class Tree {

    private static class ArrayNode {
        private int name;
        private Node next;
        private char label;

        public ArrayNode(char l, Node n1, int n2){
            label = l;
            next = n1;
            name = n2;
        }

        public ArrayNode(int n){
            name = n;
        }
    }

    private static class Node{
        private int name;
        private Node next;

        public Node(int n1, Node n2){
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
    }

    public Tree(){
        root = -1;
    }

    //a.create(b,b,'c'); - исключение
    public Tree create(char l){
        if(root != -1){
            return create(l, this);
        }
        root = space;
        space = array[space].name;
        array[root].label = l;
        System.out.println(space);
        return this;
    }

    public Tree create(char l, Tree t){
        //если мы вызываем не на пустом дереве - ошибка, если это не одно и то же дереве
        if (root != -1)
            if (this != t) throw new MyException("Got 2 trees instead of 1 plain and one tree expected");
            else  return t.create(l);
        if (this == t) return t.create(l);

        root = space;
        space = array[space].name;
        array[root].next = new Node(root, new Node(t.root, null));
        array[root].label = l;
        t.root = -1;
        System.out.println(space);
        return this;
    }

    public Tree create(char l, Tree t,Tree t1){
        return this;
    }

    public void print(){
        System.out.println(array[root].label);
    }


}
