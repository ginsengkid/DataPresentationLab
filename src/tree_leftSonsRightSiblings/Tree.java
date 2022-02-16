package tree_leftSonsRightSiblings;

public class Tree {
    private static class Node{
        int name;
        int rightSibling;
        int leftSon;
        char label;
        public Node(int n, int sib, int son, char l){
            name = n;
            rightSibling = sib;
            leftSon = son;
            label = l;
        }
    }

    private static Node[] array;
    private static int space;
    private static final int len = 10;
    private int root;

    static {
        array = new Node[len];
        for (int i = 0; i < len - 1; i ++){
            array[i] = new Node(i + 1, -1, -1, '0');
        }
        array[len - 1] = new Node(-1,-1,-1,'0');
        space = 0;
    }

    public static void printMem(){
        for (int i = 0; i < len; i++){
            System.out.println(i + ") " +
                    array[i].label + " " +
                    array[i].name + " |Left son: " +
                    array[i].leftSon + " |Right Sibling: " +
                    array[i].rightSibling);
        }
        System.out.println();
    }

    public Tree(){
        root = -1;
    }

    public Tree create(char l){
        if (space == -1) return null;
        array[space].label = l;
        if (root != -1) {
            array[space].leftSon = root;
        }
        root = space;
        space = array[space].name;
        return this;
    }

    public Tree create(Tree t, char l){
        if (space == -1) return null;
        if (root == -1) return t.create(l);
        if (t.root == -1) return create(l);
        array[space].label = l;
        array[space].leftSon = root;
        array[root].rightSibling = t.root;
        root = space;
        t.root = -1;
        space = array[space].name;
        return this;
    }

    public void print(){
        System.out.println(array[root].label);
        directBypass(root);
    }

    public int root(){
        return root;
    }

    public int leftMostChild(int n){
        if (root == -1) return -1;
        if (array[root].leftSon == n) return root;
        if (array[root].leftSon == -1) return -1;
        int temp = getParent(n, root);
        if (temp == -1) return temp;
        return array[temp].leftSon;
    }

    private int getParent(int n, int r){
        int q = array[r].leftSon;
        while (q != -1){
            if (n == q) return r;
            //System.out.println(array[q].label);
            int temp = getParent(n, q);
            if (temp != -1)
                return temp;
            q = array[q].rightSibling;
        }
        return -1;
    }


    private void directBypass(int r){
        int q = array[r].leftSon;
        while (q != -1){
            System.out.println(array[q].label);
            if (array[q].leftSon != -1)
                directBypass(q);
            q = array[q].rightSibling;
        }
    }

}
