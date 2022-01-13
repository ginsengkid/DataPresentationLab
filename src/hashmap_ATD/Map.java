package hashmap_ATD;
import list_linkedList.*;

public class Map {
    public static class RangeType {
        private char[] c;
        public final static char NODEF = '?';
        public final static char FIRST = 'A';
        public final static char LAST = 'Z';

        public RangeType(char[] x) {
            c = x;
        }

        public void Print() {
            System.out.printf("%3c", c[0]);
        }

        public char[] getC() {
            return c;
        }
    }

    List l;

    public Map(){
        l = new List();
    }

    public void makeNull(){
        l.makeNull();
    }

    public void assign(char[] d, char[] r) {
        if (l.first().equals(l.end())) {
            l.insert(new Data(d, r), l.first());
            return;
        }

        Position q = l.first();
        try {
            while (!q.equals(l.end())){
                Data temp = l.retrieve(q);
                if (temp.compareCharArrays(d, temp.getName())) {
                    q.getNode().getData().setAddress(r);
                    return;
                }
                q = l.next(q);
            }
        }
        catch (Exception e){ e.printStackTrace();}

        l.insert(new Data(d,r),l.first()) ;
    }

    public boolean compute(char[] d, char[] r) {
        if (l.first().equals(l.end()))
            return false;

        Position q = l.first();
        try {
            while (!q.equals(l.end())){
                Data temp = l.retrieve(q);
                if (temp.compareCharArrays(d, temp.getName())) {
                    q.getNode().getData().setAddress(r);
                    return true;
                }
                q = l.next(q);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void print(){
        l.printList();
    }

}
