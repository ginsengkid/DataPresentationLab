package tree;

public class TestTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.create('a');
        Tree.printMem();
        System.out.print("\n\n");


        Tree t1 = new Tree();
        t1.create('b', t);
        Tree.printMem();
        t1.print();
        t.print();

    }

}
