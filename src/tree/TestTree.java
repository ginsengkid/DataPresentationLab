package tree;

public class TestTree {
    public static void main(String[] args) {
        Tree t1 = new Tree();
        t1.create('a');

        Tree t = new Tree();
        t.create('b');

        t1.create('c', t);

        t = new Tree();
        t.create('d');

        Tree t2 = new Tree();
        t2.create('e');

        t.create('f', t2);

        t1.create('G', t);
        Tree.printMem();
        System.out.println();
        System.out.println();
        System.out.println();

        int l1 = t1.leftMostChild(t1.root());
        System.out.println(t1.label(l1));
        System.out.println(t1.label(t1.rightSibling(l1)));
        System.out.println(t1.label(t1.parent(l1)));
        System.out.println(t1.label(t1.parent(t1.rightSibling(l1))));
        System.out.println();

        int l = t1.leftMostChild(l1);
        System.out.println(t1.label(l));
        System.out.println(t1.label(t1.rightSibling(l)));
        System.out.println(t1.label(t1.parent(l)));
        System.out.println(t1.label(t1.parent(t1.rightSibling(l))));
        System.out.println();

        int l2 = t1.rightSibling(l1);
        System.out.println(t1.label(t1.leftMostChild(l2)));
        System.out.println(t1.label(t1.rightSibling(t1.leftMostChild(l2))));
        System.out.println(t1.label(t1.parent(t1.leftMostChild(l2))));
        System.out.println(t1.label(t1.parent(t1.rightSibling(t1.leftMostChild(l2)))));
        System.out.println();




       /* Tree t3 = new Tree();
        t3.create('q');
        l = t3.root();
        System.out.println(t1.label(l));
        System.out.println();*/

    }
}
