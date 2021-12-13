package tree;

public class TestTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.create('a');
        t.print();

        Tree t1 = new Tree();
        t1.create('b', t);
        t1.print();


    }

}
