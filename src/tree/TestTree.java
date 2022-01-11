package tree;

public class TestTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.create('a');
        Tree.printMem();
        System.out.println();

        Tree t1 = new Tree();
        t1.create('b');
        Tree.printMem();
        System.out.println();

        t1.create('c', t);
        Tree.printMem();
        System.out.println();

        t = new Tree();
        t.create('d');

        Tree t2 = new Tree();
        t2.create('e');

        t.create('f', t2);

        t1.create('G', t);
        Tree.printMem();


        System.out.println(t1.root());
        int l = t1.leftMostChild(t1.leftMostChild(t1.root()));
        System.out.println(t1.label(l));
    }

}
