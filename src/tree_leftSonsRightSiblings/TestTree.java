package tree_leftSonsRightSiblings;

public class TestTree {
    public static void main(String[] args) {
        Tree t1 = new Tree();
        t1.create('a');

        Tree t = new Tree();
        t.create('b');

        t1.create(t, 'c');

        t = new Tree();
        t.create('d');

        Tree t2 = new Tree();
        t2.create('e');

        t.create(t2, 'f');

        t1.create(t, 'G');
        Tree.printMem();


        t1.print();
        System.out.println(t1.leftMostChild(t1.root()));
    }
}
